package ch0500;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/8/16
 * @version: 1.0.0
 * @description: Alphabet类的典型用例
 */
public class Count {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet("ABCDR");
        int R = alphabet.R();
        int[] count = new int[R];

        String s = "ABRACADABRA!";
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alphabet.contains(s.charAt(i))){
                count[alphabet.toIndex(s.charAt(i))]++;
            }
        }

        for (int c = 0; c < R; c++) {
            StdOut.println(alphabet.toChar(c) + " " + count[c]);
        }

    }
}

/*

A 5
B 2
C 1
D 1
R 2

 */