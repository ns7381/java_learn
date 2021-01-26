package com.nathan.learn.algorithm.search;

/**
 * 适用于有序数组
 *
 * @author nathan
 */
public class InsertValueSearch {
    public int search(int[] arr, int start, int end, int number) {
        if (start >= end) {
            return -1;
        }
        // 确定中间元素
        int mid = start + (end - start) * (number - arr[start]) / (arr[end] - arr[start]);
        // 如果中间数大, 则查找左边; 大于则反
        if (arr[mid] > number) {
            return search(arr, start, mid - 1, number);
        } else if (arr[mid] < number) {
            return search(arr, mid + 1, end, number);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        InsertValueSearch binarySearch = new InsertValueSearch();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 10};
        System.out.println(binarySearch.search(arr, 0, arr.length - 1, 9));

    }
}
