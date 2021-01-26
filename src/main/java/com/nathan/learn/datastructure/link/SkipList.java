package com.nathan.learn.datastructure.link;

import java.util.Random;

/**
 * 跳表的实现
 */
public class SkipList {
    public static final int MAX_LEVEL = 16; //跳表所允许的最大层级
    private SkipListNode head = new SkipListNode(null, MAX_LEVEL);
    private Random random = new Random();
    private int usedLevel = 1; //当前跳表使用中的最大层级

    public void insert(int value) {
        int level = randomLevel(); //找出当前插入值随机最大层数
        //遍历节点并插入
        insert(value, level);

    }

    public void delete(int value) {
        //从最高层开始，寻找节点
        int level = usedLevel;
        while (level >= 1) {
            level--;
            SkipListNode searchResult = search(value, level);
            if (searchResult != null) {
                deleteNode(searchResult);
                break;
            }
        }

    }

    //逐层打印
    public void print() {
        int level = usedLevel;
        while (level >= 1) {
            level--;
            printLevel(level);
        }
    }

    private void printLevel(int level) {
        SkipListNode current = head;
        String result = new String();
        while (current.next[level] != null) {
            result = result + current.next[level].data + " -> ";
            current = current.next[level];
        }
        System.out.println("第 " + level + " 层的数据为 : " + result);
    }

    private void deleteNode(SkipListNode searchResult) {
        //将当前节点的前置节点和后置节点关联起来即可
        int currentLevel = searchResult.getMaxlevel();
        while (currentLevel >= 1) {
            currentLevel--;
            //当前节点的前置节点的后置节点 = 当前节点的后置节点
            searchResult.pre[currentLevel].next[currentLevel] = searchResult.next[currentLevel];
            if (searchResult.next[currentLevel] != null) {
                //如果当前节点的后置节点不为null
                //当前节点的额后置节点的前置节点 = 当前节点的前置节点
                searchResult.next[currentLevel].pre[currentLevel] = searchResult.pre[currentLevel];
            }
        }
    }

    private SkipListNode search(int value, int level) {
        //从头开始遍历
        SkipListNode current = head;
        while (current.next[level] != null && current.next[level].data < value) {
            current = current.next[level];
        }
        if (current.next[level] == null || current.next[level].data != value) {
            //如果搜索到最后，或者已经搜索到比寻找值大的节点了
            return null;
        }
        return current.next[level];

    }

    private void insert(int value, int level) {
        SkipListNode node = new SkipListNode(value, level); //构造当前节点
        int currentLevel = level;
        while (currentLevel-- > 0) {
            //从最高层开始，遍历每一层
            if (head.next[currentLevel] == null) {
                //如果当前没有插入任何元素，直接插入即可
                head.next[currentLevel] = node;
                node.pre[currentLevel] = head;
            } else {
                SkipListNode current = head.next[currentLevel], pre = head;
                //从第一个元素开始遍历
                while (current != null && current.data < value) {
                    pre = current;
                    current = current.next[currentLevel];
                }
                //设置前置节点的后置节点为当前节点
                pre.next[currentLevel] = node;
                node.pre[currentLevel] = pre;
                if (current != null) {
                    //如果没有遍历到结尾，则需要设置当前节点的前置节点
                    current.pre[currentLevel] = node;
                    node.next[currentLevel] = current;
                }
            }

        }
        usedLevel = usedLevel > level ? usedLevel : level;
    }

    //随机生成函数，即对于任意一个要插入跳表的节点，它的层级为多少
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }


    private class SkipListNode {
        private Integer data;
        private SkipListNode[] next; //后置节点
        private SkipListNode[] pre; //前置节点，方便删除使用

        public SkipListNode(Integer data, int maxLevel) {
            this.data = data;
            next = new SkipListNode[maxLevel];
            pre = new SkipListNode[maxLevel];
        }

        int getMaxlevel() {
            return next.length;
        }

    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(10);
        skipList.insert(25);
        skipList.insert(83);
        skipList.insert(20);
        skipList.print();
        System.out.println("------------------");
        skipList.delete(83);
        skipList.delete(20);
        skipList.print();

    }
}
