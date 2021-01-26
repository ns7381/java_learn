package com.nathan.learn.spring.threadpool;

import com.nathan.learn.spring.exception.ErrorType;
import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ThreadHandler implements SyncJobUncaughtExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ThreadHandler.class);

    private Integer exitCode = 0;

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        logger.error("SyncJob Thread pool's thread[{}] caught Exception Error. ", thread.getName());
        if (throwable instanceof SyncJobRuntimeException) {
            SyncJobRuntimeException rtRuntimeException = (SyncJobRuntimeException) throwable;
            logger.error("thread[{}] throws Exception Error. ", thread.getName());
            exitCode = rtRuntimeException.getErrorCode();
        }
        if (throwable instanceof InterruptedException) {
            logger.error("thread[{}] throws InterruptedException. ", thread.getName());
            exitCode = ErrorType.THREAD_INTERRUPTED_ERROR.getCode();
            thread.interrupt();
        }else {
            logger.error("thread[{}] throws Unexpected Exception. ", thread.getName(), throwable);
            exitCode = 1;
        }

    }

    public static String getExceptionMessage(Exception e) {

        if (e.getMessage() != null) {
            return e.getMessage();
        }

        if (e.getCause() != null) {
            if (e.getCause().getMessage() != null) {
                return e.getCause().getMessage();
            }else {
                return e.getCause().toString();
            }
        }
        return e.toString();
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public static void sleep1s( ) {
        sleep(1);
    }

    public static void sleep2s( ) {
        sleep(2);
    }

    public static void sleep3s( ) {
        sleep(3);
    }

    public static void sleep5s( ) {
        sleep(5);
    }

    public static void sleep10s( ) {
        sleep(5);
    }

    public static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw SyncJobRuntimeException.asThreadInterruptedException();
        }
    }
}
