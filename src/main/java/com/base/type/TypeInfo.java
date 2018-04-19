package com.base.type;

import com.base.reuse.BookFacade;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nathan on 16/8/31.
 */
public class TypeInfo {

    List<Class<BookFacade>> classes = Collections.unmodifiableList(Arrays.asList(BookFacade.class));
    List<Class<BookFacade>> classes1 = classes.subList(classes.indexOf(BookFacade.class), classes.size());
}
