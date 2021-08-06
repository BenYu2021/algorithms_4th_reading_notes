package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise14 {

    /**
     *  log2(N)
     * @param N
     * @return
     */
    public static int lg(int N) {

        int i = -1, p = 0;
        do {
            p = pow(++i);
            if (p == N)
                return i;
            System.out.println("p = " + p);
        } while (p < N);

        return i - 1;
    }


    /**
     * 计算2^n并返回
     * @param n
     * @return
     */
    private static int pow(int n) {
        int p = 1;
        for (int i = 0; i < n; i++) {
            p *= 2;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(pow(0));
        System.out.println(lg(99));
    }
}
