package com.nathan.learn.spring.entity;

import org.springframework.data.domain.Sort;

public class SortConstant {
    public static final Sort CREATED_AT = Sort.by(Sort.Direction.DESC, "createdAt");
}
