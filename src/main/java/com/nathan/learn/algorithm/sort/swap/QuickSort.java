package com.nathan.learn.algorithm.sort.swap;

import java.time.Instant;
import java.util.Arrays;

/**
 * 选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
 * 其中一部分的所有数据都比另外一部分的所有数据都要小。
 * 然后，再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * @author nathan
 */
public class QuickSort {
    public void sort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        // 定义左右下标和基准值
        int mark = arr[start];
        int left = start;
        int right = end;
        // 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面
        // 方向变更是为了保留一个临时位置,可以存放找到的数据
        boolean right2left = true;
        while (right > left) {
            if (right2left) {
                // 从右向左遍历,找到小的数则放入左下标位置,然后换方向遍历
                if (arr[right] < mark) {
                    arr[left] = arr[right];
                    right2left = false;
                    left++;
                } else {
                    right --;
                }
            } else {
                // 从左向右遍历,找到大的数则放入右下标位置,然后换方向遍历
                if (arr[left] > mark) {
                    arr[right] = arr[left];
                    right2left = true;
                    right--;
                } else {
                    left ++;
                }
            }
        }
        // 在这个分区退出之后，该基准就处于数列的中间位置。
        arr[left] = mark;
        // 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序
        sort(arr, start, left);
        sort(arr, left + 1, end);

    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 14, 81, 0, -9};
        QuickSort sort = new QuickSort();
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要30 ms
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
//        sort.sort(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
        System.out.println(Arrays.toString(arr));
    }
}
