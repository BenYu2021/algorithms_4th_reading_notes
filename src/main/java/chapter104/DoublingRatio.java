package chapter104;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class DoublingRatio {

    public static double timeTrial(int N) {
        // 为处理N个随机的六位整数的ThreeSum.count()计时
        int MAX = 1000000;
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    /*
       250     0.0  1.3
       500     0.0  4.8
      1000     0.4  8.2
      2000     2.4  6.9
      4000    18.6  7.7
      8000    37.3  2.0
     16000   296.8  8.0

     */
    public static void main(String[] args) {
        double prev = timeTrial(125);
        // 打印运行时间的表格
        for (int N = 250; true; N += N) {
            // 打印问题规模为N时程序的用时
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
