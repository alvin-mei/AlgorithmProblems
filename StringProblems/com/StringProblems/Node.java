package com.stringProblems;

/**
 * Created by alvin on 16/9/5.
 */
public class Node {
    int data;
    Node next;
    Node pre;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}
