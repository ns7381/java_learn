package com.nathan.learn.algorithm.search;

/**
 * 线性查找
 * @author nathan
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int index = seqSearch(arr, -11);
        if (index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
