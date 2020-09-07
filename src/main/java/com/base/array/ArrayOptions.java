package com.base.array;

import java.util.Arrays;

/**
 * Created by nathan on 16/11/30.
 */
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()}));

        int[][][] c = new int[2][2][2];
        System.out.println(Arrays.deepToString(c));
    }
}
