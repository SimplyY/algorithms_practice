/**
 * Created by yuwei on 2015/1/5.
 */
package com.company;


public class Array {
    private int begin;
    private int end;
    private int[] array;
    //times means the algorithms's caculating times
    private int times;
    //c means quotiety of algorithms's c
    private int c;

    Array(int[] array) {
        begin = 0;
        end = array.length - 1;
        this.array = array;
        times = 0;
        c = 0;
    }

    public static void show(int[] array){
        for (int element: array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void showQuickSort() {
        System.out.print("\n排序完成后数组：");

        for (int i = 0; i < array.length; i++) {
            System.out.print("" + array[i] + " ");
        }
        double lgn = Math.log(array.length) / Math.log(2);
        c = (int) (times / (array.length * lgn));


        System.out.println("\n运算次数：" + times + "  算法复杂度为nlgn，系数大概为:" + c);
    }

    public void quickSort(int begin, int end){
        if (begin < end){
            int keyIndex = partition(begin, end);
            quickSort(begin, keyIndex - 1);
            quickSort(keyIndex + 1, end);
            times += 4;
        }
    }


    private int partition(int begin, int end){
        int key = array[end];
        //i is smaller index, j is bigger
        int i = begin;
        times += 2;
        for (int j = begin; j < end; j++){
            if (array[j] < key){
                swap(i, j);
                i++;
                times += 4;
            }
        }
        swap(i, end);
        times += 1;
        return i;
    }

    private void swap( int a, int b){
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
        times += 3;
    }
}