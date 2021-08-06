package chapter103;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description:
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {

    private Item[] a;
    private int left;
    private int right;
    private int N;

    /**
     * 创建一个空的容量为cap的双向队列
     *
     * @param cap
     */
    public ResizingArrayDeque(int cap) {
        a = (Item[]) new Object[cap];
        left = right = cap / 2; // 把数组中点作为起始位置
        N = 0;
    }

    /**
     * 从左端插入一个元素
     *
     * @param item
     */
    public void pushLeft(Item item) {
        if (left == 0) resize(a.length * 2);
        a[left--] = item;
        N++;
    }

    /**
     * 从右端插入一个元素
     *
     * @param item
     */
    public void pushRight(Item item) {

    }

    /**
     * 从左端删除一个元素
     *
     * @return
     */
    public Item popLeft() {
        return null;
    }

    /**
     * 从右端删除一个元素
     *
     * @return
     */
    public Item popRight() {

        return null;
    }

    private void resize(int max) {
        Item[] newItems = (Item[]) new Object[max];
        int start = max - a.length / 2;
        for (int i = 0; i < a.length; i++) {
            newItems[start++] = a[i];
        }
        left = start;
        right = start + a.length - 1;
        a = newItems;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ArrayIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

}
