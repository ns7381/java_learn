package com.nathan.learn.concurrent.var;

public class InstanceVarTreadSecurity implements Runnable {
    private int instance_i;//实例变量

    @Override
    public void run() {
        instance_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取instance_i 的值:" + instance_i);
        instance_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取instance_i*2的值:" + instance_i * 2);
    }

    public static void main(String[] args) {
        //启动尽量多的线程才能很容易的模拟问题
//        InstanceVarTreadSecurity t = new InstanceVarTreadSecurity();//每个线程访问同一线程对象则会有线程安全问题
        for (int i = 0; i < 3000; i++) {
            InstanceVarTreadSecurity t = new InstanceVarTreadSecurity();
            //每个线程对在对象t中运行，模拟单例情况
            new Thread(t, "线程" + i).start();
        }
    }
}
