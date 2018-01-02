package com.nathan.test.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by nathan on 16/12/27.
 */
public class DirList {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0) {
            list = file.list();
        } else {
            list = file.list(filter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dir : list) {
            System.out.println(dir);
        }
    }

    static FilenameFilter filter(String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.compile(regex).matcher(name).matches();
            }
        };
    }
//    private static class DirFilter implements FilenameFilter {
//        private Pattern pattern;
//
//        public DirFilter(String regex) {
//            pattern = Pattern.compile(regex);
//        }
//
//        @Override
//        public boolean accept(File dir, String name) {
//            return pattern.matcher(name).matches();
//        }
//    }
}
