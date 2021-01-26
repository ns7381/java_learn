package com.nathan.learn.collection.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by nathan on 16/12/3.
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count%3==0) {
            result += "/n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return i < o.i ? -1 : (i == o.i ? 0 : 1);
    }

    private static Random r = new java.util.Random(48);
    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
    }
}
