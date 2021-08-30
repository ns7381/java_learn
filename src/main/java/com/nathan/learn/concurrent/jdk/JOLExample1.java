package com.nathan.learn.concurrent.jdk;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

public class JOLExample1 {
    static A a;
    static A[] b;

    public static void main(String[] args) throws InterruptedException {
        b = new A[10];
        out.println(ClassLayout.parseInstance(b).toPrintable());

    }

    public static void testObjectSize() {
        a = new A();

        //打印JVM的详细信息
        out.println(VM.current().details());
        //打印对应的对象头信息
        out.println(ClassLayout.parseInstance(a).toPrintable());
    }


    public static void testHashCode() {
        a = new A();

        out.println(ClassLayout.parseInstance(a).toPrintable());

        //jvm计算HashCode
        out.println("hashcode: " + Integer.toHexString(a.hashCode()));

        //当计算完HashCode之后，我们可以查看对象头的信息变化
        out.println("after hash");

        out.println(ClassLayout.parseInstance(a).toPrintable());
    }


    public static void testSynchronized() {
        //虚拟机在启动的时候对于偏向锁有延迟，如果没有偏向锁的延迟的话，
        // 虚拟机在启动的时候，可能 JVM 某个线程调用你的线程，这样就有可能变成了轻量锁或者重量锁，所以要做偏向锁的延迟
//        Thread.sleep(5000);

        a = new A();
//        out.println("hashcode: " + Integer.toHexString(a.hashCode()));

        //before lock: 锁的标识是101 mark word指向的线程ID为空
        //为什么在没有加锁之前是偏向锁，准确的说，应该是叫可偏向的状态，因为它后面没有存线程的 ID，当 lock ing 的时候，后面存储的就是线程的 ID
        out.println("before lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        sync();

        //after lock，退出同步后依然保持了偏向信息。
        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    private static void sync() {
        synchronized (a) {
            out.println("lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}
