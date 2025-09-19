package com.app.pattern_based.sliding_window.minimum_recolors_to_get_K_consecutive_black_blocks;

public class Solution {
    static public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W'){
                whiteCount++;
            }
        }

        int min_operations = whiteCount;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W'){
                whiteCount++;
            }

            if(blocks.charAt(i - k) == 'W'){
                whiteCount--;
            }

            min_operations = Math.min(min_operations, whiteCount);
        }

        return min_operations;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;

        System.out.println(minimumRecolors(blocks, k)); // Output: 3
    }
}
