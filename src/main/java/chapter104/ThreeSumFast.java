package chapter104;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class ThreeSumFast {


    public static int count(int[] a) {
        // 统计和为0的三元组的数量
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.rank(-(a[i] + a[j]), a) > j) {
                    cnt++;
//                    System.out.println(-(a[i] + a[j]));
//                    System.out.println("(i,j) = " + a[i] + "," + a[j]);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
