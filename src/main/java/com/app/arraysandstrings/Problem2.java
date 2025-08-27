package com.app.arraysandstrings;

import java.util.Arrays;

/*
Third-largest element in an array of distinct elements

Given an array of n integers, the task is to find the third-largest element. All the elements in the array are distinct integers.

Examples :

Input: arr[] = {1, 14, 2, 16, 10, 20}
Output: 14
Explanation: Largest element is 20, second-largest element is 16 and third-largest element is 14

Input: arr[] = {19, -10, 20, 14, 2, 16, 10}
Output: 16
Explanation: Largest element is 20, second-largest element is 19 and third-largest element is 16

*/
public class Problem2 {

//     Approach 1 : Using Sorting
//     Time complexity : O(nlog(n))
    public static int thirdLargestApproach1(int[] arr){
        int length = arr.length;

        Arrays.sort(arr);

        return arr[length - 3];
    }

//    Using Three Loops - O(n) time and O(1) space
//    The idea is to iterate the array twice and mark the maximum and second maximum element and
//    then excluding them both find the third maximum element, i.e., the maximum element excluding the maximum and second maximum.
//
//    Step-by-step approach:
//
//    - First, iterate through the array and find maximum.
//    - Store this as first maximum along with its index.
//    - Now traverse the whole array finding the second max, excluding the maximum element.
//    - Finally traverse the array the third time and find the third-largest element i.e., excluding the maximum and second maximum.
    public static int thirdLargestApproach2(int[] arr){

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i : arr){
            if (i > first){
                first = i;
            }
        }

        for (int i : arr){
            if(i > second && i < first ){
                second = i;
            }
        }

        for (int i : arr){
            if(i > third && i < second ){
                third = i;
            }
        }
        return third;
    }

//    Using Three variables - O(n) time and O(1) space
//    The idea is to traverse the array from start to end and to keep track of the three largest elements up to that index (stored in variables). So after traversing the whole array,
//    the variables would have stored the indices (or value) of the three largest elements of the array.
//
//    Step-by-step approach:
//
//    - Create three variables, first, second, third, to store indices of three largest elements of the array. (Initially all of them are initialized to a minimum value).
//    - Move along the input array from start to the end.
//    - For every index check if the element is larger than first or not. Update the value of first, if the element is larger,
//      and assign the value of first to second and second to third. So the largest element gets updated and the elements previously stored as largest becomes second largest,
//      and the second-largest element becomes third largest.
//    - Else if the element is larger than the second, then update the value of second, and the second-largest element becomes third largest.
//    - If the previous two conditions fail, but the element is larger than the third, then update the third.
    public static int thirdLargestApproach3(int[] arr){

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i : arr){
            if (i > first){
                third = second;
                second = first;
                first = i;
            }
            else if (i < first && i > second){
                third = second;
                second = i;
            }
            else if (i < second && i > third){
                third = i;
            }
        }
        return third;
    }

    public static void main(String[] args) {
        int[] arr = {1, 17, 3, 5, 9, 25, 12};

        System.out.println(thirdLargestApproach1(arr)); // Output : 12
        System.out.println(thirdLargestApproach2(arr)); // Output : 12
        System.out.println(thirdLargestApproach3(arr));
    }
}
