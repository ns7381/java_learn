package com.nathan.learn.base.grammar.enumerated;

/**
 * Created by nathan on 16/12/28.
 */
enum Language {
    EN, CN, JA
}

interface ErrorCode {
    String getErrorCode();
    String getErrorMessage();
}

enum LanguageChile implements ErrorCode {
    JAVA_ERROR("1000", "111");

    LanguageChile(String errorCode, String errorMessage) {

    }

    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
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
