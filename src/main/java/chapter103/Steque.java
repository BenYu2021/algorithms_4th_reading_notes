package chapter103;

import jdk.dynalink.NamedOperation;

import javax.naming.ldap.PagedResultsControl;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description: exercise 1.3.32
 */
public class Steque<Item> {

    private Node<Item> top;  // 栈顶
    private Node<Item> bottom; // 栈底
    private int N;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        if (isEmpty()) bottom = top = newNode;
        else {
//            Node<Item> t = newNode;
            newNode.next = top;
            top = newNode;
        }
        N++;
    }

    public Item pop() {
        if (isEmpty()) return null;
        Item item = top.item;
        Node<Item> t = top;
        top = top.next;
        t.next = null;
        if (N == 1) bottom = null;
        N--;
        return item;
    }

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        if (isEmpty()) {
            top = bottom = newNode;
        }else {
            bottom.next = newNode;
            bottom = bottom.next; 
        }

        N++;
    }

    @Override
    public String toString() {
        return "Steque{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();

        steque.push("one");
        steque.push("two");
        steque.push("three");

        System.out.println("steque = " + steque);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(steque.pop());
//        }
        steque.enqueue("zero");
        steque.enqueue("-1");
        for (int i = 0; i < 5; i++) {
            System.out.println(steque.pop());
        }
    }

}
