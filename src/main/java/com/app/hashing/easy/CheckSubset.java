package com.app.hashing.easy;

import java.util.HashSet;
import java.util.Set;

//  Check if an array is subset of another array
//
//  Given two arrays a[] and b[] of size m and n respectively, the task is to determine whether b[] is a subset of a[]. Both arrays are not sorted, and elements are distinct.
//
//  Examples:
//
//  Input: a[] = [11, 1, 13, 21, 3, 7], b[] = [11, 3, 7, 1]
//  Output: true
//
//  Input: a[]= [1, 2, 3, 4, 5, 6], b = [1, 2, 4]
//  Output: true
//
//  Input: a[] = [10, 5, 2, 23, 19], b = [19, 5, 3]
//  Output: false
public class CheckSubset {
    static boolean isSubset(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();

        // add all elements of 'a' in set
        for(int i : a) set.add(i);

        // Check if elements of 'b' in the set
        for(int i : b) {
            if(!set.contains(i)) return false;
        }

        // If all elements of 'b' found in the set
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {1, 2, 3};

        System.out.println(isSubset(a, b));
    }
}
