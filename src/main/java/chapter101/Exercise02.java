package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise02 {

    // 1.1.3
    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 0; i < args.length; i++) {
            System.out.println("args = " + args[i]);
            arr[i] = Integer.parseInt(args[i]);
        }
        if (arr[0] == arr[1] && arr[0] == arr[2])
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}
