package com.company;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.LinkedList;

/**
 * Created by yuwei on 2015/1/24.
 */
public class Bucket {
    LinkedList<Integer> linkedList;
    static public Integer times = 0;

    public Bucket() {
        linkedList = new LinkedList<Integer>();
    }

    public  static Bucket[] getBuckets(int[] array){
        Bucket[] buckets = new Bucket[array.length];
        for (int i = 0; i < array.length; i++) {
            buckets[i] = new Bucket();
        }
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = array[i];
            buckets[bucketIndex].linkedList.add(array[i]);
        }
        return  buckets;
    }

}
