package chapter103;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description: 1.3.34
 * 随机背包
 */
public class RandomBag<Item> implements Iterable<Item> {


    private Item[] a;
    private int N = 0;

    public RandomBag() {
    }

    public RandomBag(int cap) {
        a = (Item[]) new Object[cap];

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {

        if (N < a.length) {
            a[N++] = item;
        } else {
            throw new RuntimeException("背包已满");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class RandomIterator<Item> implements Iterator<Item> {

        public RandomIterator() {
            for (int i = 0; i < N; i++) {
                int random = StdRandom.uniform(N);
//                    Item item = a[random];
//                Item item = a[random];
//                a[random] = a[i];
//                a[i] = item;
            }
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
