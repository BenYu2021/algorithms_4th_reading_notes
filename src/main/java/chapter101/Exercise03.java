package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise03 {

    /**
     * 1.1.5
     * x,y严格位于0和1之间
     */
    public static boolean range01(double x, double y) {
        if ((x - 0.0) > 0.0 && (1.0 - x) > 0.0 && (y - 0.0) > 0.0 && (1.0 - y) > 0.0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        double x = 0.00000001,y=0.9999999999;
        boolean b = range01(x, y);
        System.out.println("b = " + b);


    }
}
