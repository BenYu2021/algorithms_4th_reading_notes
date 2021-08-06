package chapter301;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeMap;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: 一种有序的符号表API
 */
public class ST<Key extends Comparable<Key>, Value> {

    private TreeMap<Key, Value> st;

    /**
     * 创建一张符号表
     */
    public ST() {
        st = new TreeMap<Key, Value>();
    }


    /**
     * 将键值存入表中（若值为空将键key从表中删除）
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {

    }

    /**
     * 获取key对应的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return null;
    }

    /**
     * 从表中删去键key（及其对应的值）
     *
     * @param key
     */
    public void delete(Key key) {

    }

    /**
     * 键key在表中是否有对应的值
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return false;
    }

    /**
     * 表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 表中键值对的数量
     *
     * @return
     */
    public int size() {
        return 0;
    }


    /**
     * 最小的键
     *
     * @return
     */
    public Key min() {
        return null;
    }

    /**
     * 最大的键
     *
     * @return
     */
    public Key max() {
        return null;
    }


    /**
     * 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        return null;
    }

    /**
     * 大于等于key的最小键
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        return null;
    }


    /**
     * 小于key的键数量
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return 0;
    }

    /**
     * 排名为k的键
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return null;
    }

    /**
     * 删除最小的键
     */
    public void deleteMin() {

    }

    /**
     * 删除最大的键
     */
    public void deleteMax() {

    }


    /**
     * [lo,hi]之间的键的数量
     *
     * @param lo
     * @param hi
     * @return
     */
    public int size(int lo, int hi) {
        return 0;
    }


    /**
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(int lo, int hi) {
        return null;
    }

    /**
     * 表中所有键的集合，已排序
     *
     * @return
     */
    public Iterable<Key> keys() {
        return null;
    }


    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<String, Integer>();

        for (int i = 0; !st.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
