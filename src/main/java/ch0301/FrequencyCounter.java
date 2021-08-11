package ch0301;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: 符号表的用例
 * <p>
 * 从标准输入中得到一列字符串并记录每个（长度至少达到指定的阈值）字符串出现次数，
 * 然后遍历所有键并找出出现频率最高的键。
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]); // 最小键长
        ST<String, Integer> st = new ST<String, Integer>();

        // 1. 统计字符串出现的次数
        while (!StdIn.isEmpty()) {
            // 构造符号表统计频率
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // 忽略较短的单词
            if (!st.contains(word)) st.put  (word, 1);
            else st.put(word, st.get(word) + 1);
        }

        // 2. 找出出现频率最高的单词
        String max = " ";
//        System.out.println("st = " + st==null);
//        System.out.println("st = " + st.keys());
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        StdOut.println(max + " " + st.get(max));
    }
}
