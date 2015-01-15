/**
 * Created by yuwei on 2015/1/5.
 */
package com.yuwei;


public class Array {
    private int heapSize;
    private int heapLength;
    private int[] array;
    //times means the algorithms's caculating times
    private int times;
    //n means quotiety of algorithms's n
    private int c;

    Array(int[] array) {

        heapLength = array.length;
        heapSize = array.length;

        this.array = array;
        times = 0;
        c = 0;
    }

    public void show(){
        System.out.println("数组为:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    public void heapSort(){
        buildMaxHeap();
        times ++;
        for (int i = heapSize - 1; i >= 1 ; i--) {
            swap(0, i);
            heapSize --;
            maxHeapify(1);
            times += 4;
        }
    }
    private void swap(int a, int b){
        int template = array[a];
        array[a] = array[b];
        array[b] = template;
        times += 3;
    }
    private void buildMaxHeap(){
        int theMinRoot = heapSize/2 - 1;
        times ++;
        for (int i = theMinRoot; i >= 0; i--) {
            maxHeapify(i);
            times += 2;
        }
    }
    private void maxHeapify(int root){
        int left = getLeft(root);
        int right = getRight(root);
        int largest = 0;

        times += 3;

        if (left < heapSize && array[left] > array[root]){
            largest = left;
            times += 3;
        }
        else{
            largest = root;
            times += 3;
        }
        if (right < heapSize && array[right] > array[largest]){
            largest = right;
            times += 3;
        }

        if (root != largest){
            swap(root, largest);
            maxHeapify(largest);
            times += 3;
        }

    }


    private int getLeft(int root){
        times++;
        return (root * 2 + 1);
    }

    private int getRight(int root){
        times++;
        return (root * 2 + 2);
    }



    public void showHeapSort() {
        System.out.print("\n排序完成后数组：");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        double lgn = Math.log(array.length) / Math.log(2);
        c = (int) (times / (array.length * lgn));


        System.out.println("\n运算次数：" + times + "  算法复杂度为nlgn，系数c不小于:" + c);
    }


}