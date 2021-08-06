package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class Exercise24 {
    /**
     * 计算两个非负整数p和q的最大公约数
     * @param p
     * @param q
     * @return
     */

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    public static int euclid(int p, int q) {
        System.out.println("(p,q)=" + "("+ p +","+q+")");
        if (q == 0) return p;
        int r = p % q;
        return euclid(q, r);
    }

    public static void main(String[] args) {
//        int[] arg = new int[2];
//        arg[0] = Integer.parseInt(args[0]);
//        arg[1] = Integer.parseInt(args[1]);
//        int gcd = gcd(arg[0], arg[1]);
//        int euclid = euclid(9, 99);

        /*
         (p,q)=(1234567,1111111)
         (p,q)=(1111111,123456)
         (p,q)=(123456,7)
         (p,q)=(7,4)
         (p,q)=(4,3)
         (p,q)=(3,1)
         (p,q)=(1,0)
         */
        int euclid = euclid(1111111,1234567);
        System.out.println("euclid = " + euclid);

    }
}
