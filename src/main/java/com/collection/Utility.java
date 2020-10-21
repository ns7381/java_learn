package com.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by nathan on 16/12/26.
 */
public class Utility {
    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5, 23, 12);
        List<Integer> test2 = Arrays.asList(1, 2, 3, 4, 5, 23, 13);
        System.out.println(Collections.max(test1));
        System.out.println(Collections.disjoint(test1, test2));
        Collections.copy(test1, test2);
        System.out.println(test1);
        List<Integer> test3 = Collections.unmodifiableList(test1);
//        test3.add(4);
        System.out.println(test3);
        Collections.synchronizedList(test2);

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.entrySet();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        list.add(1);
        Integer next = iterator.next();
    }
}
