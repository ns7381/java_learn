package com.nathan.test.two;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nathan on 17/6/3.
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void testPublic(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }

    private <T> T testPrivate(Class<T> type) {
        new Test();
        return type.cast(favorites.get(type));
    }
    protected  <T> T testProtected(Class<T> type) {
        new Test();
        return type.cast(favorites.get(type));
    }
    <T> T testFriend(Class<T> type) {
        new Test();
        return type.cast(favorites.get(type));
    }
}
