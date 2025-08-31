package com.app.arraysandstrings;

//      Move all Zeros to End of Array
//
//      Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.
//
//      Examples:
//      Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
//      Output: [1, 2, 4, 3, 5, 0, 0, 0]
//      Explanation: There are three 0s that are moved to the end.
//
//      Input: arr[] = [10, 20, 30]
//      Output: [10, 20, 30]
//      Explanation: No change in array as there are no 0s.
//
//      Input: arr[] = [0, 0]
//      Output: [0, 0]
//      Explanation: No change in array as there are all 0s.

public class Problem5 {

//    Using Temporary Array - O(n) Time and O(n) Space
//    The idea is to create a temporary array of same size as the input array arr[].
//
//    First, copy all non-zero elements from arr[] to the temporary array.
//    Then, fill all the remaining positions in temporary array with 0.
//    Finally, copy all the elements from temporary array to arr[].
    public static void moveZeroesToEndApproach1(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];

        int count = 0;

        for (int i : arr) {
            if (i != 0) {
                temp[count++] = i;
            }
        }

        while (count < length) {
            temp[count++] = 0;
        }

        System.arraycopy(temp, 0, arr, 0, length);
    }

//    Two Traversals
//    The idea is to move all the zeros by traversing the array twice.
//
//    First Traversal: Shift non-zero elements
//
//    Traverse the array and maintain the count of non-zero elements. This count is initialized with 0 and keeps track of where the next non-zero element should be placed in the array.
//    If the element is non-zero, place it at arr[count] and increment count by 1.
//    After traversing all the elements, all non-zero elements will be shifted to the front while maintaining their original order.
//    Second Traversal: Fill remaining positions with zeros
//
//    After the first traversal, all non-zero elements will be at the start of the array and count will store the index where the first zero should be placed.
//    Iterate from count to the end of array and fill all indices with 0.
    public static void moveZeroesToEndApproach2(int[] arr) {

        int count = 0;

        for (int i : arr) {
            if (i != 0) {
                arr[count++] = i;
            }
        }

        while (count < arr.length) {
            arr[count++] = 0;
        }
    }

//    One Traversal
//    The idea is similar to the previous approach where we took a pointer, say count to track where the next non-zero element should be placed.
//    However, on encountering a non-zero element, instead of directly placing the non-zero element at arr[count], we will swap the non-zero element with arr[count].
//    This will ensure that if there is any zero present at arr[count], it is pushed towards the end of array and is not overwritten.
    public static void moveZeroesToEndApproach3(int[] arr) {
        int count = 0;

        for (int i : arr) {
            if (i != 0) {
                int temp = i;
                i = arr[count];
                arr[count] = temp;

                count++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        moveZeroesToEndApproach1(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
        moveZeroesToEndApproach2(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
        moveZeroesToEndApproach3(arr);
        for (int j : arr){
            System.out.print(j + " ");
        }
    }

}
