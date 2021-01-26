package com.nathan.learn.spring.threadpool;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadPoolCreator {

    private static final Integer BASE_POOL_CORE_SIZE = Runtime.getRuntime().availableProcessors();
    private static final Integer BASE_POOL_MAX_SIZE = BASE_POOL_CORE_SIZE * 3;

    private static final Integer LARGER_POOL_CORE_SIZE = 10;
    private static final Integer LARGER_POOL_MAX_SIZE = 30;

    private static final Long DEFAULT_KEEP_ALIVE_TIME_SECONDS = 30L;

    private ThreadPoolCreator() {
    }

    /**
     * 已经创建线程池,栈，后来者先关闭
     */
    private static Stack<ThreadPoolExecutor> threadPoolExecutorStack = new Stack<>();

    public static ThreadPoolExecutor create(String poolName, Integer corePoolSize, Integer maxPoolSize, SyncJobUncaughtExceptionHandler handler) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                DEFAULT_KEEP_ALIVE_TIME_SECONDS,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new SyncJobThreadFactory(poolName, handler),
                new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolExecutorStack.push(poolExecutor);
        return poolExecutor;
    }

    /**
     *  shutdownAllPool
     */
    public static final void shutdownAllPool() {
        while (!threadPoolExecutorStack.empty()) {
            ThreadPoolExecutor poolExecutor = threadPoolExecutorStack.pop();
            if (poolExecutor.isShutdown()) {
                continue;
            }
            poolExecutor.shutdownNow();
        }
    }

    public static ScheduledThreadPoolExecutor createScheduledThreadPoolExecutor(int corePoolSize, String poolName, SyncJobUncaughtExceptionHandler handler) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(corePoolSize, new SyncJobThreadFactory(poolName, handler));
        threadPoolExecutorStack.push(executor);
        return executor;
    }

    public static ScheduledThreadPoolExecutor createSingleScheduledThreadPoolExecutor(String poolName) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new SyncJobThreadFactory(poolName, null));
        return executor;
    }

    public static ThreadPoolExecutor createBaseThreadPool(String poolName, SyncJobUncaughtExceptionHandler handler) {
        return create(poolName, BASE_POOL_CORE_SIZE, BASE_POOL_MAX_SIZE, handler);
    }

    public static ThreadPoolExecutor createBaseThreadPool(String poolName) {
        return createBaseThreadPool(poolName, null);
    }

    public static ThreadPoolExecutor createFixedThreadPool(String poolName, Integer size, SyncJobUncaughtExceptionHandler handler) {
        return create(poolName, size, size, handler);
    }

    public static ThreadPoolExecutor createFixedThreadPool(String poolName, Integer size) {
        return create(poolName, size, size, null);
    }

    public static ThreadPoolExecutor createLargerThreadPool(String poolName, SyncJobUncaughtExceptionHandler handler) {
        return create(poolName, LARGER_POOL_CORE_SIZE, LARGER_POOL_MAX_SIZE, handler);
    }

    public static ThreadPoolExecutor createLargerThreadPool(String poolName) {
        return createLargerThreadPool(poolName, null);
    }
}
