package com.nathan.learn.spring.utils;

import com.nathan.learn.spring.config.ApplicationContextHolder;
import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static com.nathan.learn.spring.exception.ErrorType.HTTP_INVOKE_ERROR;
import static com.nathan.learn.spring.exception.ErrorType.JSON_TRANSFORM_ERROR;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static JSONObject getWithRetry(final String url) {
        int count = 0;
        int maxTries = 3;
        RestTemplate restTemplate = ApplicationContextHolder.getBean(RestTemplate.class);
        while (true) {
            try {
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
                return new JSONObject(responseEntity.getBody());
            } catch (RestClientException e) {
                if (++count == maxTries) {
                    logger.error("HTTP request url {} error, {} time retry.", url, count);
                    logger.error("Error: ", e);
                    if (e instanceof HttpClientErrorException.NotFound) {
                        throw e;
                    } else {
                        throw new SyncJobRuntimeException(HTTP_INVOKE_ERROR);
                    }
                }
            } catch (JSONException e) {
                if (++count == maxTries) {
                    logger.error("HTTP request url {} error, {} time retry.", url, count);
                    logger.error("Error: ", e);
                    throw new SyncJobRuntimeException(JSON_TRANSFORM_ERROR);
                }
            }
        }
    }

    public static <T> T getWithRetry(final String url, Class<T> clazz) {
        int count = 0;
        int maxTries = 3;
        RestTemplate restTemplate = ApplicationContextHolder.getBean(RestTemplate.class);
        while (true) {
            try {
                return restTemplate.getForObject(url, clazz);
            } catch (RestClientException e) {
                logger.error("HTTP request url {} error, {} time retry.", url, count);
                if (++count == maxTries) {
                    logger.error("Error: ", e);
                    throw new SyncJobRuntimeException(HTTP_INVOKE_ERROR);
                }
            }
        }
    }
}
