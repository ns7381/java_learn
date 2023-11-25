/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.nathan.learn.datastructure.graph;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import org.junit.Test;

import java.util.Set;

/**
 * @author ningsheng
 * @version GuavaLearn.java, v 0.1 2023年05月05日 11:11 AM ningsheng
 */
public class GuavaGraphLearn {
    @Test
    public void testMutableGraph() {
        MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(2, 4);
        graph.putEdge(4, 5);
        graph.putEdge(5, 6);
        Set<Integer> predecessors = graph.predecessors(4);
        System.out.println(predecessors);
// predecessors will contain the set of predecessor nodes of node 4.
    }
}