package com.nathan.learn.algorithm.sort.selection;

import java.time.Instant;
import java.util.Arrays;

/**
 * 首先在未排序的数列中找到最小元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @author nathan
 */
public class SelectionSort {

    public void sort(int[] arr) {
        // 记录选择排序中选择出来的最小值
        int minIndex;
        // 遍历要排序的数列
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            // 从剩余未排序的元素中继续寻找最小元素，然后放到已排序序列的末尾
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex > i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 4};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要3.8s
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        selectionSort.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
