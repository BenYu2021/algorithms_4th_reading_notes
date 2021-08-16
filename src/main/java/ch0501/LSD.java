package ch0501;

/**
 * @author: ymm
 * @date: 2021/8/16
 * @version: 1.0.0
 * @description: Least-Significant-Digit-First 低位优先字符串排序
 */
public class LSD {

    /**
     * 通过前W个字符将a[]排序
     *
     * @param a
     * @param W
     */
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;

        String[] aux = new String[N];

        int[] count = new int[R + 1]; // 计算出现频率
        for (int d = W - 1; d >= 0; d++) {

            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) { // 将频率转换为索引
                count[r + 1] = count[r];
            }

            for (int i = 0; i < N; i++) { // 将元素分类
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i = 0; i < N; i++) { // 回写
                a[i] = aux[i];
            }
        }

    }
}
