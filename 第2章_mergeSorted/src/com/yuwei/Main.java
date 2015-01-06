package com.yuwei;


public class Main {

    public static void main(String[] args) {

        int[] sortedArray = new int[]{3,41,52,26,38,57,9,49};
        int mergeWay1 = 1;
        int mergeWay2 = 2;
        int mergeWay3 = 3;

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print("" + sortedArray[i] + " ");
        }

        Array array1 = new Array(sortedArray);
        array1.doMergeSort(mergeWay1);

        Array array2 = new Array(sortedArray);
        array2.doMergeSort(mergeWay2);

        Array array3 = new Array(sortedArray);
        array3.doMergeSort(mergeWay3);


    }
}
