/**
 * Created by yuwei on 2015/1/5.
 */
package com.company;


public class Array {
    private int begin;
    private int end;
    private int[] array;
    //times means the algorithms's caculating times
    private int times;
    //n means quotiety of algorithms's n
    private int c;
    private int findWay;

    Array(int[] array) {
        begin = 0;
        end = array.length - 1;
        this.array = array;
        times = 0;
        c = 0;
    }

    public void doFindMaxSumSubarray(int findWay) {
        this.findWay = findWay;
        if(findWay == 1){
            findMaxSumSubarray(array);
        }
        else if(findWay == 2){
           // specialMergeSort(begin, end, array);
        }
        else if(findWay == 3){

        }
    }

    private void findMaxSumSubarray(int[] array){
        Sum[][] subarraySum = new Sum[array.length][array.length];
        times ++;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                subarraySum[i][j] = new Sum(i,j,0);

                times += 2;
            }

            times += 1;
        }

        for (int begin = 0; begin < array.length ; begin++){
            for (int end = begin; end < array.length ; end++){
                if(end >= 1) {
                    int theSum = subarraySum[begin][end - 1].getSum() + array[end];
                    int theBegin = subarraySum[begin][end - 1].getBegin();
                    int thsEnd = subarraySum[begin][end - 1].getEnd() + 1;
                    subarraySum[begin][end].setSum(theSum);
                    subarraySum[begin][end].setBegin(theBegin);
                    subarraySum[begin][end].setEnd(thsEnd);

                    times += 8;
                }
                else{
                    subarraySum[begin][end].setSum(array[end]);

                    times += 3;
                }
            }

            times ++;
        }

        Sum maxSubarraySum = new Sum();

        times ++;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (subarraySum[i][j].getSum() > maxSubarraySum.getSum()){
                    maxSubarraySum = subarraySum[i][j];
                    times += 2;
                }
            }
        }

        showMaxSubarraySum(maxSubarraySum);
    }

    private void showMaxSubarraySum(Sum maxSubarraySum) {
        System.out.println("\n查找最大子数组方式：" + findWay + "最大子数组的和为" + maxSubarraySum.getSum() + "\n最大子数组为：");
        System.out.println("begin：" + maxSubarraySum.getBegin() + "\nend:" + maxSubarraySum.getEnd());

        for (int i = maxSubarraySum.getBegin(); i <= maxSubarraySum.getEnd(); i++) {
            System.out.print("" + array[i] + " ");
        }
        if(findWay == 1){
            c = (int)(times/(array.length * array.length));
            System.out.println("\n运算次数：" + times + "  算法复杂度为n2，系数c不小于:" + c);
        }

        if(findWay == 2) {
            double lgn = Math.log(array.length) / Math.log(2);
            c = (int) (times / (array.length * lgn));
            System.out.println("\n运算次数：" + times + "  算法复杂度为nlgn，系数c不大于:" + c);

        }

    }



}