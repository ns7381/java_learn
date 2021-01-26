package com.nathan.learn.datastructure.tree;

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
        Node<T> parent;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this(data, left, right, null);
        }

        public Node(T data, Node<T> left, Node<T> right, Node<T> parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
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
            // 比父节点大,则向右遍历
            if (t.compareTo(parent.data) > 0) {
                if (parent.right == null) {
                    parent.right = node;
                    node.parent = parent;
                    return;
                }
                parent = parent.right;
            } else {
                // 比父节点x小,则向左遍历
                if (parent.left == null) {
                    parent.left = node;
                    node.parent = parent;
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

    /**
     * 查找最小节点
     * @param node
     * @return
     */
    public Node<T> minNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 查找最大节点
     * @param node
     * @return
     */
    public Node<T> maxNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 查找前驱节点
     * @param node
     * @return
     */
    public Node<T> precursorNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        // 左子树为空时:
        //   node为右子节点,则返回父节点;
        //   node为左子节点,父节点为右子节点时返回祖父节点,父节点为左子节点时返回null
        if (node.left == null) {
            if (node.parent.right == node) {
                return node.parent.parent;
            } else {
                return null;
            }
        }
        // 左子树不为空时,返回左子树的最大节点
        return maxNode(node.left);
    }

    /**
     * 查找后继节点
     * @param node
     * @return
     */
    public Node<T> successorNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        // 右子树为空时:
        //   node为左子节点, 则返回父节点
        //   node为右子节点, 父节点为左子节点时返回祖父节点, 否则返回null
        if (node.right == null) {
            if (node.parent.left == node) {
                return node.parent.parent;
            } else {
                return null;
            }
        }
        // 右子树不为空时,返回右子树的最小节点
        return minNode(node.right);
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
     * 删除节点
     * @param data
     */
    public void remove(T data) {
        Node<T> deleteNode = search(data);
        if (deleteNode == null) {
            return;
        }
        if (deleteNode.data == root.data) {
            root = deleteNode.left != null ? deleteNode.left : deleteNode.right;
            return;
        }
        // 1. 被删除节点没有子树---直接删除
        if (deleteNode.left == null && deleteNode.right == null) {
            if (deleteNode.parent.left == deleteNode) {
                deleteNode.parent.left = null;
            } else {
                deleteNode.parent.right = null;
            }
        }
        // 2. 被删除节点只有一个子树---孩子顶替
        else if (deleteNode.left == null) {
            if (deleteNode.parent.left == deleteNode) {
                deleteNode.parent.left = deleteNode.right;
            } else {
                deleteNode.parent.right = deleteNode.right;
            }
        } else if (deleteNode.right == null) {
            if (deleteNode.parent.left == deleteNode) {
                deleteNode.parent.left = deleteNode.left;
            } else {
                deleteNode.parent.right = deleteNode.left;
            }
        }
        // 3. 被删除节点有左右子树---前驱节点顶替
        else {
            if (deleteNode.parent.left == deleteNode) {
                deleteNode.parent.left = precursorNode(deleteNode);
            } else {
                deleteNode.parent.right = precursorNode(deleteNode);
            }
        }
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

        tree.remove(0);
        results = new ArrayList<>();
        tree.inorderTraversal(tree.root, results);
        System.out.println(results);
    }
}
