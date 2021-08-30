package com.nathan.learn.base.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FunctionDemo {
    @FunctionalInterface
    public interface HelloService {

        void sayHello(String username);
    }
    private String name;

    /**
     * 定义构造函数
     */
    public FunctionDemo(String username) {
        this.name = username;
        System.out.println(username + ":");
    }
    /**
     * 定义函数接口的使用方法
     */
    void say(HelloService hs) {
        hs.sayHello(this.name);
    }

    /**
     * 静态函数
     */
    static void print(String username) {
        System.out.println("Hello, " + username + "!");
    }

    void println(String username) {
        //  这句话也会执行
        this.name = "yiifee";
        System.out.println("Hello, " + username + "!");
    }

    static void writeToFile(Integer integer) throws IOException {
        // logic to write to file which throws IOException
    }
    public static void main(String[] args) {
        FunctionDemo functionDemo = new FunctionDemo("test");
        functionDemo.say(username -> System.out.println(username));

        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(i -> {
            try {
                writeToFile(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
