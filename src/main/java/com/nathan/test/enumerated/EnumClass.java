package com.nathan.test.enumerated;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

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
