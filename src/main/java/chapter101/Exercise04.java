package chapter101;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise04 {

    // 1.1.7

    public static void a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    public static void main(String[] args) {
        System.out.println(9.0 - 9.0/9.0);
        a();
    }
}
