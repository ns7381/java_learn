package com.nathan.learn.io.disk;

import org.junit.Test;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;


public class StandardIOLearn {
    public static void main(String[] args) throws IOException {
        // 1. 读取控制台中的输入
//        test01();
//        test02();
//        test03();

        // 2. 二进制文件的写入和读取
//        test04();
        test05();

        //3. 文本文件的写入和读取
//        test06();
//        test07();
//        test08();
//        test09();

        //4. 复制文件
    }

    public static void test01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("你输入的字符为" + c);
    }

    public static void test02() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符，按 q 键结束");
        char c;
        do {
            c = (char) bufferedReader.read();
            System.out.println("你输入的字符为" + c);
        } while (c != 'q');
    }

    public static void test03() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行字符");
        String str = bufferedReader.readLine();
        System.out.println("你输入的字符为" + str);
    }

    public static void test04() throws IOException {
        byte[] bytes = {12,21,34,11,21};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/test.txt");
        // 写入二进制文件，直接打开会出现乱码
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    public static void test05() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/test.txt");
        int c;
        // 读取写入的二进制文件，输出字节数组
        while ((c = fileInputStream.read()) != -1) {
            System.out.print(c);
        }
    }

    @Test
    public void test06() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/test.txt");
        fileWriter.write("Hello，world！\n欢迎来到 java 世界\n");
        fileWriter.write("不会覆盖文件原本的内容\n");
//        fileWriter.write(null); 不能直接写入 null
        fileWriter.append("并不是追加一行内容，不要被方法名迷惑\n");
        fileWriter.append(null);
        fileWriter.flush();
        System.out.println("文件的默认编码为" + fileWriter.getEncoding());
        fileWriter.close();
    }

    @Test
    public void test07() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/test.txt", false); // 关闭追加模式，变为覆盖模式
        fileWriter.write("Hello，world！欢迎来到 java 世界\n");
        fileWriter.write("我来覆盖文件原本的内容");
        fileWriter.append("我是下一行");
        fileWriter.flush();
        System.out.println("文件的默认编码为" + fileWriter.getEncoding());
        fileWriter.close();
    }

    @Test
    public void test08() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath()+"/io/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }

    @Test
    public void test09() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath()+"/test.txt");
        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    //使用字节流和字符流的转换类 InputStreamReader 和 OutputStreamWriter 可以指定文件的编码，使用 Buffer 相关的类来读取文件的每一行。
    @Test
    public void test10() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/test2.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK"); // 使用 GBK 编码文件
        outputStreamWriter.write("Hello，world！\n欢迎来到 java 世界\n");
        outputStreamWriter.append("另外一行内容");
        outputStreamWriter.flush();
        System.out.println("文件的编码为" + outputStreamWriter.getEncoding());
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    @Test
    public void test11() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/io/test2.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK"); // 使用 GBK 解码文件
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
    }




    //复制文件
    @Test
    public void  test12() throws IOException {
        // 输入和输出都使用缓冲流
        FileInputStream in = new FileInputStream("D:\\BDP\\install\\docker-18.09.6.tgz");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("D:\\BDP\\test1.tgz");
        BufferedOutputStream outBuffer = new BufferedOutputStream(out);
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            outBuffer.write(bs, 0, len);
        }
        System.out.println("复制文件所需的时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 129 多毫秒
        inBuffer.close();
        in.close();
        outBuffer.close();
        out.close();
    }


    @Test
    public void  test13() throws IOException {
        // 只有输入使用缓冲流
        FileInputStream in = new FileInputStream("D:\\BDP\\install\\docker-18.09.6.tgz");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("D:\\BDP\\test2.tgz");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 187 多毫秒
        inBuffer.close();
        in.close();
        out.close();
    }

    @Test
    public void test14() throws IOException {
        // 输入和输出都不使用缓冲流
        FileInputStream in = new FileInputStream("D:\\BDP\\install\\docker-18.09.6.tgz");
        FileOutputStream out = new FileOutputStream("D:\\BDP\\test3.tgz");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间 245 多毫秒
        in.close();
        out.close();
    }

    @Test
    public void test15() throws IOException {
        // 不使用缓冲
        FileInputStream in = new FileInputStream("D:\\BDP\\install\\docker-18.09.6.tgz");
        FileOutputStream out = new FileOutputStream("D:\\BDP\\test4.tgz");
        int len = 0;
        long begin = System.currentTimeMillis();
        while ((len = in.read()) != -1) {
            out.write(len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 200557 毫秒，约 3 分多钟
        in.close();
        out.close();
    }
}
