package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOf2020ThenProduct {

    public static int SumOf2020ThenProduct (Integer[] numberArray, int target) {
        Set<Integer> diffSet = new HashSet<>();
        for (int i = 0; i < numberArray.length; i++) {
            int difference = target - numberArray[i];
            if (diffSet.contains(numberArray[i])) {
                return difference * numberArray[i];
            }
            if (!diffSet.contains(difference)) {
                diffSet.add(difference);
            }
        }
        return -1;
    }


    public static int SumOf2020ThenProduct3Sum (Integer[] numberArray, int target) {
        Arrays.sort(numberArray);
        for (int i = 0; i < numberArray.length; i++) {
            int target2entries = target - numberArray[i];
            int start = i + 1;
            int end = numberArray.length - 1;
            while (start < end) {
                if (numberArray[start] + numberArray[end] == target2entries) {
                    return numberArray[start] * numberArray[end] * numberArray[i];
                } else if (numberArray[start] + numberArray[end] > target2entries) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return -1;
    }
}
