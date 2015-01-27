package com.structure;

/**
 * Created by yuwei on 2015/1/27.
 */
public class Stack {
    private int size;
    private int[] a;
    private int top = 0;

    private boolean isEmpty = true;
    private boolean isFull = false;

    public Stack(int size){
        if (size == 0){
            System.out.println("无法创建size为0的栈");
            return;
        }

        this.size = size;
        a = new int[size];
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void push(int data){
        if (isFull){
            System.out.println("stack over flow");
            return;
        }
        top++;
        a[top - 1] = data;
        if (top == size){
            isFull = true;
        }
        if (isEmpty){
            isEmpty = false;
        }
    }

    public int pop(){
        if (isEmpty){
            System.out.println("stack under flow");
            return -1;
        }
        top--;

        if (top == 0){
            isEmpty = true;
        }
        if (isFull){
            isFull = false;
        }

        return a[top];
    }
}