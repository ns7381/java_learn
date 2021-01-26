package com.nathan.learn.collection.array;

/**
 * Created by nathan on 16/12/2.
 */
class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}
class MethodParameter<T> {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}
public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 3, 43, 45};
        Integer[] f = new ClassParameter<Integer>().f(ints);
        System.out.println(f);
        Integer[] f1 = MethodParameter.f(ints);
        System.out.println(f1);
        String hi = new String("hi");
        String shi = new String("hi");
        System.out.println(hi.equals(shi));
        System.out.println("hi".equals("hi"));
    }
}
