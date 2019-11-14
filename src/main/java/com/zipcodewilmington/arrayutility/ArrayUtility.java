package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private ArrayList<E> arr;
    private E[] input;

    public ArrayUtility(E[] arr) {
        this.arr = new ArrayList<E>(Arrays.asList(arr));
        this.input = arr;
    }

    public E[] removeValue(E valueToRemove) {

        while (this.arr.contains(valueToRemove)) {
            this.arr.remove(valueToRemove);
        }

        return this.arr.toArray(Arrays.copyOf(this.input, this.arr.size()));
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        int count = 0;
        for (E obj : this.arr) {
            if (obj.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        this.arr.addAll(new ArrayList<E>(Arrays.asList(arrayToMerge)));
        E mostCommon = this.arr.get(0);
        int count = 0;
        HashSet<E> set = new HashSet<E>(this.arr);
        for (E item : set) {
            int thisItemCount = countOccurrences(item);
            if (thisItemCount > count) {
                count = thisItemCount;
                mostCommon = item;
            }
        }
        return mostCommon;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        this.arr.addAll(new ArrayList<E>(Arrays.asList(arrayToMerge)));
        return countOccurrences(valueToEvaluate);
    }

    public int countOccurrences(E item) {
        int count = 0;
        for (E obj : this.arr) {
            if (item.equals(obj)) {
                count++;
            }
        }
        return count;
    }
}
