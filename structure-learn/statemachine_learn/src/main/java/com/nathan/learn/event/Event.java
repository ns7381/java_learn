package com.nathan.learn.event;

/**
 * Interface defining events api.
 */
public interface Event<TYPE extends Enum<TYPE>> {

    TYPE getType();

    long getTimestamp();

    String toString();
}
