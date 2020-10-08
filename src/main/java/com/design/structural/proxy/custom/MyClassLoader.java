package com.design.structural.proxy.custom;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private File classPathFile;

    public MyClassLoader() {
        classPathFile = new File(MyClassLoader.class.getResource("").getPath());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(classPathFile, name + ".class"));
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            return defineClass(MyClassLoader.class.getPackage().getName() + "." + name, outputStream.toByteArray(), 0, outputStream.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
