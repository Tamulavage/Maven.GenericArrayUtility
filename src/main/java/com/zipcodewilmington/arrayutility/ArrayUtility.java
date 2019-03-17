package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {
    E[] genericArray;

    public ArrayUtility(E[] inputArray) {
        this.genericArray = inputArray;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        Integer count = getNumberOfOccurrences(valueToEvaluate);
        for(int i = 0;i<arrayToMerge.length; i++){
            if(arrayToMerge[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        Integer count = 0;
        for(int i = 0;i<genericArray.length; i++){
            if(genericArray[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        Integer common = 0;
        E retVal = null;

        for(int i = 0; i<arrayToMerge.length; i++){
             if(countDuplicatesInMerge(arrayToMerge, arrayToMerge[i])>common){
                 common = countDuplicatesInMerge(arrayToMerge, arrayToMerge[i]);
                 retVal = arrayToMerge[i];
             }
        }

        return retVal;
    }

    public E[] removeValue(E valueToRemove) {
        E[] retVal = Arrays.copyOf(genericArray, genericArray.length-getNumberOfOccurrences(valueToRemove));
        for (int i = 0, j=0; i < genericArray.length; i++) {
            if(genericArray[i]!=valueToRemove){
                retVal[j] = genericArray[i];
                j++;
            }

        }
        return retVal;
    }
}
