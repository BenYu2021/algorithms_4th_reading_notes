package chapter301;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: 顺序查找（基于无序链表）
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node { // 链表的节点的定义
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // 查找给定的键，返回相关联的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value; // 命中
            }
        }
        return null; // 未命中
    }

    public void put(Key key, Value val) {
        // 查找给定的键，找到则更新其值，否则在表中新建节点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {  // 命中，更新
                x.value = val;
                return;
            }
        }
        first = new Node(key, val, first); // 插入头部
    }

    public static void main(String[] args) {
        
    }

}
