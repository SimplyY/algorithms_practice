package com.company;

import java.util.ArrayList;

/**
 * Created by yuwei on 2015/1/21.
 */

//当radix是int类时,
public class RadixData {
    int value = 0;
    public static int[] m_array;
    private int[] valueArrayOfRadix;
    private int radixAmount = 0;
    private static int RadixAmount = 0;
    public static Integer m_times;

    public static RadixData[] getRadixData(int[] array, int radixAmount){
        m_array = array;
        m_times = new Integer(0);
        RadixAmount = radixAmount;
        RadixData[] radixArray = new RadixData[array.length];

        for (int i = 0; i < array.length; i++) {
            radixArray[i] = new RadixData(array[i], radixAmount);
        }

        return radixArray;
    }



    public RadixData(int value,int radixAmount) {
        this.radixAmount = radixAmount;
        valueArrayOfRadix = new int[radixAmount];
        int theMaxDigit = radixAmount;
        this.value = value;
        getEveryDigitValue(value, theMaxDigit);
    }


//  将整数（value）映射到拥有各位数值的数组上（valueArrayOfRadix）
    private void getEveryDigitValue(int value,int theMaxDigit){
        for (int i = 0; i < theMaxDigit; i++) {
            //当基数是某位数上的数字时
            int theDigit = i + 1;
            int theDigitWeight = (int)Math.pow(10, theDigit - 1);
            int theNextDigitWeight = theDigitWeight * 10;
            valueArrayOfRadix[i] = (value % (theNextDigitWeight))/theDigitWeight;
            value -= valueArrayOfRadix[i] * theDigitWeight;
        }
    }

    public static void countingSortForRadix(RadixData[] radixArray){
        for (int i = 0; i < RadixAmount; i++) {
            countingSort(radixArray, i + 1);
        }
    }

    private static void countingSort(RadixData[] radixArray, int digit){
        CountArray[] countArray = new CountArray[10];
        for (int i = 0; i < 10; i++) {
            countArray[i] = new CountArray();
        }

        for (int i = 0; i < radixArray.length; i++) {
            RadixData theRadixData = radixArray[i];
            int radixDataValue = theRadixData.valueArrayOfRadix[digit - 1];
            countArray[radixDataValue].count += 1;
            countArray[radixDataValue].value.add(theRadixData.value);
            m_times += 2;
        }

        int arrayIndex = 0;
        m_times++;
        for (int countIndex = 0; countIndex < countArray.length; countIndex++) {
            for (int j = 0; j < countArray[countIndex].count; j++) {
                m_array[arrayIndex] = countArray[countIndex].value.get(j);
                arrayIndex++;
                m_times += 4;
            }
        }


        for (int i = 0; i < radixArray.length; i++) {
            radixArray[i].value = m_array[i];
//            radixArray[i].getEveryDigitValue(m_array[i], radixArray[i].radixAmount);
//            m_times++;
        }
        for (RadixData radixData : radixArray) {
            radixData.getEveryDigitValue(radixData.value, radixData.radixAmount);
        }
    }
}

