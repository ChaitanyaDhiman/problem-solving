package com.app.pattern_based.prefix_sum.range_sum_query;

public class Solution {

    private final int[] prefixSum;

    public Solution(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        this.prefixSum = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0) return prefixSum[right];

        return prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        Solution obj = new Solution(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
