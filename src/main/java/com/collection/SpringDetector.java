package com.collection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by nathan on 16/12/26.
 */
public class SpringDetector {

    static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> constructor = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for(int i=0; i<10; i++) {
            map.put(constructor.newInstance(i), new Prediction());
        }
        System.out.println(map);
        if (map.containsKey(constructor.newInstance(3))) {
            System.out.println(map.get(constructor.newInstance(3)));
        } else {
            System.out.println("not find");
        }
    }
    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}


class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Groundhog groundhog = (Groundhog) o;

        return number == groundhog.number;

    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Groundhog{" +
                "number=" + number +
                '}';
    }
}

class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "winter";
        } else {
            return "spring";
        }
    }
}