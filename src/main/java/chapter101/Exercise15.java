package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise15 {


    /**
     * @param a
     * @param M
     * @return
     */
    public static int[] histogram(int[] a, int M) {
        int[] arr = new int[M];
        for (int i = 0; i < a.length; i++) {
            ++arr[a[i]];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {0, 5, 7, 2, 4, 6, 4, 5, 6, 7, 5, 2, 4, 6, 8, 4, 0, 4};
        int[] histogram = histogram(a, 10);
        for (int i = 0; i < histogram.length; i++) {
            System.out.println("[" + i + "] = " + histogram[i]);
        }
    }
}
