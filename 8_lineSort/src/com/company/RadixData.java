package com.company;

/**
 * Created by yuwei on 2015/1/21.
 */

//当radix是int类时,
public class RadixData {
    private int[] valueArrayOfRadix;
    private int radixAmount = 0;
    public static RadixData[] getRadixData(int[] array, int radixAmount){
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
        getEveryDigitValue(value, theMaxDigit);
    }

//  将整数（value）映射到拥有各位数值的数组上（valueArrayOfRadix）
    private void getEveryDigitValue(int value, int theMaxDigit){
        for (int i = 0; i < theMaxDigit; i++) {
            //当基数是某位数上的数字时
            int theDigit = i + 1;
            int theDigitWeight = (int)Math.pow(10, theDigit - 1);
            int theNextDigitWeight = theDigitWeight * 10;
            valueArrayOfRadix[i] = (value % (theNextDigitWeight))/theDigitWeight;
            value -= valueArrayOfRadix[i] * theDigitWeight;
        }
    }

}
