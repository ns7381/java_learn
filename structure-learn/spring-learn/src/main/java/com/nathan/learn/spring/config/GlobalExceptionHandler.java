package com.nathan.learn.spring.config;

import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import com.nathan.learn.spring.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result exceptionHandler(MethodArgumentNotValidException e) {
        logger.error("### MethodArgumentNotValidException Exception Caught", e);
        Map<String, String> errs = e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return Result.Builder.err().withData(errs).build();
    }


    @ExceptionHandler(value = {SyncJobRuntimeException.class})
    public Result exceptionHandler(SyncJobRuntimeException e) {
        logger.error("### RTRuntimeException Exception Caught:{}", e.getData(), e);
        return Result.Builder.err().withException(e).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> handleException(Exception e) {
        logger.error("### Global Exception Caught", e);
        return new ResponseEntity<>(Result.Builder.err().withMessage(e.toString()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
