package com.nathan.learn.algorithm.dynamicProgramming;

import java.util.Scanner;

/**
 * 动态规划算法通常用于求解具有某种最优性质的问题。在这类问题中，可能会有许多可行解。每一个解都对应于一个值，我们希望找到具有最优值的解。
 * 动态规划算法与分治法类似，其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解
 */
public class DynamicProgrammingLearn {
    /**
     * 背包问题:
     * 在N件物品取出若干件放在容量为W的背包里，每件物品的体积为W1，W2……Wn（Wi为整数），与之相对应的价值为P1,P2……Pn（Pi为整数）。求背包能够容纳的最大价值。
     */
    public void backpackProblem() {
        Scanner scanner = new Scanner(System.in);
        // n 件物品
//        int num = 3;
        int num = scanner.nextInt();
        // 背包的最大容量
//        int maxCapacity = 4;
        int maxCapacity = scanner.nextInt();
        // 容量为capacity的背包能够容纳的最大价值
        int[] value = new int[maxCapacity + 1];
        int[] weight = new int[num + 1];
        int[] price = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            weight[i] = scanner.nextInt();
            price[i] = scanner.nextInt();
        }
        /*
        weight[1] = 1;
        price[1] = 1500;
        weight[2] = 4;
        price[2] = 3000;
        weight[3] = 3;
        price[3] = 2000;
        */

        for (int i = 1; i < num + 1; i++) {
            // ****逆序
            for (int capacity = maxCapacity; capacity > 0; capacity--) {
                // 如果背包的容量大于第i件商品, 容量为capacity的背包的最大价值为: 下列两种情况的最大值
                // 容量为capacity-1的背包的最大价值,
                // 第i件商品的价值加上容量为capacity-weight[i]的背包最大价值
                if (capacity >= weight[i]) {
                    value[capacity] = Math.max(value[capacity], price[i] + value[capacity - weight[i]]);
                }
            }
        }

        System.out.println(value[maxCapacity]);
    }

    public static void main(String[] args) {
        DynamicProgrammingLearn dynamicProgrammingLearn = new DynamicProgrammingLearn();
        dynamicProgrammingLearn.backpackProblem();
    }
}
