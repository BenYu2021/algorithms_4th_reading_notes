package chapter101;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Fibonacci {

    /**
     * 斐波那契数列递归写法
     * @param N
     * @return
     */
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }


    /**
     * 斐波那契数列递推写法
     * @param N
     * @return
     */
    public static long[] F2(int N) {
        long[] arr = new long[N];
        if (N == 0) {
            arr[0] = 0;
            return arr;
        }
        if (N == 1) {
            arr[1] = 1;
            return arr;
        }
        arr[0] = 0; arr[1] = 1;
        for (int i = 2; i < N; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr;
    }


    public static void main(String[] args) {
//        for (int N = 0; N < 100; N++) {
//            StdOut.println(N + " " + F(N));
//        }
        long[] f2 = F2(100);
        for (int i = 0; i < f2.length; i++) {
            StdOut.println(i + 1 + " " + f2[i]);
        }
    }
}
