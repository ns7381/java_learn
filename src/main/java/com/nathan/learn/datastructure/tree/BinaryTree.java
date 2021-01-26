package com.nathan.learn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 *
 * @author nathan
 */
public class BinaryTree<T> {
    Node<T> root;

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public List<T> preorderTraversal(Node<T> node, List<T> list) {
        if (node == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        // 输出当前节点
        list.add(node.data);
        // 遍历左子树
        preorderTraversal(node.left, list);
        // 遍历右子树
        preorderTraversal(node.right, list);
        return list;
    }

    public Node<T> preorderSearch(Node<T> node, T findValue) {
        if (node == null) {
            return null;
        }
        // 比较当前节点
        if (findValue.equals(node.data)) {
            return node;
        }
        // 查找左子树
        Node<T> findNode = preorderSearch(node.left, findValue);
        if (findNode != null) {
            return findNode;
        }
        // 查找右子树
        return preorderSearch(node.right, findValue);
    }

    public List<T> inorderTraversal(Node<T> node, List<T> list) {
        if (node == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        // 遍历左子树
        inorderTraversal(node.left, list);
        // 输出当前节点
        list.add(node.data);
        // 遍历右子树
        inorderTraversal(node.right, list);
        return list;
    }

    public Node<T> inorderSearch(Node<T> node, T findValue) {
        if (node == null) {
            return null;
        }
        // 查找左子树
        Node<T> findNode = inorderSearch(node.left, findValue);
        if (findNode != null) {
            return findNode;
        }
        // 比较当前节点
        if (findValue.equals(node.data)) {
            return node;
        }
        // 查找右子树
        return preorderSearch(node.right, findValue);
    }

    public List<T> postorderTraversal(Node<T> node, List<T> list) {
        if (node == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        // 遍历左子树
        postorderTraversal(node.left, list);
        // 遍历右子树
        postorderTraversal(node.right, list);
        // 输出当前节点
        list.add(node.data);
        return list;
    }


    public Node<T> postorderSearch(Node<T> node, T findValue) {
        if (node == null) {
            return null;
        }
        // 查找左子树
        Node<T> findNode = postorderSearch(node.left, findValue);
        if (findNode != null) {
            return findNode;
        }

        // 查找右子树
        findNode = postorderSearch(node.right, findValue);
        if (findNode != null) {
            return findNode;
        }
        // 比较当前节点
        if (findValue.equals(node.data)) {
            return node;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>();
        Node<String> four1 = new Node<>("H", null, null);
        Node<String> third1 = new Node<>("D", null, four1);
        Node<String> third2 = new Node<>("E", null, null);
        Node<String> third3 = new Node<>("F", null, null);
        Node<String> third4 = new Node<>("G", null, null);
        Node<String> sec1 = new Node<>("B", third1, third2);
        Node<String> sec2 = new Node<>("C", third3, third4);
        Node<String> root = new Node<>("A", sec1, sec2);


        System.out.println(tree.preorderTraversal(root, null));
        System.out.println(tree.inorderTraversal(root, null));
        System.out.println(tree.postorderTraversal(root, null));

        Node<String> node1 = tree.preorderSearch(root, "H");
        Node<String> node2 = tree.inorderSearch(root, "H");
        Node<String> node3 = tree.postorderSearch(root, "H");
        System.out.println(node1.data);
        System.out.println(node2.data);
        System.out.println(node3.data);
    }
}
