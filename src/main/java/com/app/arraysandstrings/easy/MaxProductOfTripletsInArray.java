package com.app.arraysandstrings.easy;

//    Maximum product of a triplet (subsequence of size 3) in array
//
//    Given an integer array, find a maximum product of a triplet in the array.
//
//    Examples:
//    Input:  arr[ ] = [10, 3, 5, 6, 20]
//    Output: 1200
//    Explanation: Multiplication of 10, 6 and 20
//
//    Input:  arr[ ] =  [-10, -3, -5, -6, -20]
//    Output: -90
//
//    Input: arr[ ] =  [1, -4, 3, -6, 7, 0]
//    Output: 168

import java.util.Arrays;

public class MaxProductOfTripletsInArray {

//    By Using three nested loops
//    A simple solution is to check for every triplet using three nested loops.
//    Time Complexity: O(n3)
    public static int maxProductOfThreeApproach1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int length = arr.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    maxProduct = Math.max(maxProduct, arr[i] * arr[j] * arr[k]);
                }
            }
        }

        return maxProduct;
    }

//    By Using sorting - Time O(n*log(n)) and Space O(1)
//    - Sort the array using some efficient in-place sorting algorithm in ascending order.
//    - In triplets, either there will be 2 negative elements and 1 positive element or all 3 positive elements so that resultant product will be positive.
//    - Therefore, To maximise the result return the maximum of  product of the last three elements of the array and the product of the first two elements and last element.
    public static int maxProductOfThreeApproach2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int length = arr.length;

        Arrays.sort(arr);

//      return arr[length-1] * arr[length - 2] * arr[length - 3]; -> In-case of negative elements this won't work.
        return length > 2 ? Math.max(arr[0] * arr[1] * arr[length - 1], arr[length-1] * arr[length - 2] * arr[length - 3]) : 0;
    }

//    By Using Greedy approach - Time O(n) and Space O(1)
//    Scan the array and compute the Maximum, second maximum and third maximum element present in the array.
//    Scan the array and compute Minimum and second minimum element present in the array.
//    Return the maximum of product of Maximum, second maximum and third maximum and product of Minimum, second minimum and Maximum element.
    public static int maxProductOfThreeApproach3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxFirst = Integer.MIN_VALUE, maxSecond = Integer.MIN_VALUE, maxThird = Integer.MIN_VALUE;
        int minFirst = Integer.MAX_VALUE, minSecond = Integer.MAX_VALUE;

        for(int i : arr){
            if(i > maxFirst){
                maxThird = maxSecond;
                maxSecond = maxFirst;
                maxFirst = i;
            } else if(i > maxSecond){
                maxThird = maxSecond;
                maxSecond = i;
            } else if(i > maxThird){
                maxThird = i;
            }

            if(i < minFirst){
                minSecond = minFirst;
                minFirst = i;
            } else if(i < minSecond){
                minSecond = i;
            }
        }

        return Math.max(maxFirst * maxSecond * maxThird, minFirst * minSecond * maxThird);
    }

    public static void main(String[] args) {

        int[] arr = { 10, 3, 5, 6, 20 };
        int[] arr2 = { -10, 3, 5, 6, 20 };

        System.out.println(maxProductOfThreeApproach1(arr)); // Output: 1200
        System.out.println(maxProductOfThreeApproach2(arr)); // Output: 1200
        System.out.println(maxProductOfThreeApproach2(arr2)); // Output : 600
        System.out.println(maxProductOfThreeApproach3(arr)); // Output : 1200
    }
}
