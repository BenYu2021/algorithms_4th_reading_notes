package ch0201;

import ch0202.Merge;
import ch0203.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: 比较两种排序算法
 */
public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        return timer.elapsedTime();
    }

    /**
     * 使用算法alg将T个长度为N的数组排序
     *
     * @param alg
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];

        for (int t = 0; t < T; t++) { // 进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
        // 原代码是用命令行输入算法名称
//        String alg1 = args[0];
//        String alg2 = args[1];
//        int N = Integer.parseInt(args[2]);
//        int T = Integer.parseInt(args[3]);


        int N = 1000;
        int T = 1000;

        double timeInsertion = timeRandomInput("Insertion", N, T); // 插入排序的总时间
        double timeSelection = timeRandomInput("Selection", N, T); // 选择排序的总时间
        double timeShell = timeRandomInput("Shell", N, T); // 希尔排序的总时间
        double timeMerge = timeRandomInput("Merge", N, T); // 希尔排序的总时间
        double timeQuick = timeRandomInput("Quick", N, T); // 希尔排序的总时间

        System.out.printf("%s 排序所需时间：%.2fs\n", "Insertion", timeInsertion);
        System.out.printf("%s 排序所需时间：%.2fs\n", "Selection", timeSelection);
        System.out.printf("%s 排序所需时间：%.2fs\n", "Shell", timeShell);
        System.out.printf("%s 排序所需时间：%.2fs\n", "Merge", timeMerge);
        System.out.printf("%s 排序所需时间：%.2fs\n", "Quick", timeQuick);

        StdOut.printf("For %d random Doubles\n  %s is", N, "Insertion");
        StdOut.printf(" %.1f times faster than %s\n", timeSelection / timeInsertion, "Selection");
        System.out.println("**************");
        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", timeShell / timeInsertion, "Selection");

        /* 输出：
Insertion 排序所需时间：1.74
Selection 排序所需时间：1.11
Shell 排序所需时间：0.14
For 1000 random Doubles
  Insertion is 0.6 times faster than Selection
**************
For 1000 random Doubles
  Shell is 0.1 times faster than Selection
         */
    }
}
