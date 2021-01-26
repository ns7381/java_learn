package com.nathan.learn.algorithm.sort.selection;

import java.time.Instant;
import java.util.Arrays;

/**
 * 堆排序
 *
 * @author nathan
 */
public class HeapSort {
    public void sort(int[] arr) {
        // 调整为最大堆, arr.length/2-1为最后一个非叶子节点位置
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapDown(arr, i, arr.length - 1);
        }
        // 交换
        for (int i = 1; i <= arr.length - 1; i++){
            int tmp = arr[0];
            arr[0] = arr[arr.length - i];
            arr[arr.length - i] = tmp;
            maxHeapDown(arr, 0, arr.length - i - 1);
        }

    }

    private void maxHeapDown(int[] arr, int start, int end) {
        // 定义起始节点和左右子节点
        int cur = start;
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        // 循环遍历子树,比较当前值与子节点大小,直到结束
        while (left <= end) {
            // 左子节点为最后节点
            if (left == end) {
                if (arr[cur] < arr[left]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[left];
                    arr[left] = tmp;
                }
                break;
            }
            // 左右子节点较大的值下标
            int maxIndex;
            if (arr[left] > arr[right]) {
                maxIndex = left;
            } else {
                maxIndex = right;
            }
            if (arr[cur] < arr[maxIndex]) {
                int tmp = arr[cur];
                arr[cur] = arr[maxIndex];
                arr[maxIndex] = tmp;
            }
            cur = maxIndex;
            left = 2 * cur + 1;
            right = 2 * cur + 2;
        }
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] arr = {4, 5, 3, 2, 6, 7, 9, 1};
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建要给80000个的随机的数组, 大约需要21ms
        long start = Instant.now().toEpochMilli();
        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        sort.sort(arr);
        System.out.println(Instant.now().toEpochMilli() - start);
    }
}
