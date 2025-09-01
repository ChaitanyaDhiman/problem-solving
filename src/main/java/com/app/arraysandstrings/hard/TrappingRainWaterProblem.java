package com.app.arraysandstrings.hard;

//  Trapping Rain Water Problem
//
//  Given an array arr[] of size n consisting of non-negative integers, where each element represents the height of a bar in an elevation map and the width of each bar is 1,
//  determine the total amount of water that can be trapped between the bars after it rains.
//
//
//  Examples:
//  Input: arr[] = [3, 0, 1, 0, 4, 0, 2]
//  Output: 10
//  Explanation: The expected rainwater to be trapped is shown in the above image.
//
//  Input: arr[] = [3, 0, 2, 0, 4]
//  Output: 7
//  Explanation: We trap 0 + 3 + 1 + 3 + 0 = 7 units.
//
//          Input: arr[] = [1, 2, 3, 4]
//  Output: 0
//  Explanation: We cannot trap water as there is no height bound on both sides
public class TrappingRainWaterProblem {

    public static int maxWater(int[] arr){
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int res = 0;

        // Fill left array
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        // Fill right array
        right[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }

        // Calculate the accumulated water element by element
        for (int i = 1; i < n - 1; i++) {
            int minOfTwo = Math.min(left[i], right[i]);
            res += minOfTwo - arr[i];
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater(arr));
    }
}
