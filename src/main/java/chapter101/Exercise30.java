package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/22
 * @version: 1.0.0
 * @description:
 */
public class Exercise30 {

    /**
     * 求最大公约数
     *
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

        int gcd = gcd(1, 3);
        System.out.println("gcd = " + gcd);
        int N = 10;
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = (gcd(i, j) == 1 ? true : false);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(",a[" + i + "][" + j + "] = " + a[i][j]);
            }
            System.out.println();
        }
    }
}
