package com.app.pattern_based.sliding_window.minimum_size_subarray_sum;

public class Solution {
    static int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while (total >= target) {
                result = Math.min(result, right - left + 1);
                total -= nums[left];
                left++;
            }
        }
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // output : 2
    }
}
