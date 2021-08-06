package chapter104;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class DoublingTest {


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

    public static void main(String[] args) {
        StdDraw.setXscale(0.0, 5000);
        StdDraw.setYscale(0.0, 50);


        // 打印运行时间的表格
        for (int N = 250; true; N += N) {
            // 打印问题规模为N时程序的用时
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            StdDraw.point(N, time);
//            StdDraw.textRight(N, 0, N + "");
//            StdDraw.textLeft(N, 0, N + "");
//            StdDraw.text(0, time, time + "");
        }

    }
}
