package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise18 {


    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static int mystery1(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static void main(String[] args) {
        int m1 = mystery(2, 25); // 50
        int m2 = mystery(3, 11 ); //33
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);
    }
}
