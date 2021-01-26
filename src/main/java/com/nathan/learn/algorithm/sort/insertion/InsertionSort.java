package com.nathan.learn.algorithm.sort.insertion;

import java.time.Instant;
import java.util.Arrays;

/**
 * 把n个待排序的元素看成为一个有序表和一个无序表。
 * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素
 * 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
 * @author nathan
 */
public class InsertionSort {
    public void sort(int[] arr) {
        // 遍历要排序的数列
        for (int i = 1; i < arr.length; i++) {
            // 从已排序的数组中插入待排序的数字
            for (int j = 0; j < i; j++) {
                // 因为[0,i)是有序数组,所以小于的话就是插入数据位置
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    // 将[j,i-1]后移到[j+1, i], 注意后移时需要从末尾向前后移, 因为arr[m]=arr[m-1]语句前一次执行后,下一次执行arr[m-1]发生了变化
                    // 可用JNI接口System.arraycopy(arr, j, arr, j + 1, i - j)处理
                    for (int m = i; m > j; m--) {
                        arr[m] = arr[m-1];
                    }
                    arr[j] = tmp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 4, 2, 3, 1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要1s, 改成system.arraycopy需要0.7s
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        insertionSort.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
