package com.nathan.learn.base.jvm;

/**
 * Created by nathan on 17/12/30.
 */
public class JVMStackOVF {
    private int length = 1;

    public void stackLeak() {
        length ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JVMStackOVF jvmStackOVF = new JVMStackOVF();
        try {
            jvmStackOVF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: "+jvmStackOVF.length);
        }

    }
}
