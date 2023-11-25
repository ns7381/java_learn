package com.nathan.learn;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {
    private volatile AtomicInteger val = new AtomicInteger(0);
    private static final ThreadLocal<String> ROUTE_KEY = new ThreadLocal<>();
    private static boolean flag;

    public void setVal(AtomicInteger val) {
//        this.flag
    }

    @Test
    public void test() {
        int val = 10;
        long time = System.currentTimeMillis();
//        assert time / 2 + 3 == 10;
        System.out.println(val);

        System.out.println(100 ^ 99);
        System.out.println(7 & (~7 +1) );
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
        String str2 = new String(Base64.getDecoder().decode("H6bKs4IPQIdxUSmwyym37yM9oMjmGgBrsX1JbzoMRj/GhmYaRu0ZjLajzgh6SCNG4cCApZkFtu63fKTcfAekwbyT14Mbrors4NJ2chb/s0uGfXJbebo/MuwBBfPUcX8NKneyYcfypbJ4d5j9m/jbwJvTr3isZr3p/Z2dRyFpIjs="));
//        String str3 = Base64.encodeBase64String("bajie".getBytes());
        System.out.println(str2);
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


    @Test
    public void testBasic() {
        String a = "123";
        String b = "303";
        char ca = '0';
        char cb = '2';
        System.out.println(a.charAt(0));
        int x = ca - cb;
        System.out.println(x);
    }

    @Test
    public void testBitCompute() {
        int a = 24;
        System.out.println(24/2);
        System.out.println(24%2);
        System.out.println(24>>1);
        System.out.println(24<<1);
        System.out.println(24&1);
        System.out.println(12&1);
        System.out.println(6&1);
        System.out.println(3&1);
        System.out.println(1&1);
        System.out.println(0>>1);
        System.out.println(0<<1);
        System.out.println(-3>>1);
        System.out.println(-3>>>1);
        System.out.println(3&4);
        System.out.println(1^2);
        System.out.println((1&2)<<1);
    }

    @Test
    public void testNumber() {
        Float f = 2.68F;
        System.out.println(f.doubleValue());
        System.out.println(Double.valueOf(f.toString()));
    }

    @Test
    public void testScala() {
    }

    @Test
    public void testList1() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(123);

        ArrayList<Object> objects2 = new ArrayList<>();
        objects2.add(1);
        objects2.add(123);

        ArrayList<Object> objects3 = new ArrayList<>(objects);
        objects.removeAll(objects2);

        ArrayList<Object> objects4 = objects;

        System.out.println(objects3.size());
        System.out.println(objects4.size());
    }

    @Test
    public void testSort() {
        List<String> list = new ArrayList<String>();
        list.add("sdsd");
        list.add("asdf");
        List<String> sList = new ArrayList<String>();
        sList.add("tab4_bigdecimal_var01");
        sList.add("tab4_boolean_var01");
        sList.add("tab4_date_var01");
        sList.add("tab4_double_var01");
        sList.add("tab4_integer_var01");
        sList.add("tab4_long_var01");
        sList.add("tab4_string_var01");
        sList.sort((f1, f2) -> list.indexOf(f2) - list.indexOf(f1));    //sorts array list
        for(String str: sList)
            System.out.print(" "+str);
    }


    @Test
    public void testCP() throws IOException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        if (cl instanceof URLClassLoader) {
            URL[] urls = ((URLClassLoader) cl).getURLs();
            System.out.println("Classpath: " + Arrays.toString(Arrays.stream(urls).map(URL::getFile).toArray()));
        }


        URL zipUrl = this.getClass().getResource("wjjtest0104_1.0.020230110153820_425547.zip");
        URL entryUrl = new URL("jar:" + zipUrl + "!/test.txt");
        InputStream is = entryUrl.openStream();
    }

    public static void main(String[] args) throws MalformedURLException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        if (cl instanceof URLClassLoader) {
            URL[] urls = ((URLClassLoader) cl).getURLs();
            System.out.println("Classpath: " + Arrays.toString(Arrays.stream(urls).map(URL::getFile).toArray()));
        }


        URL zipUrl = Test1.class.getResource("wjjtest0104_1.0.020230110153820_425547.zip");
        URL entryUrl = new URL("jar:" + zipUrl + "!/test.txt");
    }


    @Test
    public void testnull() {
        System.out.println(null == null);
    }

}
