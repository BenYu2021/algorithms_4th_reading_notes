package ch0301;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: 算法3.1 顺序查找（基于无序链表）
 */
public class SequentialSearchST<Key, Value> {

    private Node first;
    private int N; // 大小

    private class Node { // 链表的节点的定义
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        // 查找给定的键，返回相关联的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value; // 命中
            }
        }
        return null; // 未命中
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        // 查找给定的键，找到则更新其值，否则在表中新建节点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {  // 命中，更新
                x.value = val;
                return;
            }
        }
        first = new Node(key, val, first); // 插入头部，头插法
        N++;
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    public void delete1(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        Node prev = first;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                prev.next = x.next;
                N--;
                return;
            }
            prev = x.next;
        }
    }

    /**
     * 删除以节点x老师的键key
     *
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next; // 返回删除节点的后一个节点
        }
        x.next = delete(x.next, key); // 递归调用
        return x;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
/*

输入：
S E A R C H E X A M P L E

输出（因为TreeMap是有序的）：
L 11
P 10
M 9
X 7
H 5
C 4
R 3
A 8
E 12
S 0

 */