package chapter201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: 希尔排序
 */
public class Shell {

    /**
     * 将数组a[]按升序排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        // 根据数组长度计算出一个h
        while (h < N / 3) h = 3 * h + 1; // 1，4,13,40,121,364，1093，...
        System.out.println("N = " + N + ",h = " + h);
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) { // 相当于插入排序
//                    System.out.println("j = " + j);
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * 判断v是否小于w
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中索引为i,j的元素
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 在单行中打印数组
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    /**
     * 判断数组元素是否有序（升序）
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }


    /**
     * 把字符数组转换为字节对象数组
     * @param chars
     * @return
     */
    public static Character[] charArrayToCharObject(char[] chars) {
        Character[] a = new Character[chars.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Character.valueOf(chars[i]);
        }
        return a;
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，并将它们排序并输出
//        String[] a = In.readStrings();

        Character[] a = charArrayToCharObject("EASYQUESTION".toCharArray());
        sort(a);
        show(a);
    }

}
