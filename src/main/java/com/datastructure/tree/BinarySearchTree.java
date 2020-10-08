package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找/排序树
 *
 * @author nathan
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        @Override
        public int compareTo(Node<T> o) {
            return data.compareTo(o.data);
        }
    }

    public void insert(T t) {
        if (t == null) {
            return;
        }

        Node<T> parent = root;
        Node<T> node = new Node<>(t);
        if (root == null) {
            root = node;
        }
        while (parent != null) {
            if (t.compareTo(parent.data) > 0) {
                if (parent.right == null) {
                    parent.right = node;
                    return;
                }
                parent = parent.right;
            } else {
                if (parent.left == null) {
                    parent.left = node;
                    return;
                }
                parent = parent.left;
            }
        }
    }

    public Node<T> search(T t) {
        if (t == null || root == null) {
            return null;
        }

        Node<T> cur = root;
        while (true) {
            if (t.compareTo(cur.data) > 0) {
                if (cur.right == null) {
                    return null;
                }
                cur = cur.right;
            } else if (t.compareTo(cur.data) < 0) {
                if (cur.left == null) {
                    return null;
                }
                cur = cur.left;
            } else {
                return cur;
            }
        }
    }

    public void inorderTraversal(Node<T> node, List<T> results) {
        if (node == null) {
            return;
        }
        if (results == null) {
            results = new ArrayList<>();
        }
        inorderTraversal(node.left, results);
        results.add(node.data);
        inorderTraversal(node.right, results);
    }

    /**
     * TODO
     * @param data
     */
    public void remove(T data) {

    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(0);
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        System.out.println(tree.search(3));
        List<Integer> results = new ArrayList<>();
        tree.inorderTraversal(tree.root, results);
        System.out.println(results);
    }
}
