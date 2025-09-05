package com.app.pattern_based.prefix_sum.find_pivot_index;

public class Solution {

    static int pivotIndex(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i : arr)
            rightSum += i;

        for (int i = 0; i < arr.length; i++){
            rightSum -= arr[i];

            if( leftSum == rightSum ) return i;

            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{1,2,3}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }
}
