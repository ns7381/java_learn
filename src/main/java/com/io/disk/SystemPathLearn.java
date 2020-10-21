package com.io.disk;

import java.io.File;

public class SystemPathLearn {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        File directory = new File("./encode.txt");//设定为当前文件夹
        try {
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        } catch (Exception e) {
        }

        String projectDir = SystemPathLearn.class.getResource("/").getPath();
        System.out.println(projectDir);

        /**
         * output:
         * /Users/nathan/project/java/java_learn
         * /Users/nathan/project/java/java_learn/encode.txt
         * /Users/nathan/project/java/java_learn/./encode.txt
         * /Users/nathan/project/java/java_learn/build/classes/java/main/
         */
    }
}
