package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: 定容字符串栈
 */
public class FixedCapacityStackOfStrings {

    private String[] a; // 栈的元素
    private int N;  // 栈的大小

    /**
     * 创建一个容量为n的空栈
     *
     * @param cap
     */
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    /**
     * 添加一个元素
     *
     * @param item
     */
    public void push(String item) {
        a[N++] = item;
    }

    /**
     * 删除最近添加的元素
     *
     * @return
     */
    public String pop() {
        return a[--N];
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 判断栈是否已满
     *
     * @return
     */
    public boolean isFull() {
        return N == a.length;
    }

    /**
     * 栈中元素的数量
     *
     * @return
     */
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on stack)");

    }
}
