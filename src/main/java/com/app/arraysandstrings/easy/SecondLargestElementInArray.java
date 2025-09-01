package com.app.arraysandstrings.easy;

import java.util.Arrays;

/*

Second-Largest Element in an Array

Given an array of positive integers arr[] of size n, the task is to find second-largest distinct element in the array.

Note: If the second largest element does not exist, return -1.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second-largest element is 34.

Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second-largest element is 5.

Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 there is no second-largest element.

*/
public class SecondLargestElementInArray {

//     This is a normal approach using sort.
//     Time Complexity: O(n*log(n)), as sorting the array takes O(n*log(n)) time and
//     traversing the array can take O(n) time in the worst case, so total time complexity = (n*log(n) + n) = O(n*log(n)).
    public static int secondLargestApproach1(int[] arr) {

        int length = arr.length;

        Arrays.sort(arr);

        for (int i = length - 2; i >= 0; i--) {
            if(arr[i] != arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }

//     Two pass search
//     The approach is to traverse the array twice. In the first traversal, find the maximum element.
//     In the second traversal, find the maximum element ignoring the one we found in the first traversal.
//     Time Complexity: O(2*n) = O(n), as we are traversing the array two times.
    public static int secondLargestApproach2(int[] arr) {

        int largest = -1, secondLargest = -1;

        // Finding the largest element
        for (int j : arr) {
            if (j > largest) {
                largest = j;
            }
        }

        // Finding the second-largest element.
        for (int j : arr) {
            if (j > secondLargest && j != largest) {
                secondLargest = j;
            }
        }
        return secondLargest;
    }

//     One Pass Search
//     The idea is to keep track of the largest and second-largest element while traversing the array.
//     Initialize largest and secondLargest with -1. Now, for any index i,
//     - If arr[i] > largest, update secondLargest with largest and largest with arr[i].
//     - Else If arr[i] < largest and arr[i] > secondLargest, update secondLargest with arr[i].
    public static int secondLargestApproach3(int[] arr) {

        int largest = -1, secondLargest = -1;

        // Finding the second-largest element
        for(int j : arr){
            if(j > largest){
                secondLargest = largest;
                largest = j;
            }
            else if(j < largest && j > secondLargest){
                secondLargest = j;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 39, 14, 5, 16, 7, 8, 19, 10};
        int[] arr2 = {22,22};
        int[] arr3 = {1,1,1,1,2,1,1,2};

        System.out.println(secondLargestApproach1(arr)); // Should return : 19
        System.out.println(secondLargestApproach2(arr)); // Should return : 19
        System.out.println(secondLargestApproach3(arr)); // Should return : 19
        System.out.println(secondLargestApproach3(arr2)); // Should return : -1
        System.out.println(secondLargestApproach3(arr3)); // Should return : 1
    }
}
