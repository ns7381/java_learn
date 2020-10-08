package com.datastructure.array;

/**
 * @author nathan
 */
public class SparseArray {

    int[][] array;

    public SparseArray(int[][] arr) {
        // 第一次遍历原数组，获得原数组非零数据的个数
        int noZeroSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    noZeroSum++;
                }
            }
        }
        // 创建稀疏数组，第一行为原数组行数、列数和非零数据个数
        this.array = new int[noZeroSum+1][3];
        this.array[0] = new int[]{arr.length, arr[0].length, noZeroSum};
        // 第二次遍历原数组，填充稀疏数组
        noZeroSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    noZeroSum++;
                    this.array[noZeroSum][0] = i;
                    this.array[noZeroSum][1] = j;
                    this.array[noZeroSum][2] = arr[i][j];
                }
            }
        }
    }

    public void printOriginal() {
        for (int i = 0; i <this.array[0][0]; i++) {
            out:
            for (int j = 0; j < this.array[0][1]; j++) {
                for (int m = 1; m < this.array.length; m++) {
                    if (i == this.array[m][0] && j == this.array[m][1]) {
                        System.out.printf("%d\t", this.array[m][2]);
                        continue out;
                    }
                }
                System.out.printf("%d\t", 0);
            }
            System.out.println();
        }
    }

    public void print() {
        for (int i = 1; i < this.array.length; i++) {
            System.out.printf("%d\t", this.array[i][0]);
            System.out.printf("%d\t", this.array[i][1]);
            System.out.printf("%d\t", this.array[i][2]);
            System.out.println();
        }
    }

    public int[][] converseOriginal() {
        int[][] arr = new int[this.array[0][0]][this.array[0][1]];
        for (int i = 1; i < this.array.length; i++) {
            arr[this.array[i][0]][this.array[i][1]] = this.array[i][2];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arr[0][2] = 2;
        arr[1][3] = 3;
        arr[2][4] = 4;
        arr[3][0] = 5;
        arr[4][1] = 6;
        System.out.println("===========original array===========");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
        SparseArray sparseArray = new SparseArray(arr);

        System.out.println("===========sparse array===========");
        sparseArray.print();
        System.out.println("===========sparse array print original===========");
        sparseArray.printOriginal();
        System.out.println("===========sparse convert===========");
        arr = sparseArray.converseOriginal();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}
