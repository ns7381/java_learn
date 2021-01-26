package com.nathan.learn.base.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final Pattern PATTERN = Pattern.compile("^(hdfs://)(ns\\d+)(.*)$");

    public static void main(String[] args) {
        System.out.println("hdfs://ns17/test/sdf".replaceFirst("(hdfs://ns\\d+)", "hdfs://10.11.11.2:8020"));
        Matcher matcher = PATTERN.matcher("hdfs://ns17/test/sdf");
        if (matcher.find()) {
            System.out.println("group 2: " + matcher.group(2));
        }
    }
}
