package com.nathan.learn.algorithm.sort.insertion;

import java.time.Instant;
import java.util.Arrays;

/**
 * 对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列，所有距离为gap的倍数的记录放在同一个组中；
 * 然后，对各组内的元素进行直接插入排序。 这一趟排序完成之后，每一个组的元素都是有序的。
 * 然后减小gap的值，并重复执行上述的分组和排序。重复这样的操作，当gap=1时，整个数列就是有序的。
 */
public class ShellSort {
    public void sort(int[] arr) {
        // 遍历gap取值
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            // 遍历分组, 对每一个分组进行插入排序
            for (int group = 0; group < gap; group++) {
                // 遍历分组下待排序数组
                for (int i = group + gap; i < arr.length; i = i + gap) {
                    // 将数字插入已排序的数组中
                    for (int j = group; j < i; j = j + gap) {
                        if (arr[i] < arr[j]) {
                            int tmp = arr[i];
                            // 后移插入位置后的数组
                            for (int m = i; m > j; m = m - gap) {
                                arr[m] = arr[m - gap];
                            }
                            arr[j] = tmp;
                        }
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 14, 81, 0, -9};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要5s
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        shellSort.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
