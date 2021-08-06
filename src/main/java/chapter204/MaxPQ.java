package chapter204;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: 优先队列，支持两种操作：删除最大元素和和插入元素
 */
public class MaxPQ<Key extends Comparable<Key>> {

    /**
     * 创建一个优先队列
     */
    public MaxPQ() {
    }

    /**
     * 创建一个初始容量为max的优先队列
     *
     * @param max
     */
    public MaxPQ(int max) {
    }

    /**
     * 用a[]中的元素创建一个优先队列
     *
     * @param a
     */
    public MaxPQ(Key[] a) {
    }

    /**
     * 向队列中插入一个元素
     *
     * @param v
     */
    public void insert(Key v) {

    }

    /**
     * 返回最大元素
     *
     * @return
     */
    public Key max() {
        return null;
    }

    /**
     * 删除并返回最大元素
     *
     * @return
     */
    public Key delMax() {
        return null;
    }

    /**
     * 返回队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 返回优先队列中的元素个数
     *
     * @return
     */
    public int size() {
        return 0;
    }


}
