package com.nathan.learn.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by nathan on 16/12/26.
 */
public class Utility {
    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(11, 12, 13, 14, 15, 123, 112);
        List<Integer> test2 = Arrays.asList(1, 2, 3, 4, 5, 23, 13);
        List<Integer> objects = new ArrayList<>(20);
        objects.addAll(test1);
        objects.addAll(test2);
        System.out.println(objects);
        Long.parseLong("abc");
    }
}
