package com.nathan.java.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2019/3/10
 */
public class ChannelExample {
    public static void main(String[] args) throws IOException {
//        readFile("E:\\github\\java_learn\\netty\\build.gradle");
        transferFile("E:\\github\\java_learn\\netty\\build.gradle", "test.txt");
    }

    private static void readFile(String fileName) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(fileName, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    private static void transferFile(String from, String to) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(from, "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(to, "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);
    }
}
