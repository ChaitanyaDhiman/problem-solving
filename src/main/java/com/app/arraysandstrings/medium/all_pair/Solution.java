package com.app.arraysandstrings.medium.all_pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Solution {
    long first;
    long second;

    public Solution(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return first == solution.first && second == solution.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static Solution[] allPairs(int target, int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Solution> arr = new ArrayList<>();

        Arrays.sort(arr1);

        for (int j : arr2) {
            map.put(j, map.getOrDefault(j, 0) + 1); // -> [(5,1), (6,1), (3,1), (4,2), (8,1)]
        }

        for (int i : arr1) {
            if (map.containsKey(target - i)) { // -> 8 > present
                int val = map.get(target - i); // -> 1 > value
                for (int j = 0; j < val; j++) { // loops 1 time
                    arr.add(new Solution(i, target - i)); // -> adds [1, 8]
                }
            }
        }

        return arr.toArray(new Solution[0]);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 5, 7, 4 }; // -> 1 2 4 4 5 7
        int[] arr2 = { 5, 6, 3, 4, 8, 4 };
        int target = 9;

        Solution[] result = allPairs(target, arr1, arr2);
        for (Solution pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }
}
