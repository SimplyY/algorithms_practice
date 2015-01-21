package com.company;

import java.util.Random;

public class Main {

    static Array initRandomArray(int bound){
        Random random = new Random(System.currentTimeMillis());
        int[] testArray = new int[bound];

        for (int i = 0; i < testArray.length; i ++) {
            testArray[i] = random.nextInt() % bound;
            if (testArray[i] < 0){
                testArray[i] = 0 - testArray[i];
            }
        }
        Array.show(testArray);
        Array array = new Array(testArray);
        return array;
    }

    public static void main(String[] args) {
//      0 < array[i] < bound && array.length = bound
        int bound = 20;
        Array array1 = initRandomArray(bound);
        Array array2 = new Array(array1);
        Array array3 = new Array(array1);

        array1.countingSort();
        array1.showLineSort();

        array2.radixSort();

    }
}
