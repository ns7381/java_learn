package com.nathan.learn.spring.exception;

public class SyncJobRuntimeException extends RuntimeException {

    private int errorCode ;
    private String message ;
    private Object data ;

    /**
     * @param errorType errorType
     */
    public SyncJobRuntimeException(ErrorType errorType) {
        super(errorType.getErrorMsg());
        this.errorCode = errorType.getCode();
        this.message = errorType.getErrorMsg();
    }

    public static SyncJobRuntimeException asThreadInterruptedException() {
        return new SyncJobRuntimeException(ErrorType.THREAD_INTERRUPTED_ERROR);
    }

    /**
     * @param message message
     */
    public SyncJobRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * @param cause cause
     */
    public SyncJobRuntimeException(Throwable cause) {
        super(cause);
        this.errorCode = ErrorType.UNKNOWN_ERROR.getCode();
        this.message = ErrorType.UNKNOWN_ERROR.getErrorMsg();
    }


    public SyncJobRuntimeException(ErrorType errorType, Object data) {
        this(errorType);
        this.data = data;
    }

    public SyncJobRuntimeException(ErrorType errorType, Throwable cause) {
        super(errorType.getErrorMsg(), cause);
        this.errorCode = errorType.getCode();
        this.message = errorType.getErrorMsg();
    }

    public SyncJobRuntimeException(ErrorType errorType, String msg, Throwable cause) {
        super(errorType.getErrorMsg(), cause);
        this.errorCode = errorType.getCode();
        this.message = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

