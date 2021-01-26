package com.nathan.learn.datastructure.link;

/**
 * @author nathan
 */
public class OneWayLink {
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
        size++;
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int removeFirst() {
        return remove(0);
    }

    public int remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("index out range");
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

    /**
     * 查找第几个元素
     *
     * @param index 元素下标，0~size-1
     * @return 元素数据
     */
    public int find(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("index out range");
        }
        // 从头结点后开始遍历
        Node tmp = head.next;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    /**
     * 查找倒数第几个元素
     *
     * @param index 从1开始
     * @return 元素数据
     */
    public int findBottom(int index) {
        if (index <= 0 || index > size) {
            throw new RuntimeException("index out range");
        }
        // 从头结点后开始遍历
        Node tmp = head.next;
        for (int i = 0; i < size - index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void reverse() {
        // 链表为空或者只有一个元素直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 反向链表的头结点
        Node reverseHead = new Node(0);
        Node cur = head.next;
        //遍历链表
        while (cur.next != null) {
            //保留原链表现场
            Node next = cur.next;
            //将当前节点放入反转链表的首元节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            //回复原链表现场
            cur = next;
        }
        cur.next = reverseHead.next;
        reverseHead.next = cur;
        head.next = reverseHead.next;
    }


    public static void main(String[] args) {
        OneWayLink link = new OneWayLink();
        link.addLast(0);
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(4);
        link.reverse();
        System.out.println(link.removeFirst());
        System.out.println(link.removeFirst());
        System.out.println(link.removeFirst());
        System.out.println(link.removeFirst());
        System.out.println(link.removeFirst());
//        System.out.println(link.findBottom(1));
//        System.out.println(link.find(1));
//        System.out.println(link.findBottom(2));
//        System.out.println(link.findBottom(3));
//        System.out.println(link.findBottom(4));
//        System.out.println(link.findBottom(5));
//        System.out.println(link.findBottom(6));
    }
}
