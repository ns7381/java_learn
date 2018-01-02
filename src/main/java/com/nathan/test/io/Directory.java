package com.nathan.test.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Created by nathan on 16/12/28.
 */
public class Directory {
    public static void main(String[] args) {
        System.out.println(walk(".", ".*"));
    }

    File[] local(File dir, String regex) {
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.compile(regex).matcher(name).matches();
            }
        });
    }

    File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }
    static class TreeInfo implements Iterable<File>{
        List<File> files = new ArrayList<File>();
        List<File> dirs = new ArrayList<File>();

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        @Override
        public Iterator<File> iterator() {
            return null;
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "files=" + files +
                    ", dirs=" + dirs +
                    '}';
        }
    }
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }
}
