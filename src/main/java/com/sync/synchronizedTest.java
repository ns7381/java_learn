package com.sync;

/**
 * Created by ning on 2015/10/13.
 */
public class synchronizedTest {
    public  int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final synchronizedTest test = new synchronizedTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();*/
        System.out.println(test.inc);
    }
}
