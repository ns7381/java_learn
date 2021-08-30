package com.nathan.learn;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {
    private volatile AtomicInteger val = new AtomicInteger(0);
    private static final ThreadLocal<String> ROUTE_KEY = new ThreadLocal<>();
    private static boolean flag;

    public static void main(String[] args) throws InterruptedException {
        Test1 test = new Test1();
        List<Thread> threads = new ArrayList<>();
        System.out.println(" ".indexOf(" "));
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                int j = 0;
                while (j < 1000) {
                    test.val.incrementAndGet();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    j++;
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(test.val.get());


        int val = 10;
        long time = System.currentTimeMillis();
        assert time / 2 + 3 == 10;
        System.out.println(val);


        Test1 test1 = new Test1();

    }

    public void setVal(AtomicInteger val) {
//        this.flag
    }

    @Test
    public void test() {
        int val = 10;
        long time = System.currentTimeMillis();
        assert time / 2 + 3 == 10;
        System.out.println(val);
    }

    @Test
    public void test2() {
        String s = "tesTaBcHfI";
        char[] a = s.toLowerCase().toCharArray();
        Arrays.sort(a);
        System.out.println(Arrays.copyOf(a, 1));
        System.out.println(new String(a));

        char[] chars = s.toCharArray();
        boolean partialOrder;
        char tmp;
        for (int i = 1; i < chars.length; i++) {
            partialOrder = true;
            for (int j = 0; j < chars.length - i; j++) {
                if (i == 1 && j % 2 == 0) {
                    chars[j] = Character.toLowerCase(chars[j]);
                    chars[j + 1] = Character.toLowerCase(chars[j + 1]);
                }
                if (chars[j] > chars[j + 1]) {
                    tmp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = tmp;
                    partialOrder = false;
                }
            }
            if (partialOrder) {
                break;
            }
        }
        System.out.println(new String(chars));
    }

    @Test
    public void testList() {
        List<Integer> ret = new ArrayList<>();
        ret.add(3);
    }

    @Test
    public void testCarry() {
        //二进制
        int i = 0B101;
        System.out.println(i); //5
        //八进制
        i = 0101;
        System.out.println(i); //65
        //十进制
        i = 101;
        System.out.println(i); //101
        //十六进制
        i = 0x101;
        System.out.println(i); //257

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(-11));
        System.out.println(10 >> 1);
        System.out.println(10 << 1);
        System.out.println(10 >>> 1);
        System.out.println("-----------");
        System.out.println(10 & 15);
        System.out.println(10 | 15);
        System.out.println(~10);
        System.out.println(10 ^ 15);
        System.out.println("-----------");
        System.out.println(Integer.toBinaryString(36));
        System.out.println(39 & ~36);
    }

    @Test
    public void testBase64() {
//        String str2 = Base64.("####".getBytes());
//        String str3 = Base64.encodeBase64String("bajie".getBytes());
//        System.out.println(str2);
//        System.out.println(str3);
    }

    @Test
    public void testBase64d() {
//        String str2 = Base64.encodeBase64String("0sbGZyejozOjEsaHR5ZDoyOjAsMTYyMTUwOTg2NDkyMg==".getBytes());
//        String str3 = Base64.encodeBase64String("bajie".getBytes());
//        System.out.println(str2);
//        System.out.println(str3);
    }


    @Test
    public void testRandom() {
        Random random = new Random(9);
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        /**
         * -1157793070
         * 1913984760
         * 1107254586
         * 1773446580
         */
    }

    @Test
    public void testStime() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testString() {
        String test = "abc123";
        char t = '\'';
        System.out.println(test.length());
        System.out.println(test.getBytes().length);
        System.out.println(StringUtils.substringBetween("hive.dynamic.datasource.10k.option.Conn", "hive.dynamic.datasource.", ".option"));
    }

    @Test
    public void testR() {
        String metastoreUrisString[] = new String[]{"abc", "def", "gh", "ijk"};
        Collections.shuffle(Arrays.asList(metastoreUrisString));
        System.out.println(Arrays.toString(metastoreUrisString));
    }

    @Test
    public void testPrintStr() {
        String s = "ABC";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= c.length; i++) {
            permutation(c, 0, i, sb);
        }
    }

    private static void permutation(char[] c, int begin, int len, StringBuffer sb) {
        if (len == 0) {                //当都选择结束时打印sb内容
            System.out.println(sb + " ");
            return;
        }

        if (begin == c.length)
            return;


        sb.append(c[begin]);       //取
        permutation(c, begin + 1, len - 1, sb);    //剩下的里面选len-1个
        sb.deleteCharAt(sb.length() - 1);  //不取
        permutation(c, begin + 1, len, sb);    //剩下的里面选len个

    }

    @Test
    public void testArray() throws UnsupportedEncodingException {
        int[][] test = new int[2][3];
        int[][] test2 = new int[][]{{1, 2, 3}, {1, 2, 3}};
        System.out.println(test.length);
        System.out.println(test2.length);
        System.out.println(test2[0].length);
//        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2[0]));
        System.out.println(Arrays.toString(test2[1]));
        System.out.println(6/3);
        System.out.println(6%3);
        System.out.println(ROUTE_KEY.get());
        System.out.println("sdfsdf'dfsdf\"dsfsdf"
                .replaceAll("'", "")
                .replaceAll("\"", ""));
        System.out.println(new String("立即添加".getBytes(),"iso8859-1"));
    }

}
