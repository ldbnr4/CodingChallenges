package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static boolean detectDuplicates(char str[]){
        if(str == null) return true;
        int len = str.length;
        if(len < 2) return false;

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(str[j] == str[i]) return true;
            }
        }

        boolean uniqueChars[] = new boolean[256];
        int charInt;
        for (char aStr : str) {
            charInt = aStr;
            if (uniqueChars[charInt]) return true;
            uniqueChars[charInt] = true;
        }

        return false;
    }

    static void reverseAString(char str[]){
        if(str == null) return;
        int len = str.length;
        if(len < 2) return;

        int begin = 0, end = len-1;
        char tmp;
        while(begin < end){
            tmp = str[begin];
            str[begin++] = str[end];
            str[end--] = tmp;
        }
        System.out.println(str);
    }

    static void removeDuplicates(char str[]){
        if(str == null) return;
        int len = str.length;
        if(len < 2) return;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) str[tail++] = str[i];
        }
        if(tail < len) str[tail] = 0;
        System.out.println(str);
    }

    static boolean isAnagram(char str1[], char str2[]){
        if(str1 == null ||  str2 ==null || str1.length != str2.length) return false;
        int chars[] = new int[256];
        int cInt;
        for(char c : str1){
            cInt = c;
            chars[cInt] += 1;
        }
        for(char c : str2){
            cInt = c;
            chars[cInt] -= 1;
        }
        for(int i : chars){
            if(i != 0) return false;
        }
        return true;
    }

    static void replaceSpaces(char str[]){
        if(str == null) return;
        int len = str.length;
        int spaceCount = 0;
        for(int strIndex = 0; strIndex < len; strIndex++)
            if(str[strIndex] == ' ') spaceCount++;
        int newLen = len + spaceCount * 2;
        char newStr[] = new char[newLen];
        len--;
        newLen--;
        for(; len >= 0; len--){
            if(str[len] == ' '){
                newStr[newLen--] = '0';
                newStr[newLen--] = '2';
                newStr[newLen--] = '%';
            }
            else {
                newStr[newLen--] = str[len];
            }
        }
        System.out.println(newStr);

    }

    static void matrixRotate90Deg(int matrix[][]){
        int N = matrix.length;
        int spiral[] = new int[N*N];
        int rStart, cEnd, rEnd, cStart, i;
        rStart = 0;
        cEnd = N - 1;
        rEnd = N - 1;
        cStart = 0;

        for(int x = 0; x < spiral.length;){
            if(cStart > cEnd) break;
            for(i = cStart; i <= cEnd; i++)
                spiral[x++] = matrix[rStart][i];
            rStart++;

            if(rStart > rEnd) break;
            for(i = rStart; i <= rEnd; i++)
                spiral[x++] = matrix[i][cEnd];
            cEnd--;

            if(cEnd < cStart) break;
            for(i = cEnd; i >= cStart; i--)
                spiral[x++] = matrix[rEnd][i];
            rEnd--;

            if(rEnd < rStart) break;
            for(i = rEnd; i <= rStart; i++)
                spiral[x++] = matrix[i][cStart];
            cStart++;
        }

        rStart = cStart = 0;
        rEnd = cEnd = N - 1;
        for(int y = 0; y < spiral.length; y++){
            if(rStart > rEnd) break;
            for(i = rStart; i <= rEnd; i++)
                matrix[i][cEnd] = spiral[y++];
            cEnd--;

            if(cEnd < cStart) break;
            for(i = cEnd; i >= cStart; i--)
                matrix[rEnd][i] = spiral[y++];
            rEnd--;

            if(rEnd < rStart) break;
            for(i = rEnd; i >= rStart; i--)
                matrix[i][cStart] = spiral[y++];
            cStart++;

            if(cStart > cEnd) break;
            for(i = cStart; i <= cEnd; i++)
                matrix[rStart][i] = spiral[y++];
            rStart++;
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    static void matrixRotate90Deg2(int matrix[][]){
        int N = matrix.length;
        int offset, first, last ;
        for(int layer = 0; layer < N / 2; ++layer){
            first = layer;
            last = N - 1 - layer;
            for(int i = first; i < last; ++i){
                offset = i - first;
                int tmp = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    static void matrixZeroer(int matrix[][]){
        int N = matrix.length;
        int M = matrix[0].length;
        int zeroRows[] = new int[N];
        int zeroCols[] = new int[M];
        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(matrix[x][y] == 0){
                    zeroCols[y] = 1;
                    zeroRows[x] = 1;
                }
            }
        }

        for (int x = 0; x < N; x++){
            for (int y = 0; y < M; y++){
                if(zeroCols[y] == 1 || zeroRows[x] == 1 )
                    matrix[x][y] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }

    static boolean isSubstring(char str1[], char str2[]){
        if(str1 == null || str2 == null || str1.length != str2.length) return false;
        int len = str1.length;
        char temp;
        for (char ignored : str1) {
            for (int i = 1; i < len; i++) {
                temp = str2[i];
                str2[i] = str2[0];
                str2[0] = temp;
            }
            if (Arrays.equals(str2, str1)) return true;
        }
        return false;
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        buildList(candidates, result, new ArrayList<Integer>(), target, 0);
        return result;
    }

    private static void buildList(int[] candidates, List<List<Integer>> result, List<Integer> currentList, int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length; i++){
                currentList.add(candidates[i]);
                buildList(candidates, result, currentList, target - candidates[i], i);
                currentList.remove(currentList.size() - 1);
            }
        }
        else if(target == 0 ) result.add(new ArrayList<Integer>(currentList));

    }

}
