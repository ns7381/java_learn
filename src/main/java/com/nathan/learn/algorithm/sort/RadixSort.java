package com.nathan.learn.algorithm.sort;

import java.time.Instant;
import java.util.Arrays;

/**
 * 适用于已知[0, Max)的数组
 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 * @author nathan
 */
public class RadixSort {
    public void sort(int[] arr) {
        // 取得最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 遍历最大数位数
        for (int digit = 1; digit < max; digit = digit * 10) {
            // 对数组按位数上的值进行桶排序
            int[] buckets = new int[10];
            int[] output = new int[arr.length];
            // 桶计数记录个数
            for (int i = 0; i < arr.length; i++) {
                buckets[arr[i] / digit % 10]++;
            }
            // 桶计数累加变为累计个数
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }
            // 排序后数组放入output
            for (int i = arr.length - 1; i >= 0; i--) {
                output[--buckets[arr[i] / digit % 10]] = arr[i];
            }
            // 将排序好的数据赋值给arr
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
        }
    }
    public static void main(String[] args) {
        RadixSort sort = new RadixSort();
        int[] arr = {4, 5, 3, 2, 6, 7, 9, 1};
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要40 ms
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        sort.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
