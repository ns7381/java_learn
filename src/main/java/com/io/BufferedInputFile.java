package com.io;

import java.io.*;

/**
 * Created by nathan on 17/1/9.
 */
public class BufferedInputFile {
    public static void main(String[] args) throws IOException {
        System.out.println(read("/Users/nathan/project/java/test/src/main/java/com/nathan/test/io/BufferedInputFile.java"));

//        StringReader in = new StringReader(BufferedInputFile.read("/Users/nathan/project/java/test/src/main/java/com/nathan/test/io/BufferedInputFile.java"));
//        int c;
//        while ((c = in.read()) != -1) {
//            System.out.print((char) c);
//        }

        /*DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/nathan/project/java/test/src/main/java/com/nathan/test/io/BufferedInputFile.java")));
        while (in.available() != 0) {
            System.out.print((char)in.readByte());
        }*/
    }

    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }
}
