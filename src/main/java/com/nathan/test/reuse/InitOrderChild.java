package com.nathan.test.reuse;

/**
 * Created by nathan on 16/8/3.
 */
public class InitOrderChild extends InitOrder {
    int i=printInit("child variable i----");
    static int j = printInit("child static variable j---");
    int k;

    InitOrderChild() {
        System.out.println("child InitOrderChild constuctor----");
        System.out.println("child i="+i+"j="+j+"k="+k);
        j = 39;
    }
    private static int printInit(String s) {
        System.out.println(s);
        return 12;
    }

    public static void main(String[] args) {
        System.out.println("child main---");
        new InitOrderChild();
    }
}
