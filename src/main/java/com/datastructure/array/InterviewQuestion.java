package com.datastructure.array;

import java.util.PriorityQueue;

/**
 * @author nathan
 */
public class InterviewQuestion {

    /**
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     *
     * @param nums
     */
    static void moveZeros(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] results = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                results[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return results;
    }

    static int[] findMaxConsecutiveNum(int[] nums) {
        int curVal = nums[0], curCount = 1, maxVal = nums[0], maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (++curCount > maxCount) {
                    maxCount = curCount;
                    maxVal = curVal;
                }
            } else {
                curVal = nums[i];
                curCount = 1;
            }
        }
        return new int[]{maxVal, maxCount};
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }


    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) { // 小根堆，去掉 k - 1 个堆顶元素，此时堆顶元素就是第 k 的数
            Tuple t = pq.poll();
            if (t.x == m - 1) {
                continue;
            }
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

    public static void main(String[] args) {
        final InterviewQuestion interviewQuestion = new InterviewQuestion();
//        final int[] nums = {1, 2, 3, 4, 0, 5};
//        moveZeros(nums);
//        System.out.println(Arrays.toString(nums));

//        int[][] nums = {{1, 2, 3}, {4, 5, 6}};
//        System.out.println(Arrays.deepToString(matrixReshape(nums, 3, 2)));

//        System.out.println(Arrays.toString(findMaxConsecutiveNum(new int[]{1,1,1,2,3,4,4,5,5,5,5})));

//        int[][] nums = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
//        System.out.println(searchMatrix(nums, 11));
        int[][] nums = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
//        System.out.println(kthSmallest(nums, 2));
        System.out.println(interviewQuestion.kthSmallest2(nums, 2));
    }
}
