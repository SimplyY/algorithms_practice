package com.company;

/**
 * Created by yuwei on 2015/1/7.
 */
public class Sum {

    private int begin = 0;
    private int end = 0;
    private int sum = 0;

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int getSum() {
        return sum;
    }

    public Sum() {

    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Sum(int begin, int end, int sum) {
        this.begin = begin;
        this.end = end;
        this.sum = sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
