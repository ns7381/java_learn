package com.nathan.learn.algorithm.sort.swap;

import java.time.Instant;
import java.util.Arrays;

/**
 * 遍历n次要排序的数列
 * 每次遍历时，它都会从前往后依次的比较相邻两个数的大小；如果前者比后者大，则交换它们的位置。
 * 这样，一次遍历之后，最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止
 * @author nathan
 */
public class BubbleSort {

    private void sort(int[] arr) {
        // 是否局部有序, 没有发生交换则说明有序, 退出循环
        boolean partialOrder;
        // 遍历要排序的数列
        for (int i = 0; i < arr.length -1; i++) {
            partialOrder = true;
            // 从剩余未排序的元素中从前往后依次的比较相邻两个数的大小, 若前一个数字大于后一个数字则交换
            for (int j = 0; j < arr.length -1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    partialOrder = false;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if (partialOrder) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要11s
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        bubbleSort.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
