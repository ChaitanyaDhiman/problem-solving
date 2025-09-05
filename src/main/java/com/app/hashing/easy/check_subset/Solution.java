package com.app.hashing.easy.check_subset;

import java.util.HashSet;
import java.util.Set;

public class Solution {
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
