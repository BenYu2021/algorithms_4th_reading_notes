package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/22
 * @version: 1.0.0
 * @description:
 */
public class Exercise35 {

    public static void dice() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

    }

    public static void main(String[] args) {

    }
}
