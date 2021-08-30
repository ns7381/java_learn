package com.nathan.learn.interview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileInterview {
    /**
     * 代码列出一个目录下所有的文件？ （包含子目录）
     * @param file
     */
    public void listFiles(File file, List<File> ret) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                if (subFiles != null) {
                    for (File subFile : subFiles) {
                        if (subFile.isDirectory()) {
                            listFiles(subFile, ret);
                        } else if (subFile.isFile()) {
                            ret.add(file);
                        }
                    }
                }
            } else if (file.isFile()) {
                ret.add(file);
            }
        }
    }

    public static void main(String[] args) {
        FileInterview interview = new FileInterview();
        List<File> files = new ArrayList<>();
        interview.listFiles(new File("./"), files);
        System.out.println(files);
    }
}
