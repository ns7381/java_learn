package com.nathan.learn.spring.exception;

public enum ErrorType {
    UNKNOWN_ERROR(1_000, "未知错误"),
    SOURCE_PATH_NOT_EXIST_ERROR(1_001, "源目录不存在"),
    HDFS_PATH_NOT_LEGAL_ERROR(1_002, "HDFS路径不合法"),
    HDFS_PATH_REQUEST_ERROR(1_003, "请求HDFS路径的nn地址接口返回报错"),
    HDFS_PATH_NOT_ACTIVE_ERROR(1_004, "HDFS路径所在集群NameNode节点均未active"),
    HDFS_PATH_NN_NOT_FOUND_ERROR(1_005, "未找到HDFS路径所在集群的NameNode节点"),
    YARN_NOT_ACTIVE(1_006, "Yarn RM节点均非active状态"),
    THREAD_INTERRUPTED_ERROR(1_010, "线程休眠被打断异常"),
    THREAD_POOL_UNCAUGHT_EXCEPTION_ERROR(1_011, "线程池线程为未捕获异常"),
    JSON_TRANSFORM_ERROR(2_002,"JSON 操作异常"),
    HTTP_INVOKE_ERROR(2_003,"HTTP 操作异常");

    int code;
    String errorMsg;

    ErrorType(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
