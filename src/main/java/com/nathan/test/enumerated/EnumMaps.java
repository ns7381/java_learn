package com.nathan.test.enumerated;

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
        map.put(Language.CN, new Commnad() {
            @Override
            public void action() {
                System.out.println("cncncn");
            }
        });
        for (Map.Entry<Language, Commnad> entry : map.entrySet()) {

            System.out.println(entry.getKey());
            entry.getValue().action();
        }

    }
}
