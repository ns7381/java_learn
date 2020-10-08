package com.datastructure.link;

/**
 * @author nathan
 */
public class OneWayCycleLink {
    int size = 0;
    /**
     *  带头结点的单向链表，统一插入删除操作
     */
    Node head = new Node(0, null);

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addLast(int data) {
        add(size, data);
    }

    public void addFirst(int data) {
        add(0, data);
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index out range");
        }
        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(data);
        node.next = tmp.next;
        tmp.next = node;
        if (0 == size) {
            node.next = head.next;
        }
        size++;
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int removeFirst() {
        return remove(0);
    }

    public int remove(int index) {
        if (index < 0) {
            throw new RuntimeException("index no valid");
        }
        if (size == 0) {
            throw new RuntimeException("link is empty");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        int result = tmp.next.data;
        tmp.next = tmp.next.next;
        size--;
        return result;
    }

    public Node remove(Node start, int index) {
        if (index < 0) {
            throw new RuntimeException("index no valid");
        }
        if (size == 0) {
            throw new RuntimeException("link is empty");
        }
        Node tmp = start;
        for (int i = 0; i < index - 2; i++) {
            tmp = tmp.next;
        }
        int result = tmp.next.data;
        System.out.println(result);
        tmp.next = tmp.next.next;
        size--;
        return tmp.next;
    }

    /**
     *  约瑟夫问题
     * @param index 从哪个位置开始数数
     * @param count 数到几出列
     */
    public void joseph(int index, int count) {
        if (index < 0) {
            throw new RuntimeException("index no valid");
        }
        if (size == 0) {
            throw new RuntimeException("link is empty");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        Node next = tmp.next;
        while (size != 0) {
            next = remove(next, count);
        }

    }

    public static void main(String[] args) {
        OneWayCycleLink link = new OneWayCycleLink();
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(4);
        link.addLast(5);
        link.joseph(0, 2);
    }

}
