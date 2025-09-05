package com.app.arraysandstrings.medium.next_permutation;

public class Solution {
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
