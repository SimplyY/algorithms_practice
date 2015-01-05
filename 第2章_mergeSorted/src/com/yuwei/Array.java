/**
 * Created by yuwei on 2015/1/5.
 */
package com.yuwei;

public class Array {
    private int begin;
    private int end;
    private int[] array;
    private int times;
    private int mergeWay;

    Array(int[] array){
        begin = 0;
        end = array.length - 1;
        this.array = array;
        times = 0;
    }

    public void doMergeSort(int mergeWay){
        this.mergeWay = mergeWay;
        mergeSort(begin, end, array);
        showMergeSort();
    }
    private void showMergeSort(){
        System.out.print("排序方式：" + mergeWay + "  排序完成后数组：");

        for (int i = 0; i < array.length; i++) {
            System.out.print("" + array[i] + " ");
        }

        System.out.println("运算次数：" + times);
    }


    private void mergeSort(int begin, int end, int[] array){

        if(begin < end ){
            int dividePosition = (begin + end)/2;

            mergeSort(begin, dividePosition, array);
            mergeSort(dividePosition + 1, end, array);
            if (mergeWay == 1){
                merge1(begin, dividePosition, end,array);
            }
            else if(mergeWay == 2){
                merge2(begin, dividePosition, end,array);
            }
            else if(mergeWay == 3){
                merge3(begin, dividePosition, end,array);
            }
        }


    }

    //用哨兵，当使用哨兵的时候，会使array1和array2的长度加1！！！
    private void merge1(int begin, int dividePosition, int end,int[] array){
        int[] array1 = new int[dividePosition - begin + 2];
        int[] array2 = new int[end - dividePosition + 1];
        array1[array1.length - 1] = Integer.MAX_VALUE;
        array2[array2.length - 1] = Integer.MAX_VALUE;

        for (int i = 0; i < array1.length - 1; i++) {
            array1[i] = array[begin + i];
        }
        for (int i = 0; i < array2.length - 1; i++) {
            array2[i] = array[dividePosition + i + 1];
        }

        for (int i = begin, index1 = 0,index2 = 0; i <= end; i++) {
            if(array1[index1] < array2[index2]){
                array[i] = array1[index1];
                index1++;
            }
            else{
                array[i] = array2[index2];
                index2++;
            }
        }
    }

    //不用哨兵
    private void merge2(int begin, int dividePosition, int end, int[] array){
        int[] array1 = new int[dividePosition - begin + 1];
        int[] array2 = new int[end - dividePosition];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[array1.length + i];
        }

        for (int i = begin,index1 = 0,index2 = 0; i < end; i++) {
            if(array1[index1] < array2[index2]){
                array[i] = array1[index1];
                index1++;
            }
            else{
                array[i] = array2[index2];
                index2++;
            }
        }
    }

    //对小数组采用插入排序
    private void merge3(int begin, int dividePosition, int end, int[] array){

    }



}
