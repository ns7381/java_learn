package com.nathan.learn.base.enumerated;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by nathan on 17/1/12.
 */
interface Commnad {
    void action();
}
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<Language, Commnad> map = new EnumMap<>(Language.class);
        map.put(Language.CN, () -> System.out.println("cncncn"));
        for (Map.Entry<Language, Commnad> entry : map.entrySet()) {

            System.out.println(entry.getKey());
            entry.getValue().action();
        }

    }
}
