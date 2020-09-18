package com.base.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws MyException {
        readFile("xxxx");
    }

    private static void readFile(String filePath) throws MyException {

        BufferedReader reader = null;
        try {
            File file = new File(filePath);
            String result;
            reader = new BufferedReader(new FileReader(file));
            while ((result = reader.readLine()) != null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("readFile method catch block.");
            MyException ex = new MyException("read file failed.");
            ex.initCause(e);
            throw ex;
        } finally {
            System.out.println("readFile method finally block.");
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
