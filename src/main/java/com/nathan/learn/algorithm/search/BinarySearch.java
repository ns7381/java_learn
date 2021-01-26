package com.nathan.learn.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 适用于有序数组
 * @author nathan
 */
public class BinarySearch {
    public int search(int[] arr, int start, int end, int number) {
        if (start >= end) {
            return -1;
        }
        // 确定中间元素
        int mid = (start + end) / 2;
        // 如果中间数大, 则查找左边; 大于则反
        if (arr[mid] > number) {
            return search(arr, start, mid - 1, number);
        } else if (arr[mid] < number) {
            return search(arr, mid + 1, end, number);
        } else {
            return mid;
        }
    }

    public List<Integer> searchMany(int[] arr, int start, int end, int number) {
        if (start >= end) {
            return new ArrayList<>();
        }
        // 确定中间元素
        int mid = (start + end) / 2;
        // 如果小于中间数, 则查找左边; 大于则反
        if (arr[mid] > number) {
            return searchMany(arr, start, mid - 1, number);
        } else if (arr[mid] < number) {
            return searchMany(arr, mid + 1, end, number);
        } else {
            // 继续查找左右相邻元素,不等于查找值则结束
            List<Integer> results = new ArrayList<>();
            results.add(mid);
            int index = mid + 1;
            while (index < arr.length && arr[index] == number) {
                results.add(index);
                index++;
            }
            index = mid - 1;
            while (index >= 0 && arr[index] == number) {
                results.add(index);
                index--;
            }
            return results;
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 9, 9, 10};
        System.out.println(binarySearch.search(arr, 0, arr.length - 1, 9));

        System.out.println(binarySearch.searchMany(arr, 0, arr.length - 1, 9));
    }

}
