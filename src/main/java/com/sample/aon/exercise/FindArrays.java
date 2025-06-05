package com.sample.aon.exercise;

import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindArrays {

    private int[] numArray;
    private int[] numSubArray;

    public FindArrays(int[] numArray, int[] numSubArray) {
        this.numArray = numArray;
        this.numSubArray = numSubArray;
    }

    public int findStartingIndex(){
        // Convert the int arrays to whole String
        var stringArray = Arrays.toString(numArray).replaceAll("[\\[\\],\\s]","");
        var stringSubArray = Arrays.toString(numSubArray).replaceAll("[\\[\\],\\s]","");
        // Use string indexOf to find index of subarray string pattern
        return stringArray.indexOf(stringSubArray);
    }

    public static void main(String args[]) {
        FindArrays findArrays = new FindArrays(new int[]{4,9,3,7,8}, new int[]{3,7});
        System.out.println(findArrays.findStartingIndex());
    }
}
