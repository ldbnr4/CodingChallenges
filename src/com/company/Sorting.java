package com.company;

/**
 * Created by boyice on 9/19/2016.
 *
 */
public class Sorting {
    static int[] mergeSort(int[] array, int lo, int hi){
        if(lo == hi) return new int[]{array[lo]};
        if(lo < hi) {
            int mid = (hi + lo) / 2;
            int[] lowerHalf = mergeSort(array, lo, mid);
            int[] upperHalf = mergeSort(array, mid + 1, hi);
            return merge(lowerHalf, upperHalf);
        }
        return null;
    }

    private static int[] merge(int[] lowerHalf, int[] upperHalf) {
        int loLength, highLength;
        if(lowerHalf == null) loLength = 0;
        else loLength = lowerHalf.length;

        if(upperHalf == null) highLength = 0;
        else highLength = upperHalf.length;

        int[] result = new int[loLength+highLength];
        int k = 0, i = 0, j = 0;
        while (i < loLength && j < highLength){
            if(lowerHalf[i] < upperHalf[j]) result[k++] = lowerHalf[i++];
            else result[k++] = upperHalf[j++];
        }
        while (i < loLength) result[k++] = lowerHalf[i++];
        while (j < highLength) result[k++] = upperHalf[j++];

        return result;
    }

}
