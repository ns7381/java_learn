package com.datastructure.queue;

public class MyCircularQueue<T> {
    int head;
    int tail;
    int size;
    Object[] array;

    public MyCircularQueue(int length) {
        //因为tail指向队尾的最后一个元素的后一个元素，所以数组长度要比队列长度加一
        this.size = length + 1;
        this.array = new Object[length + 1];
        //队列的第一个元素
        this.head = 0;
        //队尾的最后一个元素的后一个位置
        this.tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }
        array[tail] = value;
        tail = (tail + 1) % size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        T value = (T) array[head];
        head = (head + 1) % size;
        return value;
    }

    public static void main(String[] args) {
        MyCircularQueue<Integer> myCircularQueue = new MyCircularQueue<>(5);
        myCircularQueue.enqueue(0);
        myCircularQueue.enqueue(1);
        myCircularQueue.enqueue(2);
        myCircularQueue.enqueue(3);
        System.out.println(myCircularQueue.dequeue());
        System.out.println(myCircularQueue.dequeue());
        myCircularQueue.enqueue(4);
        myCircularQueue.enqueue(5);
        System.out.println(myCircularQueue.dequeue());
        System.out.println(myCircularQueue.dequeue());
        System.out.println(myCircularQueue.dequeue());
        System.out.println(myCircularQueue.dequeue());
    }
}