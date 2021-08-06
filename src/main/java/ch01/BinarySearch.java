package ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/4/21
 * @version: 1.0.0
 * @description: 二分查找
 */
public class BinarySearch {

    /**
     * 用二分查找 数组a 是否存在 key
     * @param key
     * @param a 数组必须是有序的
     * @return 元素key的在数组a中的索引，-1代表没找到
     */
    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            }else if (key > a[mid]) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }

        // 没找到
        return -1;
    }

    public static void main(String[] args) {

//        String fileName = args[0];
        String fileName = "\\largeT.txt";

        int[] whiteList = In.readInts(fileName);
//        System.out.println("fileName = " + fileName);
//        System.out.println("whiteList = " + Arrays.toString(whiteList));
        Arrays.sort(whiteList);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            System.out.println("key = " + key);
            if (rank(key, whiteList) < 0){
                StdOut.println(key);
            }
        }
    }
}
