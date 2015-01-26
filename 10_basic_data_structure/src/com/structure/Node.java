package com.structure;

/**
 * Created by9 structure on 2015/1/26.
 */
public class Node {
    private int data = 0;
    private Node next = null;

    Node() {
    }

    int getData() {
        return data;
    }
    void setData(int data) {
        this.data = data;
    }

    Node getNext() {
        return next;
    }
    void setNext(Node next) {
        this.next = next;
    }

}
