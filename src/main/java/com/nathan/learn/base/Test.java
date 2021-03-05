package com.nathan.learn.base;

public class Test {
    public static void main(String[] args) {
        String test = "test";
        switch (test) {
            case "test":
                System.out.println("test");
            case "other":
                System.out.println("other");
                return;
        }


        System.out.println("".split(","));
    }
}
