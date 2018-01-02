package jvm;

/**
 * Created by nathan on 17/6/24.
 */
public class Fibonacci {
    public static void main(String[] args) {
        byte a = 3;
        byte b = 1;
        byte c = (byte) (a + b);
    }
    static void calcSequence() {
        long fiboNum = 1;
        long a = 1;
        long b = 1;
        for (;;) {
            fiboNum = a + b;
            a = b;
            b = fiboNum;
        }
    }
}
