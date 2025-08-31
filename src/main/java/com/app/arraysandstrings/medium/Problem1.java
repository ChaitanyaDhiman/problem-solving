package com.app.arraysandstrings.medium;

// Next Permutation
//
// Given an array of integers arr[] representing a permutation (i.e., all elements are unique and arranged in some order),
// find the next lexicographically greater permutation by rearranging the elements of the array.
// If such a permutation does not exist (i.e., the array is the last possible permutation),
// rearrange the elements to form the lowest possible order (i.e., sorted in ascending order).
//
// Examples:
// Input: arr[] = [2, 4, 1, 7, 5, 0]
// Output: [2, 4, 5, 0, 1, 7]
// Explanation: The next lexicographically greater arrangement of the elements in the array arr[] is [2, 4, 5, 0, 1, 7].
//
// Input: arr[] = [3, 2, 1]
// Output: [1, 2, 3]
// Explanation: This is the last permutation, so we return the lowest possible permutation (ascending order).
//
// Input: arr[] = [1, 3, 5, 4, 2]
// Output: [1, 4, 2, 3, 5]
// Explanation: The next lexicographically greater arrangement of the elements in the array arr[] is [1, 4, 2, 3, 5].
public class Problem1 {
    static void nextPermutation(int[] arr) {
        int n = arr.length;

        // Find the pivot index
        int pivot = -1;
        for (int i = n - 2 ; i >= 0 ; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If pivot point does not exist, reverse the whole array
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return ;
        }

        // Find the element from the right that is greater than pivot
        for (int i = n - 1 ; i > pivot ; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }

        // Reverse the elements from the pivot + 1 to the end
        reverse(arr, pivot + 1, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {

        int[] arr = { 2, 4, 1, 7, 5, 0 };
        nextPermutation(arr);
        printArray(arr);

    }
}
