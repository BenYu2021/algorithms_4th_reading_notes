package ch0301;

import ch01.Queue;

/**
 * @author: ymm
 * @date: 2021/7/9
 * @version: 1.0.0
 * @description: �㷨3.2 ���ֲ��ң������������飩
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

        // ���Ҽ����ҵ������ֵ�����򴴽���Ԫ��
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j++) {
            // [i..N]�Ƶ�[i+1..N+1]
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
            // ���뵽[i]
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
     * ���ڵ���key����Сֵ
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * С�ڵ���key������
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
        if (!contains(key)) return null; // Ҫɾ���ļ����ڱ���

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
     * С��key�ļ�������
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(key, 0, size());
    }

    /**
     * �ݹ���ֲ���
     *
     * @param key
     * @param lo
     * @param hi
     * @return ���ر���С�����ļ�������
     * ������д��ڼ�key�����ظü���λ�ã�Ҳ���Ǳ���С�����ļ���������
     * ��������ڣ����Ƿ��ر���С�����ļ���������lo��hi+1
     */
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1); // ����Ҳ��������ص���lo��0
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi); // ����Ҳ��������ص���hi+1
        } else {
            return mid;  // ����ҵ������ص��ǵ�ǰԪ�ص�����
        }
    }

    /**
     * �������ֲ���
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
