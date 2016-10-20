package com.company;

/**
 * Created by boyice on 9/19/2016.
 *
 */
class Sorting {
    static Integer[] mergeSort(Integer[] array, int lo, int hi){
        if(lo == hi) return new Integer[]{array[lo]};
        if(lo < hi) {
            int mid = (hi + lo) / 2;
            Integer[] lowerHalf = mergeSort(array, lo, mid);
            Integer[] upperHalf = mergeSort(array, mid + 1, hi);
            return merge(lowerHalf, upperHalf);
        }
        return null;
    }

    private static Integer[] merge(Integer[] lowerHalf, Integer[] upperHalf) {
        int loLength = lowerHalf.length;
        int highLength = upperHalf.length;
        Integer[] result = new Integer[loLength+highLength];
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
