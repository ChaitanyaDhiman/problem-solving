package com.app.arraysandstrings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

//  Find all pairs with a given sum
//  Difficulty: Easy
//  Given two unsorted arrays a[]  and b[], the task is to find all pairs whose sum equals x from both arrays.
//
//  Note: All pairs should be returned in increasing order of u. For example for two pairs (u1,v1) and (u2,v2),
//  if u1 < u2 then (u1,v1) should be returned first else second.
//
//  Examples:
//
//  Input: target = 9, a[] = [1, 2, 4, 5, 7], b[] = [5, 6, 3, 4, 8]
//  Output:
//          1 8
//          4 5
//          5 4
//  Explanation: (1, 8), (4, 5), (5, 4) are the pairs which sum to 9.
//  Input: target = 8, a[] = [-1, -2, 4, -6, 5, 7], b[] = [6, 3, 4, 0]
//  Output:
//          4 4
//          5 3
//  Input: target = 9, a[] = [1, 2, 4, 5, 7, 4], b[] = [5, 6, 3, 4, 8, 4]
//  Output:
//          1 8
//          4 5
//          4 5
//          5 4
//          5 4
//  Explanation: (1, 8), (4, 5), (4, 5), (5, 4) and (5, 4) are the pairs which sum to 9.

public class AllPair {
    long first;
    long second;

    public AllPair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AllPair allPair = (AllPair) o;
        return first == allPair.first && second == allPair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static AllPair[] allPairs(int target, int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<AllPair> arr = new ArrayList<>();

        Arrays.sort(arr1);

        for (int j : arr2) {
            map.put(j, map.getOrDefault(j, 0) + 1); // -> [(5,1), (6,1), (3,1), (4,2), (8,1)]
        }

        for (int i : arr1) {
            if (map.containsKey(target - i)) { // -> 8 > present
                int val = map.get(target - i); // -> 1 > value
                for (int j = 0; j < val; j++) { // loops 1 time
                    arr.add(new AllPair(i, target - i)); // -> adds [1, 8]
                }
            }
        }

        return arr.toArray(new AllPair[0]);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 5, 7, 4 }; // -> 1 2 4 4 5 7
        int[] arr2 = { 5, 6, 3, 4, 8, 4 };
        int target = 9;

        AllPair[] result = allPairs(target, arr1, arr2);
        for (AllPair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }
}
