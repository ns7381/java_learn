package com.nathan.learn.base.grammar.enumerated;

/**
 * Created by nathan on 17/1/11.
 */
public enum  OzWitch {
    WEST("w is west"),
    NORTH("n is west"),
    EAST("e is west");

    private String description;
    private OzWitch(String s) {
        this.description = s;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : OzWitch.values()) {
            System.out.println(ozWitch+":"+ozWitch.getDescription());
        }
    }
}
