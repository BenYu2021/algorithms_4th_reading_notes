package chapter201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: 插入排序
 */
public class Insertion {

    /**
     * 将数组a[]按升序排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) { // 将a[i]插入到a[0]...a[i-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            StdOut.printf("",i);
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

    public static void main(String[] args) {
        // 从标准输入读取字符串，并将它们排序并输出
        String[] a = StdIn.readAllStrings();

        System.out.println("isSorted(a) = " + isSorted(a));
        sort(a);
        System.out.println("isSorted(a) = " + isSorted(a));

        assert isSorted(a);
        show(a);
    }

}
