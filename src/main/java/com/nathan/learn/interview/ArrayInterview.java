package com.nathan.learn.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ArrayInterview {

    /**
     * 计算坐标轴上点的数组中,可以组成的最小矩形的面积
     *
     * @param points (x, y)的坐标数组
     * @return 最小矩形的面积
     */
    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        Map<Integer, Set<Integer>> xMap = new HashMap<>();
        Map<Integer, Set<Integer>> yMap = new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            Set<Integer> setX = xMap.computeIfAbsent(x, k -> new HashSet<>());
            setX.add(y);

            Set<Integer> setY = yMap.computeIfAbsent(y, k -> new HashSet<>());
            setY.add(y);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (xMap.get(x1).contains(y2) &&
                        yMap.get(y1).contains(x2)) {
                    int area = Math.abs((x1 - x2) * (y1 - y2));
                    if (area > 0) {
                        result = Math.min(result, area);
                    }
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayInterview interview = new ArrayInterview();
        int[][] test = new int[][]{{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}};
        System.out.println(interview.minAreaRect(test));
    }
}