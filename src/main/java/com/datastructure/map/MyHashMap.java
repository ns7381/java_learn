package com.datastructure.map;

/**
 * JDK1.8 中HashMap的实现原理已经足够好,建议阅读
 * 关键点: 哈希函数, 解决哈希冲突(1. 开放地址法 2. 链地址法)
 *
 * @author nathan
 */
public class MyHashMap<K, V> {

    /**
     * 定义初始化链表大小
     */
    private final int INITIAL_SIZE = 1 << 4;

    /**
     * 定义哈希表
     */
    private Node<K, V>[] table;

    /**
     * 定义Node保存放入的key和value值, 统一链表的存放
     */
    class Node<K, V> {
        K key;
        V value;
        int hash;
        Node<K, V> next;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    public MyHashMap() {
        this.table = new Node[INITIAL_SIZE];
    }

    public void put(K key, V value) {
        // 计算hash值
        int hash = hash(key);
        int index = index(hash);
        // 获得hash表中的第一个元素
        Node<K, V> p = table[index];
        // 第一个元素为null,则插入当前值
        if (p == null) {
            table[index] = new Node<>(key, value, hash, null);
        } else {
            // 比较key值,相同则修改哈希表中的value
            if (hash == p.hash && key == p.key) {
                p.value = value;
                table[index] = p;
            } else {
                // 不同则查找链表里的值,找到则修改,没有则插入
                boolean find = false;
                while (p.next != null) {
                    p = p.next;
                    if (hash == p.hash && key == p.key) {
                        find = true;
                        p.value = value;
                    }
                }
                if (!find) {
                    p.next = new Node<>(key, value, hash, null);
                }
            }
        }
    }

    public V get(K key) {
        // 计算hash值
        int hash = hash(key);
        int index = index(hash);
        Node<K, V> p = table[index];
        while (p != null) {
            if (hash == p.hash && key == p.key) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 高16bit不变，低16bit和高16bit做了一个异或.原理:
     * 1. JDK默认的hashCode是jvm根据对象地址计算的,其中String类的重写逻辑是使用幂的连乘来得出
     * 2. 在设计hash函数时，因为目前的table长度n为2的幂，而计算下标的时候，是(table.length - 1) & hash这样实现的(使用&位操作，而非%求余)
     * 设计者认为这方法很容易发生碰撞。为什么这么说呢？不妨思考一下，在n - 1为15(0x1111)时，其实散列真正生效的只是低4bit的有效位，当然容易碰撞了。
     * 因此，设计者想了一个顾全大局的方法(综合考虑了速度、作用、质量)，就是把高16bit和低16bit异或了一下。
     * 设计者还解释到因为现在大多数的hashCode的分布已经很不错了，就算是发生了碰撞也用O(logn)的tree去做了。
     * 仅仅异或一下，既减少了系统的开销，也不会造成的因为高位没有参与下标的计算(table长度比较小时)，从而引起的碰撞。
     * <p>
     * 重写equals方法必须重写hashCode方法.
     * 通过对key的hashCode()进行hashing，并计算下标( n-1 & hash)，从而获得buckets的位置。如果产生碰撞，则利用key.equals()方法去链表或树中去查找对应的节点
     *
     * @param hashCode key值得hashCode
     * @return hash值
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 任意数对2的N次方取模时，等同于其和2的N次方-1作位于运算。所以数组长度要取2的幂
     * k % 2^n = k & (2^n - 1)
     * 而位于运算相比于取模运算速度大幅度提升（按照Bruce Eckel给出的数据，大约可以提升5～8倍)。
     *
     * @param hash 对hashCode哈希之后的哈希值
     * @return 哈希表的下标值
     */
    private int index(int hash) {
        return (table.length - 1) & hash;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("test1", 1);
        map.put("test2", 2);
        map.put("test3", 3);
        System.out.println(map.get("test2"));
    }

}
