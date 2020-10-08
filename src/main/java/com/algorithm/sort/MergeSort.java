package com.algorithm.sort;

import java.time.Instant;
import java.util.Arrays;

/**
 * 归并排序: 将数组分解排序之后合并。
 * @author nathan
 */
public class MergeSort {

    public void sort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        // 分解 -- 将当前区间一分为二，即求分裂点 mid = (low + high)/2;
        int mid = (end + start) / 2;
        // 求解 -- 递归地对两个子区间a[low...mid] 和 a[mid+1...high]进行归并排序。递归的终结条件是子区间长度为1。
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        // 合并 -- 将已排序的两个子区间a[low...mid]和 a[mid+1...high]归并为一个有序的区间a[low...high]。
        mergeSort(arr, start, mid, end);
    }

    private void mergeSort(int[] arr, int start, int mid, int end) {
        // 定义左右 下标, 创建合并后存入的临时数组
        int left = start;
        int right = mid + 1;
        int k = 0;
        int[] tmp = new int[end - start + 1];
        // 合并两个有序数组到临时数组中, 注意: 不适用遍历tmp, right++会造成arr数组下标越界
        /*for (int i = 0; i < tmp.length; i++) {
            if (arr[left] <= arr[right]) {
                tmp[i] = arr[left++];
            } else {
                tmp[i] = arr[right++];
            }
        }*/
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                tmp[k++] = arr[left++];
            } else {
                tmp[k++] = arr[right++];
            }
        }
        // 将剩余左边有序数组放入合并数组
        while (left <= mid) {
            tmp[k++] = arr[left++];
        }
        // 将剩余右边有序数组放入合并数组
        while (right <= end) {
            tmp[k++] = arr[right++];
        }
        // 将排序后的元素，全部都整合到数组a中。
        for (int i = start; i <= end; i++) {
            arr[i] = tmp[i - start];
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {4, 5, 3, 2, 6, 7, 9, 1};
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要25 ms
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Instant.now().toEpochMilli() - start);
//        System.out.println(Arrays.toString(arr));
    }
}
