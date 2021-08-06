package chapter101;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description: 删除数组重复元素
 */
public class Exercise28 {

    /**
     * 打印数组
     *
     * @param a
     */
    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }

    /**
     * 拷贝数组
     *
     * @param dest
     * @param src
     * @param len
     */
    public static boolean copyArray(int[] dest, int[] src, int len) {
        if (len > dest.length || len > src.length) {
            return false;
        }

//        System.out.println(dest.length);
        for (int i = 0; i < len; i++) {
            dest[i] = src[i];
        }
        return true;
    }

    /**
     * 数组去重
     *
     * @param a
     */
    public static int[] duprem(int[] a) {

        int curLen = a.length; // 记录去重后数组长度

        for (int i = 0; i < curLen; i++) {
            for (int j = i + 1; j < curLen; ) {
                if (a[i] == a[j]) { // 找到重复元素
//                    System.out.println(j + " = " + a[j]);

                    // 去重，后面元素往前移一维覆盖前面一位
                    for (int k = j; k < curLen - 1; k++) {
                        a[k] = a[k + 1];
                    }

                    curLen--;
//                    System.out.println(" =====" + a[i] + "=======" );
//                    printArray(a);
//                    System.out.println(" ============" );
                }else
                    j++; // 只有没有去重时，j才向后移动，否则继续判断当前元素
            }
        }
//        printArray(a);
        int[] curArr = new int[curLen];
        copyArray(curArr, a, curLen);
        return curArr;
    }


    public static void main(String[] args) {

        // 替换为
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts(); // 读取第一个文件中的数字并保存到数组whitelist
        Arrays.sort(whitelist);
        int[] duprem = duprem(whitelist);
        printArray(duprem);
    }

    public static void main1(String[] args) {

//        int[] a = {23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68};
        int[] a = {77, 77, 77,4};
//        Arrays.sort(a);
        int[] duprem = duprem(a);
//        System.out.println("----------");
//        printArray(a);
//        System.out.println("----------");
        printArray(duprem);
    }

}
