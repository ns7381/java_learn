package com.nathan.learn.collection;

import java.util.*;

/**
 * Created by nathan on 16/12/7.
 */
public class Fill {
    public static void main(String[] args) {
        LinkedHashSet<String> strings = new LinkedHashSet<>(CollectionData.list(new Government(), 15));
        System.out.println(strings);
    }
}

interface Generator<T> {
    T next();
}
class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for(int i=0; i<quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}

class Government implements Generator<String> {
    String[] foundation = ("sfdsfs fsdfewfrg tge sew e sfrg rg threw ewf egr gtr hre" +
            "sdsfsf gfd ger grgtr ere rwe wef tnfgfgd wewe wr ere").split(" ");
    int index;
    @Override
    public String next() {
        return foundation[index++];
    }
}

class Countries {
    public static final String[][] DATA = {{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};

    private static class FlyweightMap extends AbstractMap<String, String> {
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return null;
        }

        private static class Entry implements Map.Entry<String, String>{
            @Override
            public String getKey() {
                return null;
            }

            @Override
            public String getValue() {
                return null;
            }

            @Override
            public String setValue(String value) {
                return null;
            }
        }
    }
}