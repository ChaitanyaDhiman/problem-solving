package com.app.hashing.longest_consecutice_sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static public int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        // Hash all the array elements
        for (int num : nums) {
            set.add(num);
        }

        // Check each possible sequence from the start then update optimal length
        for (int num : nums) {
            // If current element is the starting element of a sequence
            if (set.contains(num) && !set.contains(num - 1)) {
                int curr = num, count = 0;
                while (set.contains(curr)) {
                    // Remove current to avoid re-computation.
                    set.remove(curr);
                    curr++;
                    count++;
                }

                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{1, 1, 2, 2, 3, 3, 4}));
    }
}
