package com.nathan.learn.base.grammar.enumerated;

import java.util.EnumSet;

/**
 * Created by nathan on 17/1/12.
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<Language> languages = EnumSet.noneOf(Language.class);
        languages.add(Language.CN);
        System.out.println(languages);
        languages.addAll(EnumSet.of(Language.CN, Language.EN, Language.JA));
        System.out.println(languages);
        languages = EnumSet.allOf(Language.class);
        System.out.println(languages);
        System.out.println(languages.contains(Language.CN));
        Language.valueOf("xxx");
    }
}
