package com.nathan.test.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nathan on 16/12/3.
 */
class ConvertTo{
    public static boolean[] primitive(Boolean[] in) {
        boolean[] result = new boolean[in.length];
        for (int i = 0; i<in.length; i++){
            result[i] = in[i];
        }
        return result;
    }
}

class CollectionData<T> extends ArrayList<T> {
    CollectionData(Generator<T> gen, int quantity) {
        for(int i=0; i<quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
class Generated {
    static <T> T[] array(T[] a, Generator<T> generator) {
        return new CollectionData<T>(generator, a.length).toArray(a);
    }

    static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}
public class PrimitiveConversionDemonStration {
    public static void main(String[] args) {
        Boolean[] array = Generated.array(Boolean.class, new CountingGenerator.Boolean(), 15);
        System.out.println(Arrays.toString(array));
    }
}
