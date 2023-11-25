package com.nathan.learn.base.grammar.inheritance;

/**
 * Created by nathan on 16/8/2.
 */
public class InitOrder {
    int i=printInit("variable i----");
    static int j = printInit("static variable j---");
    int k;

    InitOrder() {
        System.out.println("InitOrder constuctor----");
        System.out.println("i="+i+"j="+j+"k="+k);
        j = 39;
    }
    private static int printInit(String s) {
        System.out.println(s);
        return 12;
    }

    public void test(Parent parent) {
        System.out.println("parent: ----------");
        System.out.println(parent.getClass());
    }

    public void test(Child child) {
        System.out.println("child: ----------");
        System.out.println(child.getClass());
    }
}
