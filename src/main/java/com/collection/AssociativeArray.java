package com.collection;

/**
 * Created by nathan on 16/12/25.
 */
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int index) {
        pairs = new Object[index][2];
    }

    public void put(K k, V v) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException("index out");
        }
        pairs[index++] = new Object[]{k, v};
    }

    public V get(K k) {
        for(int i=0; i<index; i++) {
            if (k.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> tests = new AssociativeArray<>(6);
        tests.put("a", "12");
        tests.put("ab", "123");
        tests.put("abc", "1234");
        tests.put("abcd", "12345");
        System.out.println(tests.get("a"));
    }
}
