package com.company;

import java.util.Arrays;

/**
 * Created by Lorenzo on 7/7/2016.
 *
 */
class StringArray {
    static void rotateArray(Object[] array, int k){

        int length = array.length;
        if (length == 0){
            System.out.println("Empty array!");
            System.out.println();
            return;
        }

        System.out.println("Before: "+ Arrays.toString(array));

        if(k > length){
            k = k% length;
        }

        Object[] result = new Object[length];
        if(k > 0) {
            for (int i = 0, j = 0; i < length; i++) {
                j = i + k;
                if (j >= length) {
                    j = j % length;
                }

                result[i] = array[j];
            }
        }
        else{
            for(int i = length, j = 0; i >= 0; i--){
                j = i + k;
                //if (j < 0)
            }
        }

        System.out.println("After: "+ Arrays.toString(result));
        System.out.println();
    }

    static void stringReversal(){}
}

/*
 * Copyright (c) 2015, by The Curators of University of Missouri, All Rights Reserved
 */
