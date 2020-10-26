package com.algorithm.greedy;

import java.util.*;

/**
 * 贪心算法的思想: 保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
 */
public class GreedyAlgorithm {

    public void broadcastProblem(Map<String, HashSet<String>> broadcasts, Set<String> allAreas) {
        ArrayList<String> selects = new ArrayList<String>();
        while (allAreas.size() > 0) {

        }
    }


    public static void main(String[] args) {
        // 创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        // 将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        // allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        for (Map.Entry<String, HashSet<String>> broadcast : broadcasts.entrySet()) {
            allAreas.addAll(broadcast.getValue());
        }
    }
}
