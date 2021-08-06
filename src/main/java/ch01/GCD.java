package ch01;

/**
 * @author: ymm
 * @date: 2021/4/20
 * @version: 1.0.0
 * @description: p1 求最大公约数
 */
public class GCD {

    /**
     * 欧几里得算法
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
//        System.out.println("p = " + p + ",q = " + q + ",r = " + r);
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int gcd = gcd(6, 33);
        System.out.println(gcd);
    }
}
