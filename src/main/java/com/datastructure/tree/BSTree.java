package com.datastructure.tree;

public class BSTree<T extends Comparable<T>> {
    private Node root;
    public static class Node<T extends Comparable<T>> {
        private T key;
        private Node parent;
        private Node left;
        private Node right;

        public Node(T key, Node parent, Node left, Node right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(T t) {
        final Node<T> node = new Node<>(t, null, null, null);
        if (root == null) {
            root = node;
        } else {
            Node next = root;
            while (next != null) {
                if (next.left.key.compareTo(t) > 0) {
                    next = root;
                }
            }
        }

    }
}
