package jvm;

/**
 * Created by nathan on 17/12/28.
 */
public class GC {
    /**
     * 2  -Xms60m
     * 3  -Xmx60m
     * 4  -Xmn20m
     * 5  -XX:NewRatio=2 ( 若 Xms = Xmx, 并且设定了 Xmn, 那么该项配置就不需要配置了 )
     * 6  -XX:SurvivorRatio=8
     * 7  -XX:PermSize=30m
     * 8  -XX:MaxPermSize=30m
     * 9  -XX:+PrintGCDetails
     * 10
     */
    public static void main(String[] args) {
        new GC().doTest();
    }

    public void doTest() {
        Integer M = new Integer(1024 * 1024 * 1);  //单位, 兆(M)
        byte[] bytes = new byte[1 * M]; //申请 1M 大小的内存空间
        bytes = null;  //断开引用链
        System.gc();   //通知 GC 收集垃圾
        System.out.println();
        bytes = new byte[1 * M];  //重新申请 1M 大小的内存空间
        bytes = new byte[1 * M];  //再次申请 1M 大小的内存空间
        System.gc();
        System.out.println();
    }
}
