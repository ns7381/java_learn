package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的顺序存储
 *
 * @author nathan
 */
public class ArrayBinaryTree<T> {
    T[] nodes;

    public ArrayBinaryTree(T[] nodes) {
        this.nodes = nodes;
    }

    /**
     * 前序遍历的顺序存储二叉树版
     *
     * @param nodes 二叉树的存储数组
     * @param list  遍历结果
     * @return 遍历结果链表
     */
    public List<T> preorderTraversal(int index, List<T> list) {
        if (index < 0 || index > nodes.length - 1) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        // 输出当前节点
        list.add(nodes[index]);
        // 遍历左子树
        preorderTraversal(2 * index + 1, list);
        // 遍历右子树
        preorderTraversal(2 * index + 2, list);
        return list;
    }

    /**
     * 中序遍历的顺序存储二叉树版
     *
     * @param nodes 二叉树的存储数组
     * @param list  遍历结果
     * @return 遍历结果链表
     */
    public List<T> inorderTraversal(int index, List<T> list) {
        if (index < 0 || index > nodes.length - 1) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        // 遍历左子树
        inorderTraversal(2 * index + 1, list);
        // 输出当前节点
        list.add(nodes[index]);
        // 遍历右子树
        inorderTraversal(2 * index + 2, list);
        return list;
    }

    /**
     * 后序遍历的顺序存储二叉树版
     *
     * @param nodes 二叉树的存储数组
     * @param list  遍历结果
     * @return 遍历结果链表
     */
    public List<T> postorderTraversal(int index, List<T> list) {
        if (index < 0 || index > nodes.length - 1) {
            return list;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        // 遍历左子树
        postorderTraversal(2 * index + 1, list);
        // 遍历右子树
        postorderTraversal(2 * index + 2, list);
        // 输出当前节点
        list.add(nodes[index]);
        return list;
    }

    public static void main(String[] args) {
        String[] nodes = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        ArrayBinaryTree<String> tree = new ArrayBinaryTree<>(nodes);
        System.out.println(tree.preorderTraversal(0, null));
        System.out.println(tree.inorderTraversal(0, null));
        System.out.println(tree.postorderTraversal(0, null));
    }
}
