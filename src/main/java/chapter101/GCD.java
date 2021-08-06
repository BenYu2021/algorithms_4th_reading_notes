package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description: 欧几里得算法求最大公约数
 */
public class GCD {
    /**
     * 计算两个非负整数p和q的最大公约数
     * @param p
     * @param q
     * @return
     */

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int gcd = gcd(99, 9);
        System.out.println("gcd = " + gcd);

    }
}
