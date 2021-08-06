package chapter103;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: 背包
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first; // 链表的首节点
    private int N = 0;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        // 和Stack的push()方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
