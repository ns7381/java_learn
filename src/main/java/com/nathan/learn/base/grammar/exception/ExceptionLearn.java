package com.nathan.learn.base.grammar.exception;

/**
 * Created by nathan on 17/6/28.
 */
public class ExceptionLearn {
    public static void main(String[] args) {
        int i = exceptionFunc();
        System.out.println("main---"+ i);;
    }

    private static int exceptionFunc() {
        int a = 0;

        try {
            String s = "t"; //------------------------（1）
            a = Integer.parseInt(s);//-----------（2）
            System.out.println("return -----"+a);
//            return a;
        } catch (NumberFormatException e) {
            a = 1;//-----------------------------------（3）
            System.out.println("catch -----"+a);
//            return a;//-------------------------------（4）
        } finally {
            a = 2;//-----------------------------------（5）
            System.out.println("finally -----"+a);
            return a;
        }
    }
}
