package com.jvm;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * Created by ning on 2015/10/13.
 */
public class AutoClassLoader extends ClassLoader{

    private static String FILEPATH = "";
    private static final String DEAFAULTDIR = "E:\\project\\test\\out\\production\\test\\";

    /*
        * 重写ClassLoader类的findClass方法，将一个字节数组转换为 Class 类的实例
        */
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = null;
        try {
            b = loadClassData(AutoClassLoader.FormatClassName(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);

    }
    /*
    * 将指定路径的.class文件转换成字节数组
    */
    private byte[] loadClassData(String filepath) throws Exception {
        int n =0;
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File(filepath)));
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        while((n=br.read())!=-1){
            bos.write(n);
        }
        br.close();
        return bos.toByteArray();
    }
    /*
        * 格式化文件所对应的路径
        */
    public static String FormatClassName(String name){

        FILEPATH= DEAFAULTDIR + name+".class";
        return FILEPATH;
    }

    /*
    * main方法测试
    */
    public static void main(String[] args) throws Exception {

        AutoClassLoader acl = new AutoClassLoader();
        Class c = acl.findClass("testClass");
        Object obj = c.newInstance();
        Method m = c.getMethod("getName",new Class[]{String.class ,int.class});
        m.invoke(obj,"你好",123);
        System.out.println(c.getName());
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
    }

}
