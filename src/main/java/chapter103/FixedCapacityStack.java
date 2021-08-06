package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: 泛型定容栈
 */
public class FixedCapacityStack<Item> {

    private Item[] a; // 栈的元素
    private int N;  // 栈的大小

    /**
     * 创建一个容量为n的空栈
     *
     * @param cap
     */
    public FixedCapacityStack(int cap) {
//        a = new String[n];
        // Java中不允许创建泛型数组
        /**
         * 编译时警告：
         *
         * 注: chapter103\FixedCapacityStack.java使用了未经检查或不安全的操作。
         * 注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
         *
         * 运行时警告：
         *
         * chapter103\FixedCapacityStack.java:29: 警告: [unchecked] 未经检查的转换
         *         a = (Item[]) new Object[n];
         *                      ^
         *   需要: Item[]
         *   找到:    Object[]
         *   其中, Item是类型变量:
         *     Item扩展已在类 FixedCapacityStack中声明的Object
         * 1 个警告
         */
        a = (Item[]) new Object[cap];
    }

    /**
     * 添加一个元素
     *
     * @param item
     */
    public void push(Item item) {
        a[N++] = item;
    }

    /**
     * 删除最近添加的元素
     *
     * @return
     */
    public Item pop() {
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
     * 栈中元素的数量
     *
     * @return
     */
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on stack)");

    }
}
