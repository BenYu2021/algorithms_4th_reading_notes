package chapter101;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description: 二分查找的递归实现
 */
public class Exercise22 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        System.out.print(depth + ":");
        for (int i = 0; i < depth; i++) {
            System.out.print("\t\t\t");
        }
        System.out.println("lo=" + lo + ",hi=" + hi);
        // 如果key存在于a[]中，那么索引不会小于lo且不会大于hi
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, ++depth);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, ++depth);
        else return mid;
    }

    public static void main(String[] args) {
        int[] a = {5,8,24,22,74,5,7,22,14,64,22,4,66,5};
        Arrays.sort(a);
        int index = rank(74, a);
        System.out.println("index = " + index);
        System.out.println("a[" + index +"] = " + a[index]);

    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
