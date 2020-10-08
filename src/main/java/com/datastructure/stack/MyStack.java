package com.datastructure.stack;

/**
 * @author nathan
 */
public class MyStack<T> {
    int size;
    int top;
    Object[] arr;

    public MyStack() {
        this(1 << 4);
    }

    public MyStack(int size) {
        if (size < 1) {
            throw new RuntimeException("size must greater than 0");
        }
        this.size = size;
        this.top = -1;
        this.arr = new Object[size];
    }

    public boolean isFull() {
        return size-1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean push(T data) {
        if (isFull()) {
            return false;
        }
        arr[++top] = data;
        return true;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack empty");
        }
        return (T)arr[top];
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack empty");
        }
        return (T)arr[top--];
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
