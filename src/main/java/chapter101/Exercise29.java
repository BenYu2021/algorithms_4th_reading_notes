package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description: 删除数组重复元素
 */
public class Exercise29 {

    /**
     * 返回数组a中小于键key元素数量
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (key < a[i]) count++;
        }
        return count;
    }

    /**
     * 返回数组a中等于键key元素数量
     * @param key
     * @param a
     * @return
     */
    public static int count(int key, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }


}
