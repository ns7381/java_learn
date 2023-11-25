package com.nathan.learn.base.grammar;


import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nathan on 16/8/31.
 */
public class TypeInfo {

    List<Class<Book>> classes = Collections.unmodifiableList(Arrays.asList(Book.class));
    List<Class<Book>> classes1 = classes.subList(classes.indexOf(Book.class), classes.size());

    public static void main(String[] args) {
        Field[] declaredFields = Book.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
            System.out.println(declaredField.getType().getName());
            System.out.println(declaredField.getType().getSimpleName());
            System.out.println(declaredField.getType().getTypeName());
        }
    }
}

@Data
class Book {
    private String test1;
    private int test2;
    private Integer test3;


}
