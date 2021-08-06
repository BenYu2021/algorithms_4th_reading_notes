package ch0103;

/**
 * @author: ymm
 * @date: 2021/5/17
 * @version: 1.0.0
 * @description: 固定容量的字符串栈
 */
public class FixedCapacityStackOfStrings {
    private String[] a; // 栈顶元素
    private int N; // 大小

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    /**
     * 入栈
     *
     * @param item
     */
    public void push(String item) {
        a[N++] = item;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);

        stack.push("one");
        stack.push("two");
//        stack.push("three");
//        stack.push("three");
        String s = "";
        int i = stack.size();

        while (i > 0) {
            System.out.println("s = " + stack.pop());
            i--;
        }

    }
}
