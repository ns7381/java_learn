package com.algorithm.recursive;

import java.util.Arrays;

/**
 * 递归本质上就是一个栈帧中开辟了一个新的栈帧,新的栈帧同样也开辟了一个新的栈帧,直到条件达成,栈帧开始一层一层的返回
 * @author nathan
 */
public class Maze {
    /**
     *|function f1 stack|    |function f1 stack|    |function f1 stack|
     *|start            |    |start            |    |start            |
     *|终点?             |___ |balabala         |___ |balabala         |
     *|f1向下走?          ___  f1                ___ |f1
     *|f1向右走?          ___  f1                ___ |f1
     *|f1向上走?          ___  f1                ___ |f1
     *|f1向左走?          ___  f1                ___ |f1
     *|都不通?           |    |balabala         |    |balabala         |
     *|end              |    |end              |    |end              |
     * @param arr 迷宫数组, 0表示未走,1表示墙,2表示走通,3表示走过不通
     * @param i 起始行位置
     * @param j 起始列位置
     */
    public boolean walk(int[][] arr, int i, int j) {
        // 走到终点
        if (i == arr.length - 2 && j == arr[0].length - 2) {
            arr[i][j] = 2;
            return true;
        } else {
            // 当前还未走: 下->右->上->左依次递归
            if (arr[i][j] == 0) {
                arr[i][j] = 2;
                if (walk(arr, i + 1, j)
                        || walk(arr, i, j + 1)
                        || walk(arr, i - 1, j)
                        || walk(arr, i, j - 1)) {
                    return true;
                } else {
                    arr[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }

    }
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        new Maze().walk(maze, 1, 1);
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
    }
}
