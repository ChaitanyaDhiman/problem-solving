package com.app.arraysandstrings.easy.max_consecutive_ones;

//      Maximum consecutive one’s (or zeros) in a binary array
//
//      Given a binary array arr[] consisting of only 0s and 1s, find the length of the longest contiguous sequence of either 1s or 0s in the array.
//
//      Examples :
//      Input: arr[] = [0, 1, 0, 1, 1, 1, 1]
//      Output: 4
//      Explanation: The maximum number of consecutive 1’s in the array is 4 from index 3-6.
//
//      Input: arr[] = [0, 0, 1, 0, 1, 0]
//      Output: 2
//      Explanation: The maximum number of consecutive 0’s in the array is 2 from index 0-1.
//
//      Input: arr[] = [0, 0, 0, 0]
//      Output: 4
//      Explanation: The maximum number of consecutive 0’s in the array is 4.

public class Solution {

//    Using Simple Traversal - O(n) Time and O(1) Space
//    The idea is to traverse the array once and count how many times the same value repeats consecutively.
//    The thought process is to use a counter that increases when the current element matches the previous one.
//    If a change is detected, we update the maximum streak and reset the count.
//
//    Steps-By-Step Approach:
//    - Initialize two variables: maxCount = 0 to store result and count = 1 for current streak length.
//    - Iterate through the array starting from index 1 to compare each element with the previous one.
//    - If arr[i] equals arr[i - 1], it means the streak continues, so increment count by 1.
//    - If they differ, update maxCount with the current count and reset count = 1 for a new streak.
//    - Continue this comparison until the loop finishes checking all elements in the array.
//    - After the loop, take the maximum of maxCount and count to cover the last streak.
//    - Return maxCount which holds the maximum number of consecutive 1s or 0s in the array.

    public static int maxConsecutiveOccurrencesApproach1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int length = arr.length;
        int maxCount = 0, count = 1;

        for (int i = 1; i < length ; i++) {
            if(arr[i] == arr[i - 1]){
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }

//    Using Bit Manipulation - O(n) Time and O(1) Space
//    The idea is to use XOR (^) to check if consecutive elements are the same.
//    As XOR of two numbers is 0 if both numbers are same. So, If prev ^ num == 0,
//    the sequence continues; else we update the maximum streak and reset the count.
//
//    Steps to implement the above idea:
//    - Initialize three variables: maxCount = 0, count = 0, and prev = -1 to track current and previous bits.
//    - Traverse the array, use XOR to compare current num with prev, if equal, increment count for the current streak.
//    - If prev and num differ, update maxCount with the current count, then reset count to 1.
//    - Update prev to current num in every iteration to track the previous element for the next comparison.
//    - After loop ends, compare and return the maximum of maxCount and count to cover last streak.
    public static int maxConsecutiveOccurrencesApproach2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxCount = 0, count = 0, prev = -1;

        for (int i : arr){
            if((prev ^ i) == 0){
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            prev = i;
        }
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 1, 1, 1, 1};
        int[] arr2 = {0, 0, 1, 0, 1, 0};

        System.out.println(maxConsecutiveOccurrencesApproach1(arr));
        System.out.println(maxConsecutiveOccurrencesApproach2(arr2));
    }
}
