package com.base.collection;

import java.util.PriorityQueue;

/**
 * Created by nathan on 16/12/25.
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    public class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return +1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return +1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "ToDoItem{" +
                    "primary=" + primary +
                    ", secondary=" + secondary +
                    ", item='" + item + '\'' +
                    '}';
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(pri, sec, td));
    }

    public static void main(String[] args) {
        ToDoList toDoItems = new ToDoList();
        toDoItems.add("test", 'a', 1);
        toDoItems.add("test", 'y', 2);
        toDoItems.add("test", 'e', 3);
        toDoItems.add("test", 't', 4);
        toDoItems.add("test", 'e', 3);
        toDoItems.add("test", 'r', 41);
        System.out.println(toDoItems);
    }
}
