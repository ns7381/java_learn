package com.nathan.learn.base.grammar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nathan on 17/1/23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlString {
    int value() default 0;
    String name() default "";

    Constraints constrains() default @Constraints;
}
