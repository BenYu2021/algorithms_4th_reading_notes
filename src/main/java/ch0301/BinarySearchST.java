package ch0301;

import ch01.Queue;

/**
 * @author: ymm
 * @date: 2021/7/9
 * @version: 1.0.0
 * @description: 算法3.2 二分查找（基于有序数组）
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public void put(Key key, Value val) {

        // 查找键，找到则更新值，否则创建新元素
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j++) {
            // [i..N]移到[i+1..N+1]
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
            // 插入到[i]
            keys[i] = key;
            vals[i] = val;
            N++;
        }
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 大于等于key的最小值
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key delete(Key key) {
        if (key == null) return null;
        if (!contains(key)) return null; // 要删除的键不在表中

        int index = rank(key);
        for (int i = index; i < N; i++) {
            keys[i] = keys[i + 1];
            vals[i] = vals[i + 1];
        }
        keys[N - 1] = null;
        vals[N - 1] = null;
        N--;

        return null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(hi);
        }
        return queue;
    }

    public boolean contains(Key key) {
        for (Key k : keys) {
            if (k.compareTo(key) == 0) return true;
        }
        return false;
    }

    /**
     * 小于key的键的数量
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(key, 0, size());
    }

    /**
     * 递归二分查找
     *
     * @param key
     * @param lo
     * @param hi
     * @return 返回表中小于它的键的数量
     * 如果表中存在键key，返回该键的位置，也就是表中小于它的键的数量。
     * 如果不存在，还是返回表中小于它的键的数量。lo或hi+1
     */
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1); // 如果找不到，返回的是lo即0
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi); // 如果找不到，返回的是hi+1
        } else {
            return mid;  // 如果找到，返回的是当前元素的索引
        }
    }

    /**
     * 迭代二分查找
     *
     * @param key
     * @return
     */
    public int rank1(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

}
