package com.nathan.learn.base.grammar.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 17/6/19.
 */
public class AnnotationLearn {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExceptionTest {
        Class<? extends Exception>[] value();
    }

    public static class Sample {
        @ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
        public static void doublyBad() {
            List<String> list = new ArrayList<>();
            list.addAll(5, null);
        }
    }

    public static class RunTests {
        public static void main(String[] args) throws ClassNotFoundException {
            int test = 0;
            int passed = 0;
            Class<?> sample = Class.forName("com.base.grammar.AnnotationLearn$Sample");
            for (Method method : sample.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ExceptionTest.class)) {
                    test++;
                    try {
                        method.invoke(null);
                        System.out.println("Test failed!");
                    } catch (Throwable e) {
                        Throwable cause = e.getCause();
                        Class<? extends Exception>[] value = method.getAnnotation(ExceptionTest.class).value();
                        int oldPassed = passed;
                        for (Class<? extends Exception> aClass : value) {
                            if (aClass.isInstance(cause)) {
                                passed++;
                                break;
                            }
                        }
                        if (passed == oldPassed) {
                            System.out.println("Test failed!");
                        }
                        System.out.println(passed);
                    }

                }
            }
        }
    }

}
