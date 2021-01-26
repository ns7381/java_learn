package com.nathan.learn.base.grammar;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nathan on 16/8/31.
 */
public class TypeInfo {

    List<Class<Book>> classes = Collections.unmodifiableList(Arrays.asList(Book.class));
    List<Class<Book>> classes1 = classes.subList(classes.indexOf(Book.class), classes.size());
}
class Book {

}
