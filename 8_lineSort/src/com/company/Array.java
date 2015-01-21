/**
 * Created by yuwei on 2015/1/5.
 */
package com.company;


public class Array {
    private int begin;
    private int end;
    private int[] m_array;
    //times means the algorithms's caculating times
    private int times;
    //c means quotiety of algorithms's c
    private int c;
    private int bound;

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int[] getM_array() {
        return m_array.clone();
    }

    public int getTimes() {
        return times;
    }

    public int getC() {
        return c;
    }

    public int getBound() {
        return bound;
    }

    Array(int[] array) {
        begin = 0;
        end = array.length - 1;
        this.m_array = array;
        times = 0;
        c = 0;

        bound = array.length;
    }

    Array(Array theArray){
        begin = theArray.getBegin();
        end = theArray.getEnd();
        this.m_array = theArray.getM_array();
        times = theArray.getTimes();
        c = theArray.getC();
        bound = theArray.getBound();
    }

    public static void show(int[] array){
        for (int element: array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

//    这里没有创建新的输出数组，设置了arrayIndex，来实现原数组为输出数组
    public void countingSort(){
        int[] countArray = new int[bound];
        times++;
        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = 0;
            times += 2;
        }

        for (int i = 0; i < m_array.length; i++) {
            countArray[m_array[i]] += 1;
            times += 2;
        }

        int arrayIndex = 0;
        times++;
        for (int countIndex = 0; countIndex < countArray.length; countIndex++) {
            for (int j = 0; j < countArray[countIndex]; j++) {
                m_array[arrayIndex] = countIndex;
                arrayIndex++;
                times += 4;
            }
        }
    }

    public void radixSort(){
        int radixAmount = (int)Math.log10(bound) + 1;

        RadixData[] radixArray = RadixData.getRadixData(m_array, radixAmount);

        int a = 0;

    }




    public void showLineSort() {
        System.out.print("\n排序完成后数组：");

        for (int i = 0; i < m_array.length; i++) {
            System.out.print("" + m_array[i] + " ");
        }
        c = (int) (times / (m_array.length ));

        System.out.println("\n运算次数：" + times + "  算法复杂度为n，系数大概为:" + c);
    }

}