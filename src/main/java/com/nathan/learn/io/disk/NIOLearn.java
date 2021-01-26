package com.nathan.learn.io.disk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.channels.FileChannel.MapMode.READ_ONLY;
import static java.nio.channels.FileChannel.MapMode.READ_WRITE;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;
import static org.junit.Assert.assertEquals;

/**
 * @author nathan
 */
public class NIOLearn {

    private final static String CONTENT = "Zero copy implemented by MappedByteBuffer";
    private final static String FILE_NAME = "mmap.txt";
    private final static String CHARSET = "UTF-8";


    public static void main(String[] args) throws Exception {

    }

    public void readFile(String file) {
        try (
                // 第一步 获取通道
                FileInputStream fis = new FileInputStream(file);
                FileChannel channel = fis.getChannel();
        ) {
            // 文件内容的大小
            int size = (int) channel.size();

            // 第二步 指定缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 第三步 将通道中的数据读取到缓冲区中
            channel.read(buffer);

            Buffer bf = buffer.flip();
            System.out.println("limt:" + bf.limit());

            byte[] bt = buffer.array();
            System.out.println(new String(bt, 0, size));

            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile2() {
        Path path = Paths.get(getClass().getResource(FILE_NAME).getPath());
        int length = CONTENT.getBytes(Charset.forName(CHARSET)).length;
        try (
                FileChannel fileChannel = FileChannel.open(path, READ)
        ) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(READ_ONLY, 0, length);
            if (mappedByteBuffer != null) {
                byte[] bytes = new byte[length];
                mappedByteBuffer.get(bytes);
                String content = new String(bytes, StandardCharsets.UTF_8);
                assertEquals(content, "Zero copy implemented by MappedByteBuffer");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String file) {
        try (
                // 第一步 获取一个通道
                FileOutputStream fos = new FileOutputStream(file);
                FileChannel fc = fos.getChannel();
        ) {
            // 第二步 定义缓冲区
            ByteBuffer buffer = ByteBuffer.wrap("Hello World 2".getBytes());
            // 将内容写到缓冲区
            fos.flush();
            fc.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile2() {
        Path path = Paths.get(getClass().getResource(FILE_NAME).getPath());
        byte[] bytes = CONTENT.getBytes(Charset.forName(CHARSET));
        try (
                FileChannel fileChannel = FileChannel.open(path, READ, WRITE, TRUNCATE_EXISTING)
        ) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(READ_WRITE, 0, bytes.length);
            if (mappedByteBuffer != null) {
                mappedByteBuffer.put(bytes);
                mappedByteBuffer.force();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        // 读文件通道
        FileChannel readChannel = fis.getChannel();
        // 写文件通道
        FileChannel writeChannel = fos.getChannel();
        // 读入数据缓存
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 文件内容的大小
        int size = (int) readChannel.size();
        while (true) {
            buffer.clear();
            // 读入数据
            int len = readChannel.read(buffer);
            if (len == -1) {
                // 读取完毕
                break;
            }
            System.out.println(new String(buffer.array(), 0, size));
            // 重置position
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, size));
            // 写入文件
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    private static void copyFile2(String srcPath, String targetPath) throws IOException {
        File file = new File(targetPath);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        RandomAccessFile inRandomAccessFile = new RandomAccessFile(srcPath, "r");
        FileChannel inFileChannel = inRandomAccessFile.getChannel();
        MappedByteBuffer inMappedByteBuffer = inFileChannel.map(READ_ONLY, 0, inFileChannel.size());
        inRandomAccessFile.close();
        inFileChannel.close();

        RandomAccessFile outRandomAccessFile = new RandomAccessFile(targetPath, "rw");
        FileChannel outFileChannel = outRandomAccessFile.getChannel();
        MappedByteBuffer outMappedByteBuffer = outFileChannel.map(READ_WRITE, 0, inMappedByteBuffer.capacity());
        outMappedByteBuffer.put(inMappedByteBuffer);
        outMappedByteBuffer.force();
        outRandomAccessFile.close();
        outFileChannel.close();
        outMappedByteBuffer.flip();
    }

    public void zeroCopy(String srcPath, String targetPath) throws Exception {
        try (
                FileChannel fromChannel = new RandomAccessFile(srcPath, "rw").getChannel();
                FileChannel toChannel = new RandomAccessFile(targetPath, "rw").getChannel()
        ) {
            long position = 0L;
            long offset = fromChannel.size();
            fromChannel.transferTo(position, offset, toChannel);
        }
    }


    private static MappedByteBuffer appendFile(String path, String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        byte[] bytes = str.getBytes();
        long size = fileChannel.size() + bytes.length;
        MappedByteBuffer mappedByteBuffer = fileChannel.map(READ_WRITE, 0, size);
        fileChannel.close();
        randomAccessFile.close();

        int position = mappedByteBuffer.limit() - bytes.length;
        mappedByteBuffer.position(position);
        mappedByteBuffer.put(bytes);
        mappedByteBuffer.force();
        mappedByteBuffer.flip();
        return mappedByteBuffer;
    }
}
