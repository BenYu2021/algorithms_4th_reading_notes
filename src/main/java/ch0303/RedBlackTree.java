package ch0303;

/**
 * @author: ymm
 * @date: 2021/8/13
 * @version: 1.0.0
 * @description: 算法3.4 红黑树
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    public static final boolean BLACK = true;
    public static final boolean RED = false;

    protected Node root;

    private class Node {
        Key key; // 键
        Value value; // 值
        Node left, right; // 左右子树
        int N; // 这棵子树中的结点总数
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * 旋转h的右链接
     *
     * @param h
     * @return
     */
    private Node rotationLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }


    /**
     * 旋转h的左链接
     *
     * @param h
     * @return
     */
    private Node rotationRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 颜色转换
     *
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = RED;
    }


    /**
     * 查找key，找到则更新其值，否则新键一个结点
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) { // 标准的插入操作，和父结点用红链接相连
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.value = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotationLeft(h); // 右结点是红连接
        if (isRed(h.left) && isRed(h.left.left)) h = rotationRight(h); // 左边连续的两个红链接
        if (isRed(h.left) && isRed(h.right)) flipColors(h); // 左右都是红链接

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }


}
