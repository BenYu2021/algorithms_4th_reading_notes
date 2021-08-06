package chapter104;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class ThreeSum {


    public static int count(int[] a) {
        // 统计和为0的元组的数量
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
//                        System.out.println(a[k]);
//                        System.out.println("(i,j) = " + a[i] + "," + a[j]);
                    }
                }
            }
        }

        return cnt;
    }

    /**
     * 1.4.2 处理较大的int相加可能溢出的情况
     *
     * @param a
     * @return
     */
    public static int count1(int[] a) {
        // 统计和为0的元组的数量
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    // 处理int型相加溢出问题
                    // 1.符号相同的三个数必然不为0
                    if (a[i] > 0 && a[j] > 0 && a[k] > 0) continue;
                    if (a[i] < 0 && a[j] < 0 && a[k] < 0) continue;


                    if (a[i] + a[j] + a[k] == 0) {


                        cnt++;
//                        System.out.println(a[k]);
//                        System.out.println("(i,j) = " + a[i] + "," + a[j]);
                    }
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
