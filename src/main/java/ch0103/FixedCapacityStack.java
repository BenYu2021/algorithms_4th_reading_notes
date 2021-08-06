package ch0103;

/**
 * @author: ymm
 * @date: 2021/8/6
 * @version: 1.0.0
 * @description:
 */
public class FixedCapacityStack<Item> {

    private Item[] a; // 栈顶元素
    private int N; // 大小

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    /**
     * 入栈
     *
     * @param item
     */
    public void push(Item item) {
        a[N++] = item;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Item pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack(10);

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
