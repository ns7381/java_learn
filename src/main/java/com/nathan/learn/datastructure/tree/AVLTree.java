package com.nathan.learn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T data;
        int height;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this(data, left, right, 0);
        }

        public Node(T data, Node<T> left, Node<T> right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }


        @Override
        public int compareTo(Node<T> o) {
            return data.compareTo(o.data);
        }
    }

    private int height(Node<T> node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    private void calHeight(Node<T> node) {
        if (node != null) {
            if (node.left == null && node.right != null) {
                node.height = height(node.right) + 1;
            } else if (node.right == null && node.left != null) {
                node.height = height(node.left) + 1;
            } else if (node.left != null) {
                node.height = Math.max(height(node.left), height(node.right)) + 1;
            }
        }
    }

    private Node<T> leftLeftRotation(Node<T> node) {
        Node<T> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        calHeight(node);
        calHeight(tmp);
        return tmp;
    }

    private Node<T> rightRightRotation(Node<T> node) {
        Node<T> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        calHeight(node);
        calHeight(tmp);
        return tmp;
    }

    private Node<T> leftRightRotation(Node<T> node) {
        node.left = rightRightRotation(node.left);
        return leftLeftRotation(node);
    }

    private Node<T> rightLeftRotation(Node<T> node) {
        node.right = leftLeftRotation(node.right);
        return rightRightRotation(node);
    }

    public Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
        } else {
            int cmp = data.compareTo(node.data);
            // 小于则插入左子树
            if (cmp < 0) {
                node.left = insert(node.left, data);
                //发生不平衡问题
                if (height(node.left) - height(node.right) == 2) {
                    //如果新节点插入到了node的左节点的左子树,则发生了LL
                    if (data.compareTo(node.left.data) < 0) {
                        node = leftLeftRotation(node);
                    } else {
                        node = leftRightRotation(node);
                    }
                }
            } else if (cmp > 0) {
                node.right = insert(node.right, data);
                if (height(node.right) - height(node.left) == 2) {
                    if (data.compareTo(node.right.data) > 0) {
                        node = rightRightRotation(node);
                    } else {
                        node = rightLeftRotation(node);
                    }
                }
            }
        }
        calHeight(node);
        return node;
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

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 1);
        List<Integer> results = new ArrayList<>();
        tree.inorderTraversal(tree.root, results);
        System.out.println(results);
    }
}
