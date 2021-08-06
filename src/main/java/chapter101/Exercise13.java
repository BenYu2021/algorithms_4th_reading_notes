package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise13 {

    // 1.1.13

    /**
     * 打印M行N列的二维数组matrix的转置
     * @param matrix
     * @param m
     * @param n
     */
    public static void trans(int[][] matrix, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" " + matrix[j][i]);
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int[][] array2 = {
                {1,2,3},
                {4,5,6}
        };

        trans(array2, 2, 3);

    }
}
