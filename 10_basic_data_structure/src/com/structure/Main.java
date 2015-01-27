package com.structure;

import java.util.Random;

public class Main {

    static LinkList testList;

    public static void initLinkList(){
        testList = new LinkList();
        Random random = new Random();
        int headData = random.nextInt(100);
        testList.setHead(headData);
        Node currentNode = testList.search(headData);
        for (int i = 0; i < 10; i++) {
            int currentData = random.nextInt(100);
            testList.insert(currentNode, currentData);
            currentNode = testList.search(currentData);
        }

    }

    public static void queueTest(){
        Queue testQueue = new Queue(10);
        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            int currentData = random.nextInt(100);
            testQueue.enqueue(currentData);
            System.out.print(currentData + " ");
        }
        System.out.println();
        for (int i = 0; i < 11; i++) {
            int data = testQueue.dequeue();
            System.out.print(data + " ");
        }
    }

    public static void main(String[] args) {
        initLinkList();
        testList.output();
        testList.outputSorted();
        queueTest();
    }
}

