package com.io;

import java.io.*;

/**
 * Created by nathan on 17/1/9.
 */
public class FileOutput {
    public static void main(String[] args) throws IOException {

        String fileName = "/Users/nathan/project/java/test/src/main/java/com/nathan/test/io/FileOutput.java";
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(fileName)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        String s;
        while ((s = in.readLine()) != null) {
            out.println(s);
        }
        out.close();
    }
}
