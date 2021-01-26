package com.nathan.learn.base.jvm;

/**
 * Created by nathan on 17/12/30.
 */
public class JVMMemOut {
    public void test() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        JVMMemOut jvmMemOut = new JVMMemOut();
        jvmMemOut.test();
    }
}
