package ch0301;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: �㷨3.1 ˳����ң�������������
 */
public class SequentialSearchST<Key, Value> {

    private Node first;
    private int N; // ��С

    private class Node { // ����Ľڵ�Ķ���
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        // ���Ҹ����ļ��������������ֵ
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value; // ����
            }
        }
        return null; // δ����
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        // ���Ҹ����ļ����ҵ��������ֵ�������ڱ����½��ڵ�
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {  // ���У�����
                x.value = val;
                return;
            }
        }
        first = new Node(key, val, first); // ����ͷ����ͷ�巨
        N++;
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    public void delete1(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        Node prev = first;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                prev.next = x.next;
                N--;
                return;
            }
            prev = x.next;
        }
    }

    /**
     * ɾ���Խڵ�x��ʦ�ļ�key
     *
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next; // ����ɾ���ڵ�ĺ�һ���ڵ�
        }
        x.next = delete(x.next, key); // �ݹ����
        return x;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
/*

���룺
S E A R C H E X A M P L E

�������ΪTreeMap������ģ���
L 11
P 10
M 9
X 7
H 5
C 4
R 3
A 8
E 12
S 0

 */