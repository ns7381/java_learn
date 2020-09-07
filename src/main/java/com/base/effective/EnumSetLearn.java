package com.base.effective;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by nathan on 17/6/17.
 */
public class EnumSetLearn {
    public enum Style {BOLD, ITALIC, UNDERLINE,}
    public void applyText(Set<Style> styles) {

    }

    public static void main(String[] args) {
        EnumSetLearn enumSetLearn = new EnumSetLearn();
        enumSetLearn.applyText(EnumSet.of(Style.BOLD, Style.ITALIC));
        System.out.println(EnumSet.noneOf(Style.class));
//        Style.values().
    }
}

class Test {

}

