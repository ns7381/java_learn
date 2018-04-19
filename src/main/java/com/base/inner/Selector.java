package com.base.inner;

/**
 * Created by nathan on 16/8/11.
 */
public interface Selector {
    boolean end();

    Object current();

    void next();
}
