package com.nathan.learn.datastructure.tree;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 哈夫曼树
 * @author nathan
 */
public class HuffmanTree<T extends Comparable<T>> {
    Node<T> root;
    static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T data;
        int weight;
        Node<T> left;
        Node<T> right;

        public Node(int weight) {
            this(null, weight, null, null);
        }

        public Node(T data, int weight) {
            this(data, weight, null, null);
        }

        public Node(int weight, Node<T> left, Node<T> right) {
            this(null, weight, left, right);
        }

        public Node(T data, int weight, Node<T> left, Node<T> right) {
            this.data = data;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public HuffmanTree(Map<T, Integer> map) {
        // 构造优先队列
        Queue<Node<T>> nodes = new PriorityQueue<>();
        map.forEach((k, v) -> {
            nodes.add(new Node<T>(k, v));
        });

        while (nodes.size() > 1) {
            // 构造节点
            Node<T> node1 = nodes.poll();
            Node<T> node2 = nodes.poll();

            Node<T> parent = new Node<T>(node1.weight + node2.weight, node1, node2);

            nodes.add(parent);
        }
        root = nodes.poll();
    }


}
