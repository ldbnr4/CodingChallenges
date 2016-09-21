package com.company;

/**
 * Created by boyice on 9/19/2016.
 *
 */
class Sorting {
    private static int result[];
    private static int k = 0;
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
        int loLength = lowerHalf.length;
        int highLength = upperHalf.length;
        int[] result = new int[loLength+highLength];
        int k = 0, i = 0, j = 0;
        while (i < loLength && j < highLength){
            if(lowerHalf[i] <= upperHalf[j]) result[k++] = lowerHalf[i++];
            else result[k++] = upperHalf[j++];
        }
        while (i < loLength) result[k++] = lowerHalf[i++];
        while (j < highLength) result[k++] = upperHalf[j++];

        return result;
    }

    static int[] quickSort(int[] array, int left, int right){
        if(left>=right) return null;
        int leftPointer = left;
        int rightPointer = right;
        int pivot = array[left + (right-left)/2];
        while (leftPointer < rightPointer) {
            while (array[leftPointer] < pivot) leftPointer++;
            while (array[rightPointer] > pivot) rightPointer--;
            if (leftPointer <= rightPointer) swap(array, leftPointer++, rightPointer--);
        }
        if(left < rightPointer) quickSort(array, left, rightPointer);
        if(leftPointer < right) quickSort(array, leftPointer, right);
        return array;
    }

    private static void swap(int array[], int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
