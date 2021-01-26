package com.nathan.learn.algorithm.search;

import java.util.Arrays;

/**
 * 原理fabonacci[i]/fabonacci[i+1]=黄金分割比
 * @author nathan
 */
public class FibonacciSearch {
    public int search(int[] arr, int number) {
        // 找到fibonacci下标
        int[] fibonacci = getFibonacci();
        int index = 0;
        while (arr.length > fibonacci[index]) {
            index++;
        }

        // 填充fibonacci数组
        int[] tmp = Arrays.copyOf(arr, fibonacci[index]);
        for (int i = arr.length; i < fibonacci[index] - 1; i++) {
            tmp[i] = arr[arr.length - 1];
        }

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + fibonacci[index-1] - 1;
            if (number < tmp[mid]) {
                end = mid - 1;
                index --;
            } else if (number > tmp[mid]) {
                start = mid + 1;
                index = index - 2;
            } else {
                return Math.min(mid, end);
            }
        }
        return -1;
    }

    private int[] getFibonacci() {
        int[] fibonacci = new int[20];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < 20; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }


    public static void main(String[] args) {
        FibonacciSearch binarySearch = new FibonacciSearch();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 10};
        System.out.println(binarySearch.search(arr, 9));

    }
}
