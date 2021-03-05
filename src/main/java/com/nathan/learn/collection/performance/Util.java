package com.nathan.learn.collection.performance;
import org.apache.lucene.util.RamUsageEstimator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util {

    static Random R = new Random();

    public static void calculateObjectSize(Object o) {
        //计算指定对象本身在堆空间的大小，单位字节
        long shallowSize = RamUsageEstimator.shallowSizeOf(o);
        //计算指定对象及其引用树上的所有对象的综合大小，单位字节
        long size = RamUsageEstimator.sizeOf(o);
        //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
        String humanSize = RamUsageEstimator.humanSizeOf(o);
//        System.out.println("shallowSize: " + shallowSize);
//        System.out.println("size: " + size);
        System.out.println("humanSize: " + humanSize);
    }

    public static List<String> getRandomPath(int size) {
        List<String> tables = getRandomKeys(size);
        List<String> dbs = getRandomKeys(100);
        List<String> market = getRandomKeys(50);
        List<String> rooms = getRandomKeys(10);
        return tables.stream().map(s -> ("/" + rooms.get(nextInt(10)) +
                "/" + market.get(nextInt(10)) +
                "/" + dbs.get(nextInt(10)) +
                "/" + s)).collect(Collectors.toList());
    }
    public static List<String> getRandomKeys(int size) {
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < size; i++) {
            list.add(nextString(nextInt(4, 20)));
        }
        return list;
    }

    public static String nextString(int len) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c;
            if (i == 0 && nextBoolean()) {
                c = (char) nextInt('A', 'Z' + 1);
            } else {
                c = (char) nextInt('a', 'z' + 1);
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static boolean nextBoolean() {
        return R.nextBoolean();
    }

    public static int nextInt(int n) {
        return R.nextInt(n);
    }

    public static int nextInt(int min, int max) {
        return min + R.nextInt(max - min);
    }
}

