package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise16 {
    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static String exR2(int n) {
        String s = exR1(n-3) + n + exR1(n-2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }
    public static void main(String[] args) {

        System.out.println(exR1(6)); //  311361142246
                                        //  311361142246
    }
}
