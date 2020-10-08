package com.algorithm.recursive;

import java.util.Arrays;

/**
 * @author nathan
 */
public class EightQueen {
    /**
     *  皇后依行放置列位置数组
     */
    private final int[] arr;
    /**
     *  棋盘大小
     */
    private final int size;

    public EightQueen(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public void walk(int row) {
        // 回归条件, 行数结束
        if (row == size) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        // 依次放入每一列, 不冲突就放入皇后
        for (int col = 0; col < size; col++) {
            arr[row] = col;
            if (!isConflict(row)) {
                walk(row + 1);
            }
        }
    }

    private boolean isConflict(int row) {
        for (int preRow = 0; preRow < row; preRow++) {
            // 同一列或者是同一斜线
            if (arr[preRow] == arr[row] || row - preRow == Math.abs(arr[row] - arr[preRow])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen(8);
        eightQueen.walk(0);
    }
}
