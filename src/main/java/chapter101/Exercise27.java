package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 * 二项分布
 */
public class Exercise27 {
    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static void main(String[] args) {
        double binomial = binomial(100, 50, 0.25);
        System.out.println("binomial = " + binomial);
    }
}
