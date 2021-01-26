package com.nathan.learn.base.grammar.generic;

/**
 * Created by nathan on 16/9/14.
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;

        }

        boolean end() {
            return item == null &&  next ==null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> test = new LinkedStack<>();
        for (String s : "test is a hard".split(" ")) {
            test.push(s);
        }
        String pop;
        while ((pop = test.pop()) != null) {
            System.out.println(pop);
        }
    }
}
