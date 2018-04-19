package com.effective;

import java.time.Clock;
import java.time.ZoneId;

/**
 * Created by nathan on 17/7/8.
 */
public class NumberLearn {
    public static void main(String[] args) {
        System.out.println(1.03-.42);
        String s1 = "abc";
        String s2 = s1;
        String s3 = new String("abc");
        String s4 = new String("abc");
        String s5 = "abc";

        System.out.println(s1==s5);
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3==s4);
        System.out.println(s1.equals(s4));
        System.out.println(s3.equals(s4));

        System.out.println(Clock.system(ZoneId.of("Asia/Ho_Chi_Minh")).instant());
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(Clock.systemUTC().instant());
    }
}
