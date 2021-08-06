package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1]; // 栈元素
    private int N = 0; // 元素数量

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 栈中元素的数量
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * @param max
     */
    private void resize(int max) {
        // 将栈移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 添加一个元素
     *
     * @param item
     */
    public void push(Item item) {
        // 将元素添加的到栈顶
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    /**
     * 删除最近添加的元素
     *
     * @return
     */
    public Item pop() {
        // 从栈顶删除元素
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // 支持后劲先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on stack)");

    }
}
