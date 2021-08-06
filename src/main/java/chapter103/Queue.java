package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: 队列
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first; // 指向最早添加的结点的链接
    private Node last;  // 指向最近添加的节点的链接
    private int N;      // 队列中的元素数量

    private class Node {
        // 定义节点的嵌套类
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        // 向标尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last; //若原先是空队列，队头队位执行同一个元素
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        // 从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on queue)");
    }

}
