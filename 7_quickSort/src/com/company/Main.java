package com.company;

public class Main {



    public static void main(String[] args) {
        int[] array = {3,41,52,26,38,57,9,49};
        Array.show(array);

        Array theArray = new Array(array);
        theArray.quickSort( 0, array.length - 1);
        theArray.showQuickSort();

    }
}
