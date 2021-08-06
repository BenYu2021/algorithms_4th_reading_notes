package chapter204;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: p202 算法2.6基于堆的优先队列
 */
public class HeapMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; //基于堆的完全二叉树
    private int N = 0; //存储于pq[1..N]中，pq[0]没有使用

    /**
     * 创建一个初始容量为max的优先队列
     *
     * @param maxN
     */
    public HeapMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1]; // pq[0]不用
    }

    /**
     * 向队列中插入一个元素
     *
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * 由下至上的堆有序化
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) { // k / 2是k节点的父节点
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上至下的堆有序化（下沉）
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 返回最大元素
     *
     * @return
     */
    public Key max() {
        return pq[1]; // 根节点是最大节点
    }

    /**
     * 删除并返回最大元素
     *
     * @return
     */
    public Key delMax() {
        Key max = pq[1]; // 从根节点得到最大元素
        exch(1, N--); // 将其和最后一个节点交换
        pq[N + 1] = null; // 防止对象游离
        sink(1);
        return max;
    }

    /**
     * 返回队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回优先队列中的元素个数
     *
     * @return
     */
    public int size() {
        return N;
    }

//    public static void sort(Comparable[] a) {
//        int N = a.length;
//        for (int k = N / 2; k >= 1; k++) ;
////            sink()
//    }

    public static void main(String[] args) {
        HeapMaxPQ<String> stringHeapMaxPQ = new HeapMaxPQ<String>(99);
        stringHeapMaxPQ.insert("z");
        stringHeapMaxPQ.insert("b");
        stringHeapMaxPQ.insert("c");
        stringHeapMaxPQ.insert("d");
        System.out.println(stringHeapMaxPQ.max());
    }

}
