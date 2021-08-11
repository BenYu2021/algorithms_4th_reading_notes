package ch0303;

import ch01.Queue;

import java.net.PortUnreachableException;

/**
 * @author: ymm
 * @date: 2021/8/11
 * @version: 1.0.0
 * @description:
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root; // 二叉查找树

    private class Node {
        private Key key; // 键
        private Value value; // 值
        private Node left, right; // 指向子树的链接
        private int N; // 以该结点为根的子树的结点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.value = val;
            this.N = N;
        }
    }


    private int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     * @param key
     * @return
     */
    public Value get(Key key) {

        return get(root, key);
    }

    /**
     * 在以x为根结点的子树中查找并返回key所对应的值；如果找不到，则返回null
     *
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        if (x == null) return null;
        if (key == null) throw new IllegalArgumentException("get()参数 key 为空");
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    /**
     * 查找key存在于以x为根结点的子树中则更新它的值；
     * 否则将以key和val为键值对的新结点插入到该子树中
     *
     * @param x
     * @param key
     * @param val
     * @return
     */
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.left = put(x.right, key, val);
        else x.value = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    /**
     * 小于等于key的最大节点
     *
     * @param x
     * @param key
     * @return
     */
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        else if (cmp > 0) return floor(x.right, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {

        return null;
    }

    private Node ceiling(Node x, Key key) {

        return null;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    /**
     * 返回排序为k的节点
     *
     * @param x
     * @param k
     * @return
     */
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k); // 在x的左子树中
        else if (t < k) return select(x.right, k - t - 1); // 在x的右子树中
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    /**
     * 返回以x为根结点的子树中小于x.key的键的数量
     *
     * @param key
     * @param x
     * @return
     */
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + size(x.right);
        else return size(x.left);
    }

    public void deleteMax() {

    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(Key lo, Key hi){

        return null;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){

    }

}
