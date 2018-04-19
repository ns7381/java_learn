package com.sync;

/**
 * Created by ning on 2015/10/13.
 */
public class volitaleTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final volitaleTest test = new volitaleTest();
        for (int i = 0; i < 10; i++) {
            new Thread(i + "") {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }
            }.start();
        }

        Thread.sleep(1000);
            System.out.println(test.inc);
    }
}


/**
 假如某个时刻变量inc的值为10，

 　　线程1对变量进行自增操作，线程1先读取了变量inc的原始值，然后线程1被阻塞了；

 　　然后线程2对变量进行自增操作，线程2也去读取变量inc的原始值，由于线程1只是对变量inc进行读取操作，而没有对变量进行修改操作，所以不会导致线程2的工作内存中缓存变量inc的缓存行无效，所以线程2会直接去主存读取inc的值，发现inc的值时10，然后进行加1操作，并把11写入工作内存，最后写入主存。

 　　然后线程1接着进行加1操作，由于已经读取了inc的值，注意此时在线程1的工作内存中inc的值仍然为10，所以线程1对inc进行加1操作后inc的值为11，然后将11写入工作内存，最后写入主存。

 　　那么两个线程分别进行了一次自增操作后，inc只增加了1。
 **/
