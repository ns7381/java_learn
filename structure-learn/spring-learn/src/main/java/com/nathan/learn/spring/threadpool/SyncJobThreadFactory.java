package com.nathan.learn.spring.threadpool;

import com.nathan.learn.spring.exception.ErrorType;
import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class SyncJobThreadFactory implements ThreadFactory {

    private Logger logger = LoggerFactory.getLogger(SyncJobThreadFactory.class);

    static final AtomicInteger poolNumber = new AtomicInteger(1);

    final AtomicInteger threadNumber = new AtomicInteger(1);

    final String namePrefix;

    final ThreadGroup defaultGroup;

    private SyncJobUncaughtExceptionHandler uncaughtExceptionHandler;

    public SyncJobThreadFactory(String name) {
        this(name, null);
    }

    public SyncJobThreadFactory(String name, SyncJobUncaughtExceptionHandler handler) {
        namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
        defaultGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(), "PLRT-Group");
        if (handler == null) {
            this.uncaughtExceptionHandler = (t, e) -> {
                logger.error("Default uncaughtExceptionHandler.", e);
                throw new SyncJobRuntimeException(ErrorType.THREAD_POOL_UNCAUGHT_EXCEPTION_ERROR, e);
            };
        } else{
            this.uncaughtExceptionHandler = handler;
        }
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(defaultGroup, r, namePrefix + threadNumber.getAndIncrement());
        t.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        if (t.isDaemon()) {
            t.setDaemon(true);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }

        return t;
    }
}
