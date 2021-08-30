package com.nathan.learn.base.grammar.enumerated;

/**
 * Created by nathan on 16/12/28.
 */
enum Language {
    EN, CN, JA
}
public class EnumClass {
    public static void main(String[] args) {
        for (Language language : Language.values()) {
            System.out.println(language.ordinal());
            System.out.println(language.name());
            System.out.println(language.equals(Language.CN));
        }
        System.out.println(Enum.valueOf(Language.class, "EN"));
    }
}
