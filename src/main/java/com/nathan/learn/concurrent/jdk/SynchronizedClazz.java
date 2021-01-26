package com.nathan.learn.concurrent.jdk;

/**
 * Created by ning on 2015/10/13.
 */
public class SynchronizedClazz {
    /**
     *  0 aload_0
     *  1 dup
     *  2 astore_1
     *  3 monitorenter
     *  4 getstatic #2 <java/lang/System.out>
     *  7 ldc #3 <Method 1 start>
     *  9 invokevirtual #4 <java/io/PrintStream.println>
     * 12 aload_1
     * 13 monitorexit
     * 14 goto 22 (+8)
     * 17 astore_2
     * 18 aload_1
     * 19 monitorexit
     * 20 aload_2
     * 21 athrow
     * 22 return
     */
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }

    /**
     * Name: cp_info #20
     * Descriptor: cp_info #9
     * Access flags: 0x0021[public synchronized]
     */
    public synchronized void method2() {
        System.out.println("Hello World!");
    }
}
