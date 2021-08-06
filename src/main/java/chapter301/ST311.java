package chapter301;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: 一种简单的符号表API
 */
public class ST311<Key, Value> {

    /**
     * 创建一张符号表
     */
    public ST311() {
    }

    /**
     * 将键值存入表中（若值为空将键key从表中删除）
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {

    }

    /**
     * 获取key对应的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return null;
    }

    /**
     * 从表中删去键key（及其对应的值）
     *
     * @param key
     */
    public void delete(Key key) {

    }

    /**
     * 键key在表中是否有对应的值
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return false;
    }

    /**
     * 表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 表中键值对的数量
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * 表中所有键的集合
     *
     * @return
     */
    public Iterable<Key> keys() {
        return null;
    }


}
