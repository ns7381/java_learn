package com.base.enumerated;

import java.util.EnumSet;

import static com.base.enumerated.Language.*;

/**
 * Created by nathan on 17/1/12.
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<Language> languages = EnumSet.noneOf(Language.class);
        languages.add(CN);
        System.out.println(languages);
        languages.addAll(EnumSet.of(CN, EN, JA));
        System.out.println(languages);
        languages = EnumSet.allOf(Language.class);
        System.out.println(languages);
    }
}
