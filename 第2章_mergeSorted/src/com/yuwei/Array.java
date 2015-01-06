/**
 * Created by yuwei on 2015/1/5.
 */
package com.yuwei;


public class Array {
    private int begin;
    private int end;
    private int[] array;
    //times means the algorithms's caculating times
    private int times;
    //n means quotiety of algorithms's n
    private int c;
    private int mergeWay;

    Array(int[] array) {
        begin = 0;
        end = array.length - 1;
        this.array = array;
        times = 0;
        c = 0;
    }

    public void doMergeSort(int mergeWay) {
        this.mergeWay = mergeWay;
        if(mergeWay!=3){
            mergeSort(begin, end, array);
        }
        else{
            specialMergeSort(begin, end, array);
        }
        showMergeSort();
    }

    private void showMergeSort() {
        System.out.println("排序方式：" + mergeWay + "\n排序完成后数组：");

        for (int i = 0; i < array.length; i++) {
            System.out.print("" + array[i] + " ");
        }
        double lgn = Math.log(array.length) / Math.log(2);
        c = (int) (times / (array.length * lgn));


        System.out.println("\n运算次数：" + times + "  算法复杂度为nlgn，系数c不大于:" + c);
    }


    private void mergeSort(int begin, int end, int[] array) {
        if (begin < end) {
            int dividePosition = (begin + end) / 2;

            mergeSort(begin, dividePosition, array);
            mergeSort(dividePosition + 1, end, array);
            if (mergeWay == 1) {
                merge1(begin, dividePosition, end, array);
            } else if (mergeWay == 2) {
                merge2(begin, dividePosition, end, array);
            }
            times += 5;
        }
        times++;

    }

    //mergeWay == 3,用哨兵， 小数组内使用插入排序
    private void specialMergeSort(int begin, int end, int[] array) {
        if (begin < end - 2) {
            int dividePosition = (begin + end) / 2;

            specialMergeSort(begin, dividePosition, array);
            specialMergeSort(dividePosition + 1, end, array);
            insertSort(begin, dividePosition, array);
            insertSort(dividePosition + 1, end, array);
            merge1(begin, dividePosition, end, array);
            times += 5;
        }
        times++;
    }

    //用哨兵，当使用哨兵的时候，会使array1和array2的长度加1！！！
    private void merge1(int begin, int dividePosition, int end, int[] array) {
        int[] array1 = new int[dividePosition - begin + 2];
        int[] array2 = new int[end - dividePosition + 1];
        array1[array1.length - 1] = Integer.MAX_VALUE;
        array2[array2.length - 1] = Integer.MAX_VALUE;
        times += 4;

        for (int i = 0; i < array1.length - 1; i++) {
            array1[i] = array[begin + i];
            times += 2;
        }
        for (int i = 0; i < array2.length - 1; i++) {
            array2[i] = array[dividePosition + i + 1];
            times += 2;
        }

        for (int i = begin, index1 = 0, index2 = 0; i <= end; i++) {
            if (array1[index1] < array2[index2]) {
                array[i] = array1[index1];
                index1++;
                times += 4;
            } else {
                array[i] = array2[index2];
                index2++;
                times += 4;
            }
        }
    }

    //不用哨兵
    private void merge2(int begin, int dividePosition, int end, int[] array) {
        int[] array1 = new int[dividePosition - begin + 1];
        int[] array2 = new int[end - dividePosition];
        times += 4;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[begin + i];
            times += 2;
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[dividePosition + i + 1];
            times += 2;
        }

        for (int i = begin, index1 = 0, index2 = 0; i <= end; i++) {
            if (index1 < array1.length && index2 < array2.length) {
                if (array1[index1] < array2[index2]) {
                    array[i] = array1[index1];
                    index1++;
                    times += 4;
                } else {
                    array[i] = array2[index2];
                    index2++;
                    times += 4;
                }
            } else if (index1 < array1.length) {
                array[i] = array1[index1];
                index1++;
                times += 4;
            } else if (index2 < array2.length) {
                array[i] = array2[index2];
                index2++;
                times += 5;
            }
        }
    }


    private void insertSort(int begin, int end, int[] array){
        for (int i = begin + 1; i < end; i++) {
            int key = array[i];
            times += 2;
            for (int j = i - 1; j > 0; j--) {
                if(key < array[j]){
                    array[j + 1] = array[j];
                    times += 3;
                }
                else{
                    array[j + 1] = key;
                    times +=3;
                    break;
                }
            }
        }
    }
}