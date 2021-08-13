package ch0304;

import ch0301.SequentialSearchST;

/**
 * @author: ymm
 * @date: 2021/8/12
 * @version: 1.0.0
 * @description: 算法3.5 基于拉链法的散列表
 */
public class SeparateChainingST<Key, Value> {
    private int N; // 键值对的数量
    private int M; // 散列表的大小
    private SequentialSearchST<Key, Value>[] st; // 存放链表对象的数组

    public SeparateChainingST() {
        this(997);
    }

    public SeparateChainingST(int M) {
        // 创建M条链表
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        //0x7fffffff ： 01111111111111111111111111111111
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public Iterable<Key> keys() {

        return null;
    }
}
