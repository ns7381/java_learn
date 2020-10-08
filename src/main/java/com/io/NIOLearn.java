package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nathan
 */
public class NIOLearn {

    public static void test() {
        try (FileInputStream inputStream = new FileInputStream("src/main/java/com/io/encode.txt");) {
            FileChannel channel = inputStream.getChannel();
            // 分配一个10byte的ByteBuffer.
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            channel.read(byteBuffer);
            System.out.println(Arrays.toString(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try (
                FileChannel fileChannel = new RandomAccessFile(new File("src/main/java/com/io/encode.txt"), "rw").getChannel();
        ) {
            // 写
            byte[] data = new byte[4096];
            long position = 1024L;
            // 指定 position 写入 4kb 的数据
            fileChannel.write(ByteBuffer.wrap(data), position);
            // 从当前文件指针的位置写入 4kb 的数据
            fileChannel.write(ByteBuffer.wrap(data));

            // 读
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            // 指定 position 读取 4kb 的数据
            fileChannel.read(buffer, position);
            // 从当前文件指针的位置读取 4kb 的数据
            fileChannel.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        // 将 fromFile 文件找那个的数据转移到 toFile 中去
        System.out.println("before transfer: " + readChannel(toChannel));
        fromChannel.transferTo(position, count, toChannel);
        System.out.println("after transfer : " + readChannel(toChannel));

        fromChannel.close();
        fromFile.close();
        toChannel.close();
        toFile.close();
    }

    private static String readChannel(FileChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.clear();

        // 将 channel 读取位置设为 0，也就是文件开始位置
        channel.position(0);
        channel.read(buffer);

        // 再次将文件位置归零
        channel.position(0);

        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        return new String(bytes);
    }

    public static void test4() throws Exception {
        // 从标准输入获取数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String str = sc.nextLine();
        byte[] bytes = str.getBytes();
        RandomAccessFile raf = new RandomAccessFile("map.txt", "rw");
        FileChannel channel = raf.getChannel(); // 获取内存映射缓冲区，并向缓冲区写入数据
        MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
        mappedBuffer.put(bytes);
        raf.close();
        raf.close(); // 再次打开刚刚的文件，读取其中的内容
        raf = new RandomAccessFile("map.txt", "rw");
        channel = raf.getChannel();
        System.out.println("\n文件内容：");
        System.out.println(readChannel(channel));
        raf.close();
        raf.close();
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
