package com.app.arraysandstrings.easy;

//    Rotate an Array by d - Counterclockwise or Left
//
//    Given an array of integers arr[] of size n, the task is to rotate the array elements to the left by d positions.
//
//    Examples:
//    Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
//    Output: {3, 4, 5, 6, 1, 2}
//    Explanation: After first left rotation, arr[] becomes {2, 3, 4, 5, 6, 1} and after the second rotation, arr[] becomes {3, 4, 5, 6, 1, 2}
//
//    Input: arr[] = {1, 2, 3}, d = 4
//    Output: {2, 3, 1}
//    Explanation: The array is rotated as follows:
//    After first left rotation, arr[] = {2, 3, 1}
//    After second left rotation, arr[] = {3, 1, 2}
//    After third left rotation, arr[] = {1, 2, 3}
//    After fourth left rotation, arr[] = {2, 3, 1}

public class RotateArrayByD {

//    Rotate one by one - O(n * d) Time and O(1) Space
//    In each iteration, shift the elements by one position to the left in a circular fashion (the first element becomes the last). Perform this operation d times to rotate the elements to the left by d positions.
//
//    Illustration:
//    Let us take arr[] = {1, 2, 3, 4, 5, 6}, d = 2.
//
//    First Step:
//            => Rotate to left by one position.
//            => arr[] = {2, 3, 4, 5, 6, 1}
//    Second Step:
//            => Rotate again to left by one position
//            => arr[] = {3, 4, 5, 6, 1, 2}
//    Rotation is done 2 times.
//    So the array becomes arr[] = {3, 4, 5, 6, 1, 2}

    static void rotateArray(int[] arr, int d, String direction) {
        int len = arr.length;

        if (direction.equals("clockwise")) {
            for (int i = 0; i < d; i++) {
                int lastElement = arr[len - 1];
                for (int j = len - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = lastElement;
            }
        } else if (direction.equals("counterclockwise")) {
            for (int i = 0; i < d ; i++) {
                int first = arr[0];
                for (int j = 0; j < len - 1 ; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[len - 1] = first;
            }
        }
    }

//    Using Reversal Algorithm - O(n) Time and O(1) Space
//    The idea is based on the observation that if we left rotate the array by d positions, the last (n - d) elements will be at the front and the first d elements will be at the end.
//
//    Reverse the subarray containing the first d elements of the array.
//    Reverse the subarray containing the last (n - d) elements of the array.
//    Finally, reverse all the elements of the array.
    static void rotateArray2(int[] arr, int d, String direction) {
        int len = arr.length;

        d %= len;

        if (direction.equals("clockwise") && d != 0) {
            // Reverse entire array.
            reverseArray(arr, 0, len - 1);
            // Reverse the first d elements.
            reverseArray(arr, 0, d - 1);
            // Reverse the remaining len-k elements.
            reverseArray(arr, d, len - 1);
        } else if (direction.equals("counterclockwise") && d != 0) {
            // Reverse the first d elements.
            reverseArray(arr, 0, d - 1);
            // Reverse the remaining len-k elements.
            reverseArray(arr, d, len - 1);
            // Reverse entire array.
            reverseArray(arr, 0, len - 1);
        }
    }

    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int[] arr) {
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

        rotateArray(arr, d, "counterclockwise");
        printArray(arr);

        System.out.println();
        int[] arr2 = { 1, 2, 3 };
        d = 4;
        rotateArray2(arr2, d, "counterclockwise");
        printArray(arr2);

        System.out.println();
        int[] arr3 = { 1, 2, 3, 4, 5, 6 };
        d = 2;
        rotateArray(arr3, d, "clockwise");
        printArray(arr3);

        System.out.println();
        int[] arr4 = { 1, 2, 3, 4, 5, 6 };
        rotateArray2(arr4, d, "clockwise");
        printArray(arr4);
    }
}
