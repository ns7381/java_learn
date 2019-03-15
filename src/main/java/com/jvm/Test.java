package com.jvm;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List x = mapper.readValue("[a,b,c]", List.class);
        System.out.println(x);;
        int a = 0;
        add(a);
        String b = "123";
        change(b);
        System.out.println(a);
        System.out.println(b);
    }

    private static void change(String b) {
        b.replace("1", "2");
        b = "345";
    }

    private static void add(int a) {
        a += 1;
    }
}
