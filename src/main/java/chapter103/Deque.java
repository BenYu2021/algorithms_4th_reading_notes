package chapter103;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description: 1.3.33 双向队列
 * 同时支持在两端添加或删除元素
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> left; // 左端节点
    private Node<Item> right; // 右端节点
    private int N;

    /**
     * 结点类
     *
     * @param <Item>
     */
    private class Node<Item> {
        Item item;
        Node<Item> prev;
        Node<Item> next;

        public Node(Node<Item> prev, Item item, Node<Item> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public Deque() {
        left = null;
        right = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 从左端插入一个元素
     *
     * @param item
     */
    public void pushLeft(Item item) {
        Node<Item> newNode = new Node<>(null, item, null);
        if (isEmpty()) left = right = newNode;
        else {
            newNode.next = left;
            left.prev = newNode;
            left = newNode;
        }
        N++;
    }

    /**
     * 从右端插入一个元素
     *
     * @param item
     */
    public void pushRight(Item item) {
        Node<Item> newNode = new Node<>(null, item, null);
        if (isEmpty()) left = right = newNode;
        else {
            newNode.prev = right;
            right.next = newNode;
            right = newNode;
        }
        N++;
    }

    /**
     * 从左端删除一个元素
     *
     * @return
     */
    public Item popLeft() {
        if (isEmpty()) return null;
        Item item = null;

        if (left != null) {
            item = left.item;
        }
        if (N == 1) {
            left = right = null;
        } else {
            Node<Item> t = left;
            left = left.next;
            left.prev = null;
            t.next = null;
        }

        N--;
        return item;
    }

    /**
     * 从右端删除一个元素
     *
     * @return
     */
    public Item popRight() {
        if (isEmpty()) return null;

        Item item = null;

        if (right != null) {
            item = right.item;
        }
        if (N == 1) {
            left = right = null;
        } else {
            Node<Item> t = right;
            right = right.prev;
            right.next = null;
            t.prev = null;
        }

        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node<Item> current = left;

        @Override
        public boolean hasNext() {
            return current != right;
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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Deque{");
        if (N > 0) {
            Node<Item> current = left;
            for (int i = 0; i < N; i++) {
                sb.append(current.item);
                if (current != right) sb.append(',');
                current = current.next;
            }
        }
        sb.append('}');
        sb.append(", size = " + N);

        return sb.toString();
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.pushLeft("one");
        deque.pushLeft("one");
        deque.pushRight("two");
        deque.pushRight("two");
        System.out.println("deque = " + deque);
        String popLeft = deque.popLeft();
        System.out.println("popLeft = " + popLeft);
        String popRight = deque.popRight();
        System.out.println("popRight = " + popRight);
        System.out.println("deque = " + deque);
    }
}
