package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by nathan on 18/1/3.
 */
public class DirectMemOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe un = (Unsafe) unsafeField.get(null);
        while (true) {
            un.allocateMemory(_1MB);
        }
    }
}
