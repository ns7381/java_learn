package com.nathan.learn.collection.performance;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {

    public static void testTreeMap() {
        TreeMapDemo treeMap = new TreeMapDemo();
        List<String> sources = Util.getRandomPath(100000);
        List<String> targets = Util.getRandomKeys(5);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (String source : sources) {
            treeMap.put(source, targets.get(Util.nextInt(5)));
        }
        stopWatch.stop();

        System.out.println("Put: " + treeMap.getClass().getSimpleName() +
                ", num = " + sources.size() +
                ", spendTime = " + stopWatch.getTime() +
                ", kv_size = " + treeMap.size());
        Util.calculateObjectSize(treeMap);

        List<String> keys = new ArrayList<>(sources.subList(0, sources.size() / 2));

        String path;
        for (int i = sources.size() / 2; i < sources.size(); i++) {
            path = sources.get(i);
            String[] split = path.split("/");
            split[split.length - 1] = Util.nextString(5);
            keys.add(String.join("/", split));
        }


        stopWatch.reset();
        stopWatch.start();
        for (String key : keys) {
            treeMap.findDeepest(key);
        }
        stopWatch.stop();
        System.out.println("Get: " + treeMap.getClass().getSimpleName() +
                ", num = " + keys.size() +
                ", spendTime = " + stopWatch.getTime());
    }


    public static void testPathTrie() {
        PathTrie treeMap = new PathTrie();
        List<String> sources = Util.getRandomPath(100000);
        List<String> targets = Util.getRandomKeys(5);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (String source : sources) {
            treeMap.addPath(source, targets.get(Util.nextInt(5)));
        }
        stopWatch.stop();

        System.out.println("Put: " + treeMap.getClass().getSimpleName() +
                ", num = " + sources.size() +
                ", spendTime = " + stopWatch.getTime());
        Util.calculateObjectSize(treeMap);

        List<String> keys = new ArrayList<>(sources.subList(0, sources.size() / 2));

        String path;
        for (int i = sources.size() / 2; i < sources.size(); i++) {
            path = sources.get(i);
            String[] split = path.split("/");
            split[split.length - 1] = Util.nextString(5);
            keys.add(String.join("/", split));
        }


        stopWatch.reset();
        stopWatch.start();
        for (String key : keys) {
            treeMap.findMaxPrefix(key);
        }
        stopWatch.stop();
        System.out.println("Get: " + treeMap.getClass().getSimpleName() +
                ", num = " + keys.size() +
                ", spendTime = " + stopWatch.getTime());
    }

    public static void main(String[] args) {
//        testTreeMap();
        testPathTrie();
    }

}
