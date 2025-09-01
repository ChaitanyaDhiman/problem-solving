package com.app.arraysandstrings.easy;

//    Reverse an Array in groups of given size
//
//    Given an array arr[] and an integer k, find the array after reversing every subarray of consecutive k elements in place.
//    If the last subarray has fewer than k elements, reverse it as it is. Modify the array in place, do not return anything.
//
//    Examples:
//    Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
//    Output: [3, 2, 1, 6, 5, 4, 8, 7]
//    Explanation: Elements is reversed: [1, 2, 3] → [3, 2, 1], [4, 5, 6] → [6, 5, 4], and the last group [7, 8](size < 3) is reversed as [8, 7].
//
//    Input: arr[] = [1, 2, 3, 4, 5], k = 3
//    Output: [3, 2, 1, 5, 4]
//    Explanation: First group consists of elements 1, 2, 3. Second group consists of 4, 5.
//
//    Input: arr[] = [5, 6, 8, 9], k = 5
//    Output: [9, 8, 6, 5]
//    Explanation: Since k is greater than array size, the entire array is reversed.
public class ReverseArrayInGroups {

    public static void reverseArrayGroup(int[] arr, int k) {
        int length = arr.length;

        for (int i = 0; i < length; i += k){
            int left = i;
            int right = Math.min( i + k - 1, length - i );

            while (left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 3;

        reverseArrayGroup(arr, k);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
