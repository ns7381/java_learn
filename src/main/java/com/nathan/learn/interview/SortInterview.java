package com.nathan.learn.interview;

import java.util.Arrays;

public class SortInterview {
    /**
     * 排序颜色集合, 按照0-红色, 1 白色, 2 蓝色的顺序
     *
     * @param colors 颜色数组
     */
    public void colorSort(int[] colors) {
        int redIndex = 0;
        int whiteIndex = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                if (i > redIndex) {
                    int tmp = colors[redIndex];
                    colors[redIndex] = 0;
                    colors[i] = tmp;
                    redIndex++;
                    whiteIndex++;

                }
            } else if (colors[i] == 1) {
                if (i > whiteIndex) {

                    int tmp = colors[whiteIndex];
                    colors[whiteIndex] = 1;
                    colors[i] = tmp;
                    whiteIndex++;
                }
            }
        }
        System.out.println(Arrays.toString(colors));
    }

    public static void main(String[] args) {
        SortInterview interview = new SortInterview();
        interview.colorSort(new int[]{2, 0, 1, 0, 2, 0, 1});
    }
}
