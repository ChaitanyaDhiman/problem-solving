package com.app.hashing;

import java.util.HashSet;
import java.util.Set;

//  Longest Consecutive Subsequence
//
//  Given an array of integers, the task is to find the length of the longest subsequence such that elements in the subsequence are consecutive integers,
//  the consecutive numbers can be in any order.
//
//  Examples:
//  Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
//  Output: 6
//  Explanation:  The longest consecutive subsequence [2, 6, 1, 4, 5, 3].
//
//  Input: arr[] = [1,1,1,2,2,3]
//  Output: 3
//  Explanation: The subsequence [1, 2,3] is the longest subsequence of consecutive elements
public class LongestConsecutiveSequence {
    static int longestConsecutiveSequence(int[] nums) {
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
