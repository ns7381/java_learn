package com.base.array;



/**
 * Created by nathan on 16/12/2.
 */
interface Generator<T>{
    T next();
}
class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = true;

        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    static char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static class Character implements Generator<java.lang.Character> {
        int index = -1;

        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }
}

class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.println(type.getSimpleName());
            try {
                Generator<?> g = (Generator<?>) type.newInstance();
                for(int i = 0; i<size; i++) {
                    System.out.println(g.next());
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }
}