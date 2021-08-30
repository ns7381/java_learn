package com.nathan.learn.netty.rpc.netty;

public class MessageLoop {

    // List of inboxes with pending messages, to be processed by the message loop.
    private val active = new LinkedBlockingQueue[Inbox]()

    // Message loop task; should be run in all threads of the message loop's pool.
    protected val receiveLoopRunnable = new Runnable() {
        override def run(): Unit = receiveLoop()
    }

    protected val threadpool: ExecutorService

    private var stopped = false

    def post(endpointName: String, message: InboxMessage): Unit

    def unregister(name: String): Unit

    def stop(): Unit = {
        synchronized {
            if (!stopped) {
                setActive(MessageLoop.PoisonPill)
                threadpool.shutdown()
                stopped = true
            }
        }
        threadpool.awaitTermination(Long.MaxValue, TimeUnit.MILLISECONDS)
    }

    protected final def setActive(inbox: Inbox): Unit = active.offer(inbox)

    private def receiveLoop(): Unit = {
        try {
            while (true) {
                try {
                    val inbox = active.take()
                    if (inbox == MessageLoop.PoisonPill) {
                        // Put PoisonPill back so that other threads can see it.
                        setActive(MessageLoop.PoisonPill)
                        return
                    }
                    inbox.process(dispatcher)
                } catch {
                    case NonFatal(e) => logError(e.getMessage, e)
                }
            }
        } catch {
            case _: InterruptedException => // exit
            case t: Throwable =>
                try {
                    // Re-submit a receive task so that message delivery will still work if
                    // UncaughtExceptionHandler decides to not kill JVM.
                    threadpool.execute(receiveLoopRunnable)
                } finally {
                    throw t
                }
        }
    }
}
