package com.nathan.learn.algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sort {

    public static void main(String[] args) {
        Sort test = new Sort();
//        int[] a = {4, 2, 3, 6, 5, 1, 2};
        int[] a = {5, 2, 3, 1};
//        int[] a = null;
//        test.mergeSort(a, 0, 6);
//        test.quickSort(a, 0 ,a.length-1);
//        System.out.println(Arrays.toString(test.topK(a, 3)));
        System.out.println(Arrays.toString(topKByPriorityQueue(a, 3)));
        System.out.println(Arrays.toString(smallKByPriorityQueue(a, 3)));
//        System.out.println(test.sortString("aBc"));
    }

    /**
     * 初始时： 前i个元素为已排序数组，剩余元素为要排序数组; 执行n-1趟排序
     * 排序：   每趟排序, 将要排序数组的第一个元素i插入已排序的前i-1个元素中
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    int k = i;
                    while (k > j) {
                        arr[k] = arr[k - 1];
                        k--;
                    }
                    arr[j] = tmp;
                }
            }
        }
    }


    /**
     * 对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)
     * 将待排序元素分成若干个组子序列，所有距离为gap的倍数的记录放在同一个组中；
     * 对各组内的元素进行直接插入排序。 这一趟排序完成之后，每一个组的元素都是有序的。
     * 然后减小gap的值，并重复执行上述的分组和排序。当gap=1时，整个数列就是有序的。
     */
    public void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int group = 0; group < gap; group++) {
                for (int i = group + gap; i < arr.length; i = i + gap) {
                    for (int j = group; j < i; j = j + gap) {
                        if (arr[i] < arr[j]) {
                            int tmp = arr[i];
                            int k = i;
                            while (k > j) {
                                arr[k] = arr[k - gap];
                                k = k - gap;
                            }
                            arr[j] = tmp;
                        }
                    }
                }
            }
        }
    }

    /**
     * 初始时： 前i个元素为已排序数组，剩余元素为要排序数组; 执行n趟排序
     * 排序：   每趟排序, 从要排序数组中选择最小的元素追加到已排序数组的末尾
     * <p>
     * 不稳定: 举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public void heapSortAsc(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapDown(arr, i, length - 1);
        }
        for (int i = length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            maxHeapDown(arr, 0, i - 1);
        }
    }


    private void maxHeapDown(int[] arr, int start, int end) {
        int current = start;
        int left = current * 2 + 1;

        for (; left <= end; current = left, left = current * 2 + 1) {
            if (left < end && arr[left] < arr[left + 1]) {
                left++;
            }
            if (arr[current] >= arr[left]) {
                break;
            } else {
                int tmp = arr[current];
                arr[current] = arr[left];
                arr[left] = tmp;
            }
        }
    }

    public int[] topK(int[] arr, int length) {
        if (arr == null) {
            return null;
        }
        if (length > arr.length) {
            heapSortDesc(arr);
            return arr;
        }
        int[] heap = new int[length];
        for (int i = 0; i < arr.length; i++) {
            if (i < length) {
                heap[i] = arr[i];
            } else {
                if (i == length) {
                    heapSortDesc(heap);
                }
                if (arr[i] > heap[0]) {
                    heap[0] = arr[i];
                    minHeapDown(heap, 0, length);
                }
            }
        }
        return heap;
    }

    //topk小顶堆
    public static int[] topKByPriorityQueue(int[] input, int k) {
        int[] arr = new int[k];
        if (k > input.length || k == 0) {
            return arr;
        }
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : input) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
        while (k-- > 0) {
            arr[k] = queue.poll();
        }
        return arr;
    }

    //smallk大顶堆
    public static int[] smallKByPriorityQueue(int[] input, int k) {
        int[] arr = new int[k];
        if (k > input.length || k == 0) {
            return arr;
        }
        Queue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> (o2 - o1));
        for (int num : input) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.offer(num);
            }
        }
        while (k-- > 0) {
            arr[k] = queue.poll();
        }
        return arr;
    }


    public void heapSortDesc(int[] arr) {
        if (arr == null) {
            return;
        }
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            minHeapDown(arr, i, length - 1);
        }
        for (int i = length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            minHeapDown(arr, 0, i - 1);
        }
    }

    private void minHeapDown(int[] arr, int start, int end) {
        int parent = start;
        int left = parent * 2 + 1;
        while (left < end) {
            if (left < end - 1 && arr[left] > arr[left + 1]) {
                left++;
            }
            if (arr[parent] < arr[left]) {
                break;
            } else {
                int tmp = arr[parent];
                arr[parent] = arr[left];
                arr[left] = tmp;
            }
            parent = left;
            left = parent * 2 + 1;
        }
    }

    /**
     * 初始时： 前i个元素为要排序数组，剩余元素为已排序数组; 执行n趟排序
     * 排序:   每趟排序, 遍历要排序数组, 依次比较前后两个元素, 若逆序则交换元素
     */
    public void bubblingSort(int[] arr) {
        boolean partialOrder;
        for (int i = 0; i < arr.length; i++) {
            partialOrder = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    partialOrder = false;
                }
            }
            if (partialOrder) {
                return;
            }
        }
    }


    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int cmp = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] > cmp) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] < cmp) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = cmp;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    //2,3,4,6,1,2,5
    //1,2,3,4,6,2,5
    public void merge(int[] arr, int start, int mid, int end) {
        int left = start, right = mid + 1;
        int tmp;
        while (left < right && right <= end) {
            if (arr[left] <= arr[right]) {
                left++;
            } else {
                tmp = arr[right];

                int idx = right;
                while (idx > left) {
                    arr[idx] = arr[idx - 1];
                    idx--;
                }

                arr[left] = tmp;

                left++;
                right++;
            }
        }
    }
}
