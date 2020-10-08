package com.datastructure.link;

/**
 * @author nathan
 */
public class TwoWayLink {
    int size = 0;
    Node first = new Node(0);
    Node last = new Node(0);

    static class Node {
        int data;
        Node pre;
        Node next;

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index out range");
        }
        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.next = new Node(data, tmp, tmp.next);
        if (index == size) {
            last = tmp.next;
        }
        size++;
    }

    public void addFirst(int data) {
        add(0, data);
    }

    public void addLast(int data) {
        add(size, data);
    }

    public int remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("index out range");
        }
        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        int result = tmp.next.data;
        tmp.next = tmp.next.next;
        if (index == size - 1) {
            last = tmp;
        }
        size--;
        return result;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public static void main(String[] args) {
        TwoWayLink link = new TwoWayLink();
        link.addLast(0);
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(4);

        System.out.println(link.removeLast());
        System.out.println(link.removeLast());
        System.out.println(link.removeLast());
        System.out.println(link.removeLast());
        System.out.println(link.removeLast());
    }

}
