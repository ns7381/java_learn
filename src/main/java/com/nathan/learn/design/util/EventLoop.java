/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.design.util;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * An event loop to receive events from the caller and process all events in the event thread. It
 * will start an exclusive event thread to process all events.
 * <p>
 * Note: The event queue will grow indefinitely. So subclasses should make sure `onReceive` can
 * handle events in time to avoid the potential OOM.
 */
@Slf4j
public abstract class EventLoop<E> {
    private String name;

    public EventLoop(String name) {
        this.name = name;
    }

    private BlockingQueue<E> eventQueue = new LinkedBlockingDeque<>();

    private AtomicBoolean stopped = new AtomicBoolean(false);

    // Exposed for testing.
    private Thread eventThread = new Thread(() -> {
        try {
            while (!stopped.get()) {
                E event = eventQueue.take();
                try {
                    onReceive(event);
                } catch (Exception e) {
                    try {
                        onError(e);
                    } catch (Exception ie) {
                        log.error("Unexpected error in " + name, ie);
                    }
                }
            }
        } catch (InterruptedException ie) {
            // exit even if eventQueue is not empty
        } catch (Exception e) {
            log.error("Unexpected error in " + name, e);
        }
    });

    public void start() {
        if (stopped.get()) {
            throw new IllegalStateException(name + " has already been stopped");
        }
        // Call onStart before starting the event thread to make sure it happens before onReceive
        onStart();
        eventThread.setDaemon(true);
        eventThread.start();
    }

    public void stop() {
        if (stopped.compareAndSet(false, true)) {
            eventThread.interrupt();
            boolean onStopCalled = false;
            try {
                eventThread.join();
                // Call onStop after the event thread exits to make sure onReceive happens before onStop
                onStopCalled = true;
                onStop();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                if (!onStopCalled) {
                    // ie is thrown from `eventThread.join()`. Otherwise, we should not call `onStop` since
                    // it's already called.
                    onStop();
                }
            }
        } else {
            // Keep quiet to allow calling `stop` multiple times.
        }
    }

    /**
     * Put the event into the event queue. The event thread will process it later.
     */
    public void post(E event) throws InterruptedException {
        if (!stopped.get()) {
            if (eventThread.isAlive()) {
                eventQueue.put(event);
            } else {
                onError(new IllegalStateException(name + " has already been stopped accidentally."));
            }
        }
    }

    /**
     * Return if the event thread has already been started but not yet stopped.
     */
    public boolean isActive() {
        return eventThread.isAlive();
    }

    /**
     * Invoked when `start()` is called but before the event thread starts.
     */
    protected void onStart() {
    }

    /**
     * Invoked when `stop()` is called and the event thread exits.
     */
    protected void onStop() {
    }

    /**
     * Invoked in the event thread when polling events from the event queue.
     * <p>
     * Note: Should avoid calling blocking actions in `onReceive`, or the event thread will be blocked
     * and cannot process events in time. If you want to call some blocking actions, run them in
     * another thread.
     */
    protected abstract void onReceive(E event);

    /**
     * Invoked if `onReceive` throws any non fatal error. Any non fatal error thrown from `onError`
     * will be ignored.
     */
    protected abstract void onError(Throwable e);

}