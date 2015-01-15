package com.yuwei;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{-3,41,52,-26,38,57,-9,-49};
        Array array1 = new Array(array);
        array1.show();
        array1.heapSort();
        array1.showHeapSort();

    }
}
