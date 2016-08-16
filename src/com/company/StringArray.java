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

        // shorten shift if it is larger than the array
        if(abs(shift) > length){
            shift = shift%length;
        }

        Object[] result = new Object[length];
        for (int oldPosition = 0, newPosition; oldPosition < length; oldPosition++) {
            newPosition = oldPosition + shift;
            // wrap around if new position is larger than the length
            if (newPosition >= length) {
                newPosition = newPosition % length;
            }
            // case for a left shift
            if(newPosition < 0 ){
                newPosition += length;
            }

            // place the item in the new location
            result[newPosition] = array[oldPosition];
        }

        System.out.println("After: "+ Arrays.toString(result)+"\n");
    }

    static void stringReversal(String sentence){
        if(sentence.isEmpty()){
            System.out.println("Empty string!\n");
            return;
        }

        System.out.println("Beginning string: \""+sentence+"\"");
        // load string into a character array
        char[] chars = sentence.toCharArray();
        String result = "";

        // loop through the entire string character by character
        for(int cursor = chars.length-1, wordEnd = chars.length-1; cursor >= 0; cursor--){
            // check if a non letter has been reached
            if (String.valueOf(chars[cursor]).matches("\\W") || cursor == 0){
                // the word immediately before the non letter was reached
                String word = String.valueOf(chars).substring(cursor, wordEnd+1);
                // remove space from the front of the word if it is on the end of the original string
                if(wordEnd == chars.length-1) word = word.replaceFirst(" ", "");
                // add leading space on the first word of the original string
                if(cursor == 0) word = " " + word;
                // add the word to the result reversed string
                result += word;
                //update to the end of the next word
                wordEnd = cursor-1;
            }
        }

        System.out.println("Reversed string: \""+result+"\"\n");
    }
}
