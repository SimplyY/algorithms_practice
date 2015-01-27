package com.structure;

/**
 * Created by yuwei on 2015/1/27.
 */
//tail在队列末尾最后一项的后面一位
public class Queue {
    private int[] a;
    private int size;

    private int head = 0;
    private int tail = 0;

//只有入队时才会full，出队时才会empty
//反之亦然，入队时原来为flase的empty才能变成true
//初始化时为empty
    private boolean isEmpty = true;
    private boolean isFull = false;

    public Queue(int size){
        if (size == 0){
            System.out.println("无法创建size为0的队列");
            return;
        }
        this.size = size;
        a = new int[size];
    }

    public void enqueue(int data){
        if (isFull){
            System.out.println("队列已满，数据无法入队");
            return;
        }
        else if (isEmpty){
            isEmpty = false;
        }

        a[tail] = data;
        if (tail == a.length - 1){
            tail = 0;
        }
        else{
            tail++;
        }

        if (head == tail){
            isFull = true;
        }
    }

    public int dequeue(){
        if (isEmpty){
            System.out.println("队列为空，无法出队");
            return -1;
        }
        else if (isFull){
            isFull = false;
        }

        int data = a[head];
        if (head == a.length - 1){
            head = 0;
        }
        else {
            head++;
        }

        if (head == tail){
            isEmpty = true;
        }

        return data;
    }
}
