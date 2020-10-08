package com.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author nathan
 */
public class EncodeLearn {
    public static void test() throws Exception{
        /**
         * 1. char 和 String 在内存中保存都使用Java内码，也即UTF-16
         * 2. char 在class文件中使用UTF-16表示
         * 3. String在class文件中使用UTF-8表示
         * 4. 序列化和Class文件中用"modified UTF-8"，不是UTF-8。参考https://docs.oracle.com/javase/7/docs/api/java/io/DataInput.html#modified-utf-8
         *
         * 5. 问题：内存存储的是UTF-16编码的字节，那么String.getBytes("UTF-8")应该是从UTF-16到UTF-8的转换过程
         *    解答：String.getBytes()是一个用于将String的内码转换为指定的外码的方法（问题中UTF-8就是指定的外码）。
         *          无参数版使用平台的默认编码作为外码，有参数版使用参数指定的编码作为外码。
         *          将String的内容用外码编码好，结果放在一个新byte[]返回。
         *
         *
         * @date 2020/1/17
         * @return
         */
        char aaa = '中'; // class 文件中是(UTF-16) 4E 2D
        String bbb = "a中"; // class 文件中是(UTF-8) 61 E4 B8 AD

        System.out.println(Integer.toHexString(aaa));//4E2D

        System.out.println(Arrays.toString(bbb.getBytes("UTF-8")));//61,E4,B8,AD
        System.out.println(Arrays.toString(bbb.getBytes("UTF-16"))); //带BOM的字节数组：EF,FF,00,61,4E,2D
        System.out.println(Arrays.toString(bbb.getBytes("UTF-16be"))); //无BOM的字节数组：00,61,4E,2D

    }

    public static void main(String[] args) throws Exception {
        test();
        String str = "中文";
        // 获取JVM默认字符集
        System.out.println("defaultCharset:" + Charset.defaultCharset());
        System.out.println("file.encoding:" + System.getProperty("file.encoding"));
        System.out.println("##字符串转换成byte数组");
        byte[] defaultByteArray = str.getBytes();
        byte[] gbkByteArray = str.getBytes("GBK");
        byte[] utfByteArray = str.getBytes("UTF-8");
        System.out.println("defaultByteArray:"
                + Arrays.toString(defaultByteArray));
        System.out.println("gbkByteArray:" + Arrays.toString(gbkByteArray));
        System.out.println("utfByteArray:" + Arrays.toString(utfByteArray));

        System.out.println("##byte数组转换成字符串");
        String defaultStr = new String(defaultByteArray);
        String gbkStr = new String(defaultByteArray, "GBK");
        String utfStr = new String(defaultByteArray, "UTF-8");
        System.out.println("defaultStr:" + defaultStr);
        System.out.println("gbkStr:" + gbkStr);
        // 因为utf-8是变长编码，没有跟[-42, -48, -50, -60]对应的用utf-8字符集的字符串，所以会乱码
        System.out.println("utfStr:" + utfStr);

        System.out.println("##字节流转化成字符流");
        // 文件中只有“中文”2个字,文件采用“GBK”编码，共4个byte
        BufferedReader defaultReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("src/main/java/com/io/encode.txt")));
        BufferedReader gbkReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/main/java/com/io/encode.txt"), "GBK"));
        BufferedReader utfReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/main/java/com/io/encode.txt"), StandardCharsets.UTF_8));
        System.out.println("defaultReader:" + defaultReader.readLine());
        System.out.println("gbkReader:" + gbkReader.readLine());
        System.out.println("utfReader:" + utfReader.readLine());

        System.out.println("##字符流转化成字节流");
        BufferedWriter defaultWriter = new BufferedWriter(
                new OutputStreamWriter(System.out));
        BufferedWriter gbkWriter = new BufferedWriter(new OutputStreamWriter(
                System.out, "GBK"));
        BufferedWriter utfWriter = new BufferedWriter(new OutputStreamWriter(
                System.out, "UTF-8"));
        System.out.print("defaultWriter:");
        defaultWriter.write(str);
        // 这里不能用close()方法，否则System.out也被关闭，后续无输出
        defaultWriter.flush();
        System.out.print("\r\ngbkReader:");
        gbkWriter.write(str);
        gbkWriter.flush();
        System.out.print("\r\nutfReader:");
        utfWriter.write(str);
        utfWriter.flush();
    }
}
