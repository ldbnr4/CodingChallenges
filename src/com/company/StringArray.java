package com.company;

import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Created by Lorenzo on 7/7/2016.
 *
 */
class StringArray {
    static void rotateArray(Object[] array, int shift){

        int length = array.length;
        if (length == 0){
            System.out.println("Empty array!\n");
            return;
        }

        System.out.print("Before: "+ Arrays.toString(array));
        System.out.println(" Shift = "+shift);

        if(abs(shift) > length){
            shift = shift%length;
        }

        Object[] result = new Object[length];
        for (int oldPosition = 0, newPosition; oldPosition < length; oldPosition++) {
            newPosition = oldPosition + shift;
            if (newPosition >= length) {
                newPosition = newPosition % length;
            }
            if(newPosition < 0 ){
                newPosition += length;
            }

            result[newPosition] = array[oldPosition];
        }

        System.out.println("After: "+ Arrays.toString(result)+"\n");
    }

    static void stringReversal(String sentence){
        if(sentence.isEmpty()){
            System.out.println("Empty string!\n");
        }

        System.out.println("Beginning string: \""+sentence+"\"");
        char[] chars = sentence.toCharArray();
        String result = "";

        for(int cursor = chars.length-1, wordStart = chars.length-1; cursor >= 0; cursor--){
            if (String.valueOf(chars[cursor]).matches("\\W") || cursor == 0){
                String word;
                if (wordStart == cursor){
                    word = String.valueOf(chars[wordStart]);
                }else {
                    word = String.valueOf(chars).substring(cursor, wordStart);
                }
                result += word;
                wordStart = cursor;
            }
        }

        System.out.println("Reversed string: \""+result+"\"");
    }
}

/*
 * Copyright (c) 2015, by The Curators of University of Missouri, All Rights Reserved
 */
