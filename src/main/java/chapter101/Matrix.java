package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/22
 * @version: 1.0.0
 * @description: 矩阵库
 */
public class Matrix {

    /**
     * 向量点乘
     *
     * @param x
     * @param y
     * @return
     */
    public static double dot(double[] x, double[] y) throws Exception {
        if (x.length != y.length) throw new Exception("相乘的向量长度不相等");

        double r = 0.0; // 计算结果
        for (int i = 0; i < x.length; i++) {
            r += x[i] * y[i];
        }

        return r;
    }

    /**
     * 矩阵和矩阵之积
     * 矩阵相乘的条件：左边矩阵的列等于右边矩阵的行数
     * a[M][N] * b[N][P]
     *
     * @param a
     * @param b
     * @return
     */
    public static double[][] mult(double[][] a, double[][] b) throws Exception {
        // 获取二维数组行数和列数
        int aRow = a.length, bRow = b.length, aColumn = a[0].length, bColumn = b[0].length;
        if (aColumn != bRow) throw new Exception("不满足矩阵相乘的条件：左矩阵的列数等于右矩阵的行数，矩阵无法相乘");

        double[][] ab = new double[aRow][bColumn]; // 矩阵相乘的结果
        printMatrix(ab);
        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < bColumn; j++) {

                for (int k = 0; k < aColumn; k++) {
                    ab[i][j] += (a[i][k] * b[k][j]);
                }

            }
        }

        return ab;
    }

    /**
     * 转置矩阵
     *
     * @param a
     * @return
     */
    public static double[][] transpose(double[][] a) {
        int raw = a.length, column = a[0].length;
        double[][] t = new double[a[0].length][a.length];
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < column; j++) {
                t[j][i] = a[i][j];
            }
        }
        return t;
    }

    /**
     * 矩阵和向量之积
     *
     * @param a
     * @param b
     * @return
     */
    public static double[] mult(double[][] a, double[] b) throws Exception {
        int aRaw = a.length, aColumn = a[0].length, bLen = b.length;

        if (aColumn != bLen) throw new Exception("矩阵列数与向量长度不同，无法运算");

        double[] t = new double[aRaw];
        for (int i = 0; i < aRaw; i++) {
            for (int j = 0; j < aColumn; j++) {
                t[i] += (a[i][j] * b[j]);
            }
        }
        return t;
    }

    /**
     * 向量和矩阵之积
     *
     * @param a
     * @param b
     * @return
     */
    public static double[] mult(double[] a, double[][] b) throws Exception {
        int bRaw = b.length, bColumn = b[0].length, aLen = a.length;
        if (aLen != bRaw) throw new Exception("向量长度和矩阵行数不相等，无法运算");

        double[] t = new double[bColumn];

        for (int i = 0; i < bColumn; i++) {
            for (int j = 0; j < aLen; j++) {
                t[i] += (a[j] * b[j][i]);
            }
        }
        return t;
    }


    public static void printMatrix(double a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static <T> void printArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        double[][] a = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        double[][] b = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[] c = {
                1, 2
        };

//        printMatrix(a);
//        printMatrix(b);
//        try {
//            double[][] mult = mult(a, b);
//            printMatrix(mult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        double[][] transpose = transpose(a);
        printMatrix(transpose);
        double[] mult1 = mult(a, c);
        printArray(mult1);
        double[] mult2 = mult(c, b);
        printArray(mult2);

    }
}
