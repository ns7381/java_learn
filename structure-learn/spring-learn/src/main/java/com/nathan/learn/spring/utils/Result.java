package com.nathan.learn.spring.utils;

import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import lombok.Data;

@Data
public class Result {

    private boolean success;

    private int code;

    private String message;

    private Object data;

    private Result(Builder builder) {
        this.code = builder.code;
        this.success = builder.success;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static class Builder {

        public static Builder ok() {
            return new Builder();
        }

        public static Builder err() {
            return new Builder().error();
        }

        private boolean success = true;

        private int code = 0;

        private String message;

        private Object data;

        private Builder() {
        }

        public Builder error() {
            this.success = false;
            this.code = -1;
            return this;
        }

        public Builder withException(SyncJobRuntimeException exception) {
            this.code = exception.getErrorCode();
            this.message = exception.getMessage();
            this.data = exception.getData();
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withData(Object data) {
            this.data = data;
            return this;
        }

        public Result build() {
            return new Result(this);
        }


    }
}
