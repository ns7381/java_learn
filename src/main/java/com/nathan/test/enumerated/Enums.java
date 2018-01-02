package com.nathan.test.enumerated;

import java.util.Random;

/**
 * Created by nathan on 17/1/11.
 */
public class Enums {
    private static Random random = new Random(47);
    static <T extends Enum> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }

    private static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }

    enum Activity {
        RUNNING, STOP, STOPPED, DEAD
    }

    class Test {

    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class));
        }
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("------");
        }
    }

    interface Food {
        enum App implements Food {
            SALAD, SOUP
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO
        }
    }
    enum Course {
        APP(Food.App.class),
        Main(Food.MainCourse.class);
        private Food[] values;
        private Course(Class<? extends Food> kind) {
            values = kind.getEnumConstants();
        }

        public Food randomSelection() {
            return Enums.random(values);
        }
    }
}
