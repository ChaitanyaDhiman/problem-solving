package com.app.arraysandstrings.easy.find_second_largest_in_array;

import java.util.Arrays;

public class Solution {
    public static int secondLargest(int[] arr) {
        if ( arr == null || arr.length < 2 ) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        return second;
    }
    public static int secondLargest2(int[] arr) {
        if ( arr == null || arr.length < 2 ) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        Arrays.sort(arr);

        return arr[arr.length - 2];

    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println("The second largest element is: " + secondLargest(arr)); // Output: 34
        System.out.println("The second largest element is: " + secondLargest2(arr)); // Output: 34
    }
}
