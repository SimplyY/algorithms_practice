package com.yuwei;


public class Main {

    public static void main(String[] args) {

        int[] sortedArray = new int[]{0,1,2,5,12,12,45,78,84,111,114,145,202,205,510,610};
        int mergeWay1 = 1;
        int mergeWay2 = 2;
        int mergeWay3 = 3;

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print("" + sortedArray[i] + " ");
        }

        Array array1 = new Array(sortedArray);
        array1.doMergeSort(mergeWay1);

//        Array array2 = new Array(sortedArray);
//        array1.doMergeSort(mergeWay1);
//
//        Array array3 = new Array(sortedArray);
//        array1.doMergeSort(mergeWay1);


    }
}
