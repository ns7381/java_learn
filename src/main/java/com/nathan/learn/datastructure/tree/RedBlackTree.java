package com.nathan.learn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<T extends Comparable<T>> {
    public static final boolean RED = false;
    public static final boolean BLACK = true;

    private Node<T> root;

    static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T data;
        boolean color;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this(data, left, right, RED);
        }

        public Node(T data, Node<T> left, Node<T> right, boolean color) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.color = color;
        }


        @Override
        public int compareTo(Node<T> o) {
            return data.compareTo(o.data);
        }
    }

    /**
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     * @param node x节点
     */
    private void leftRotate(Node<T> node) {
        // 子树的新根节点记为tmp
        Node<T> tmp = node.right;
        // x的右子节点改为tmp的左子节点, 同步更新父子关系
        node.right = tmp.left;
        if (tmp.left != null) {
            tmp.left.parent = node;
        }

        // 设置新根节点的父节点, 同步更新父子关系
        tmp.parent = node.parent;
        if (node.parent == null) {
            this.root = tmp;
        } else {
            if (node.parent.left == node) {
                node.parent.left = tmp;
            } else {
                node.parent.right = tmp;
            }
        }

        // 更新新旧根节点的关系, 同步更新父子关系
        tmp.left = node;
        node.parent = tmp;
    }

    /**
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x                  
     *         /  \      --(右旋)-.            /  \                     
     *        x   ry                           lx   y  
     *       / \                                   / \                   
     *      lx  rx                                rx  ry
     *
     * @param node y节点
     */
    private void rightRotate(Node<T> node) {
        // 子树的新根节点记为tmp
        Node<T> tmp = node.left;
        // y的左子节点改为tmp的右子节点, 同步更新父子关系
        node.left = tmp.right;
        if (tmp.right != null) {
            tmp.right.parent = node;
        }

        // 设置新根节点的父节点, 同步更新父子关系
        tmp.parent = node.parent;
        if (node.parent == null) {
            this.root = tmp;
        } else {
            if (node.parent.left == node) {
                node.parent.left = tmp;
            } else {
                node.parent.right = tmp;
            }
        }

        // 更新新旧根节点的关系, 同步更新父子关系
        tmp.right = node;
        node.parent = tmp;
    }

    public void insert(T data) {
        insert(new Node<T>(data));
    }

    private void insert(Node<T> node) {
        Node<T> parent = null;
        Node<T> tmp = root;
        // 查找节点插入的父节点
        while (tmp != null) {
            parent = tmp;
            if (node.data.compareTo(tmp.data) < 0) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        node.parent = parent;

        // 将节点赋给父节点的子节点
        if (parent == null) {
            this.root = node;
        } else {
            if (node.data.compareTo(parent.data) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        
        // 设置节点的颜色
        node.color = RED;

        // 重新修正
        insertFixUp(node);
    }

    private void insertFixUp(Node<T> node) {
        Node<T> gParent;
        Node<T> uncle;
        // 如果父节点存在,并且父节点为红色
        for (Node<T> parent = node.parent; parent != null && parent.color == RED;) {
            gParent = parent.parent;
            if (parent == gParent.left) {
                uncle = gParent.right;
                // 情况一: 插入节点的父节点和叔叔节点均为红色
                if (uncle != null && uncle.color == RED) {
                    uncle.color = BLACK;
                    parent.color = BLACK;
                    gParent.color = RED;
                    // 继续平衡祖父节点
                    node = gParent;
                    continue;
                }
                // 情况二: 插入节点的父节点为红色, 叔叔节点为黑色, 且插入节点为父节点的右子节点
                if (node == parent.right) {
                    Node<T> tmp = parent;
                    leftRotate(parent);
                    parent = node;
                    node = tmp;
                }
                // 情况三: 插入节点的父节点为红色, 叔叔节点为黑色, 且插入节点为父节点的左子节点

                parent.color = BLACK;
                gParent.color = RED;
                rightRotate(gParent);
            } else {
                uncle = gParent.left;
                // 情况一: 插入节点的父节点和叔叔节点均为红色
                if (uncle != null && uncle.color == RED) {
                    uncle.color = BLACK;
                    parent.color = BLACK;
                    gParent.color = RED;
                    // 继续平衡祖父节点
                    node = gParent;
                    continue;
                }
                // 情况二: 插入节点的父节点为红色, 叔叔节点为黑色, 且插入节点为父节点的左子节点
                if (node == parent.left) {
                    Node<T> tmp = parent;
                    rightRotate(parent);
                    parent = node;
                    node = tmp;
                }
                // 情况三: 插入节点的父节点为红色, 叔叔节点为黑色, 且插入节点为父节点的右子节点
                parent.color = BLACK;
                gParent.color = RED;
                leftRotate(gParent);
            }
        }
        root.color = BLACK;
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
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(0);
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        List<Integer> results = new ArrayList<>();
        tree.inorderTraversal(tree.root, results);
        System.out.println(results);
    }
}
