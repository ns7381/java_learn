package com.algorithm.greedy;

import java.util.*;

/**
 * 贪心算法的思想: 保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
 */
public class GreedyAlgorithm {

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

        // keyList用于存储符合要求的电台
        ArrayList<String> keyList = new ArrayList<>();
        // key用于存储每一轮遍历与areaList交集最多的电台
        String key = null;
        // 用于临时存储电台覆盖的城市
        Set<String> temp = new HashSet<>();
        // 结束条件是allAreas没有任何数据，即说明每个城市都被覆盖了
        while (!allAreas.isEmpty()) {
            // 遍历broadcasts
            for (String broadcastKey : broadcasts.keySet()) {
                temp.clear(); // 一定要清空，temp是临时存储的变量
                // 将当前电台覆盖的城市添加到临时存储的变量中
                temp.addAll(broadcasts.get(broadcastKey));
                // temp集合与areaList集合取交集，交集结果赋值给temp
                temp.retainAll(allAreas);
                // 判断temp的大小是否大于0，以及key值是否为空，
                // 如果不为空就判断本轮的交集大小是否大于上一次存储的key值对应的电台覆盖的城市，大于就重新赋值新的最优的结果(贪心算法核心部分)
                if (temp.size() > 0 && (key == null || temp.size() > broadcasts.get(key).size())) {
                    key = broadcastKey;
                }
            }
            // 一轮遍历完之后，判断key是否为空，不为空，就将key存入到keyList集合中，表示符合要求的电台
            // 最后将符合要求的电台所覆盖的城市，从areaList集合中移除掉，说明这些城市已被覆盖
            if (key != null) {
                keyList.add(key);
                allAreas.removeAll(broadcasts.get(key));
                key = null;
            }
        }

        // 输出结果
        System.out.println(keyList.toString());

    }
}
