package ch0500;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/8/16
 * @version: 1.0.0
 * @description:
 */
public class Alphabet {

    /**
     * The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);
    /**
     * The extended ASCII alphabet (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);
    /**
     * The Unicode 16 alphabet (0-65,535).
     */
    public static final Alphabet UNICODE16 = new Alphabet(65536);


    private char[] alphabet; // 字母表字符
    private int[] inverse; // 索引
    private final int R; // 字母表基数

    /**
     * 根据s中的字符创建一张新的字母表
     *
     * @param alpha
     */
    public Alphabet(String alpha) {

        // 检查字母表是否含有重复字符
        boolean[] unicode = new boolean[Character.MAX_VALUE]; // MAX_VALUE = '\uFFFF'
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c]) {
                throw new IllegalArgumentException("非法字母表：重复字符 = '" + c + "'");
            }
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < inverse.length; i++) {
            inverse[i] = -1;
        }

        // 不能使用char，因为R可能大于65536
        for (int c = 0; c < R; c++) {
            inverse[alphabet[c]] = c;
        }

    }

    /**
     * 用0到R-1之间的字符初始化一个新的字母表
     *
     * @param radix
     */
    private Alphabet(int radix) {
        this.R = radix;
        alphabet = new char[R];
        inverse = new int[R];

        for (int i = 0; i < R; i++) {
            alphabet[i] = (char) i;
        }

        for (int i = 0; i < R; i++) {
            inverse[i] = i;
        }
    }

    /**
     * 用0到255的字符串初始化一个字母表
     */
    public Alphabet() {
        this(256);
    }


    /**
     * 获取c的索引，在0到R-1之间
     *
     * @param c
     * @return
     */
    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("字符" + c + "不在字母表值");
        }
        return inverse[c];
    }

    /**
     * c是否在字母表中
     *
     * @param c
     * @return
     */
    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    /**
     * 基数（字母表中的字符数量）
     *
     * @return
     */
    public int R() {
        return R;
    }


    public int radix() {
        return R;
    }

    /**
     * 表示一个索引所需的比特数
     *
     * @return
     */
    public int lgR() {
        int lgR = 0;
        for (int t = R - 1; t >= 1; t /= 2) {
            lgR++;
        }
        return lgR;
    }

    /**
     * 将s转换为R进制的整数
     *
     * @param s
     * @return
     */
    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target = new int[s.length()];
        for (int i = 0; i < source.length; i++) {
            target[i] = toIndex(source[i]);
        }
        return target;
    }

    /**
     * 获取字母表中索引位置的字符
     *
     * @param index
     * @return
     */
    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IllegalArgumentException("索引必须在0到" + R + "之间：" + index);
        }
        return alphabet[index];
    }

    /**
     * 将R进制的整数转换为基于该字母表的字符串
     *
     * @param indices
     * @return
     */
    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++) {
            s.append(toChar(indices[i]));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] encoded1 = edu.princeton.cs.algs4.Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = edu.princeton.cs.algs4.Alphabet.BASE64.toChars(encoded1);
        StdOut.println(decoded1);

        int[] encoded2 = edu.princeton.cs.algs4.Alphabet.DNA.toIndices("AACGAACGGTTTACCCCG");
        String decoded2 = edu.princeton.cs.algs4.Alphabet.DNA.toChars(encoded2);
        StdOut.println(decoded2);

        int[] encoded3 = edu.princeton.cs.algs4.Alphabet.DECIMAL.toIndices("01234567890123456789");
        String decoded3 = edu.princeton.cs.algs4.Alphabet.DECIMAL.toChars(encoded3);
        StdOut.println(decoded3);
    }
}
