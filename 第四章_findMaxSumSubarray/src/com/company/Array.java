/**
 * Created by yuwei on 2015/1/5.
 */
package com.company;


public class Array {

    private int[] array;
    //times means the algorithms's caculating times
    private int times = 0;
    //n means quotiety of algorithms's n
    private int c = 0;
    private int begin;
    private int end;
    private int findWay;

    Array(int[] array) {
        this.array = array;
        begin = 0;
        end = array.length - 1;
    }

    public void doFindMaxSumSubarray(int findWay) {
        this.findWay = findWay;
        if(findWay == 1){
            Sum maxSumSubarray = findMaxSumSubarray(array);
            showMaxSubarraySum(maxSumSubarray);

        }
        else if(findWay == 2){
            Sum maxSumSubarray = findMaxSumSubarrayRecursion(begin, end);
            showMaxSubarraySum(maxSumSubarray);
        }
        else if(findWay == 3){

        }
    }


    private Sum findMaxSumSubarray(int[] array){
        Sum[][] subarraySum = new Sum[array.length][array.length];
        Sum maxSubarraySum = new Sum();

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
                    //how to get thsSum is important
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


        times ++;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (subarraySum[i][j].getSum() > maxSubarraySum.getSum()){
                    maxSubarraySum = subarraySum[i][j];
                    times += 2;
                }
            }
        }

        return maxSubarraySum;
    }

    //递归法
    private Sum findMaxSumSubarrayRecursion(int begin,int end){
        //如果数组长度为1，最大子数组为它本身

        if (begin == end){
            Sum maxSumSubarray = new Sum(begin, end, array[begin]);
            return maxSumSubarray;
        }

        int divideIndex = (begin + end)/2;

        Sum leftMaxSum = findMaxSumSubarrayRecursion(begin, divideIndex);
        Sum rightMaxSum = findMaxSumSubarrayRecursion(divideIndex + 1, end);
        Sum crossMaxSum = findCrossMaxSubarray(begin, divideIndex, end);

        if(leftMaxSum.getSum() > rightMaxSum.getSum() && leftMaxSum.getSum() > crossMaxSum.getSum()){
            return leftMaxSum;
        }
        else if(crossMaxSum.getSum() > leftMaxSum.getEnd() && crossMaxSum.getSum() > rightMaxSum.getSum()){
            return crossMaxSum;
        }
        else {
            return rightMaxSum;
        }
    }

    private Sum findCrossMaxSubarray(int begin,int divideIndex, int end){
        Sum crossMaxSum = new Sum();
        Sum leftMaxSubarraySum = new Sum();
        Sum rightMaxSubarraySum = new Sum();
        Sum[] leftSubarraySum = new Sum[divideIndex - begin + 1];
        Sum[] rightSubarraySum = new Sum[end - divideIndex];

        for (int i = divideIndex; i >=begin; i--) {
            if(i < divideIndex){
                int theBegin = i;
                int theEnd = divideIndex;
                int theSum = leftSubarraySum[divideIndex - i - 1].getSum() + array[i];
                leftSubarraySum[divideIndex - i] = new Sum(theBegin, theEnd, theSum);
            }
            else{
                leftSubarraySum[divideIndex - i] = new Sum(i, divideIndex, array[i]);
            }
        }

        for (Sum theLeftSubarraySum : leftSubarraySum) {
            if (theLeftSubarraySum.getSum() > leftMaxSubarraySum.getSum()){
                leftMaxSubarraySum = theLeftSubarraySum;
            }
        }

        for (int i = divideIndex + 1; i <= end; i++) {
            if (i > divideIndex + 1){
                int theBegin = divideIndex;
                int theEnd = i;
                int theSum = rightSubarraySum[i - divideIndex - 2].getSum() + array[i];
                rightSubarraySum[i - divideIndex - 1] = new Sum(theBegin, theEnd, theSum);
            }
            else{
                rightSubarraySum[i - divideIndex - 1] = new Sum(divideIndex, i, array[i]);
            }
        }

        for (Sum theRightSubarraySum : rightSubarraySum) {
            if (theRightSubarraySum.getSum() > rightMaxSubarraySum.getSum()){
                rightMaxSubarraySum = theRightSubarraySum;
            }
        }

        crossMaxSum.setBegin(leftMaxSubarraySum.getBegin());
        crossMaxSum.setEnd(rightMaxSubarraySum.getEnd());
        crossMaxSum.setSum(leftMaxSubarraySum.getSum() + rightMaxSubarraySum.getSum());

        return crossMaxSum;

    }

    private void showMaxSubarraySum(Sum maxSubarraySum) {
        System.out.println("\n查找最大子数组方式：" + findWay + "\n最大子数组的和为" + maxSubarraySum.getSum() + "\n最大子数组为：");
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