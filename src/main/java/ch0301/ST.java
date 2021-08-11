package ch0301;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: 一种有序的符号表API
 */
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    /**
     * 创建一张符号表
     */
    public ST() {
        st = new TreeMap<Key, Value>();
    }

    /**
     * 获取key对应的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    /**
     * 将键值存入表中（若值为空将键key从表中删除）
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) st.remove(key);
        else st.put(key, val);
    }

    /**
     * 从表中删去键key（及其对应的值）
     *
     * @param key
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("calls remove() with null key");
        st.remove(key);
    }

    /**
     * 键key在表中是否有对应的值
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    /**
     * 表中键值对的数量
     *
     * @return
     */
    public int size() {
        return st.size();
    }

    /**
     * 表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 表中所有键的集合，已排序
     *
     * @return
     */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    @Override
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * 最小的键
     *
     * @return
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return st.firstKey();
    }

    /**
     * 最大的键
     *
     * @return
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return st.lastKey();
    }

    /**
     * 大于等于key的最小键
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("argument to ceiling() is too large");
        return k;
    }

    /**
     * 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("argument to floor() is too small");
        return k;
    }

    /**
     * 简单的符号呢测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }

}
/*

输入：
S E A R C H E X A M P L E

输出（因为TreeMap是有序的）：
A 8
C 4
E 12
H 5
L 11
M 9
P 10
R 3
S 0
X 7

 */