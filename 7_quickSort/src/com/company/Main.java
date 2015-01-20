package com.company;

public class Main {

    private static void quickSort(int[] array, int begin, int end){
        if (begin < end){
            int keyIndex = partition(array, begin, end);
            quickSort(array, begin, keyIndex - 1);
            quickSort(array, keyIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end){
        int key = array[end];
        //i is smaller index, j is bigger
        int i = begin;
        for (int j = begin; j < end; j++){
            if (array[j] < key){
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);
        return i;
    }

    private static void swap(int[] array, int a, int b){
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }

    private static void show(int[] array){
        for (int element: array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 8, 12, 3, 4, 50, 2};
        show(array);
        quickSort(array, 0, array.length - 1);
        show(array);

    }
}
