package com.nathan.learn.algorithm.sort;

import java.time.Instant;
import java.util.Arrays;

/**
 * 适用于已知[0, Max)的数组
 * 假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。
 * 在桶排序时，创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
 * @author nathan
 */
public class BucketSort {
    public void sort(int[] arr, int max) {
        int[] buckets;
        if (arr==null || max<1) {
            return ;
        }
        // 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
        buckets = new int[max];
        // 1. 计数
        for(int i = 0; i < arr.length; i++) {
            buckets[arr[i]]++;
        }
        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {
            while( (buckets[i]--) >0 ) {
                arr[j++] = i;
            }
        }
    }
    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        int[] arr = {4, 5, 3, 2, 6, 7, 9, 1};
        sort.sort(arr, 10);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要40 ms
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        sort.sort(arr, 8000001);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
