package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索二叉树
 *
 * @author nathan
 */
public class ThreadedBinaryTree<T> {
    Node<T> root;
    Node<T> preNode;

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        boolean isLeftThread;
        boolean isRightThread;


        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 中序线索化
     * @param node 当前节点
     * @param preNode 前驱节点
     */
    public void inorderThread(Node<T> node) {
        if (node == null) {
            return;
        }
        // 线索化左子树
        inorderThread(node.left);
        // 线索化当前节点, 考虑单链表的前驱后继节点的实现
        //左指针为空,将左指针指向前驱节点
        if (node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }
        //前一个节点的后继节点指向当前节点
        if (preNode != null && preNode.right == null ) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        // 每处理一个结点后，让当前结点是下一个结点的前驱结点
        preNode = node;
        // 线索化右子树
        inorderThread(node.right);
    }

    public List<T> inorderTraversal(Node<T> node) {
        List<T> list = new ArrayList<>();
        //1、找中序遍历方式开始的节点
        while(node != null && !node.isLeftThread) {
            node = node.left;
        }
        while(node != null) {
            list.add(node.data);
            //如果右指针是线索,则下移一位
            if(node.isRightThread) {
                node = node.right;
            } else {
                //如果右指针不是线索，找到右子树开始的节点
                node = node.right;
                while(node != null && !node.isLeftThread) {
                    node = node.left;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreadedBinaryTree<String> tree = new ThreadedBinaryTree<>();
//        Node<String> four1 = new Node<>("H", null, null);
        Node<String> third1 = new Node<>("D", null, null);
        Node<String> third2 = new Node<>("E", null, null);
        Node<String> third3 = new Node<>("F", null, null);
        Node<String> third4 = new Node<>("G", null, null);
        Node<String> sec1 = new Node<>("B", third1, third2);
        Node<String> sec2 = new Node<>("C", third3, third4);
        Node<String> root = new Node<>("A", sec1, sec2);
        tree.inorderThread(root);
        System.out.println(tree.inorderTraversal(root));
    }
}
