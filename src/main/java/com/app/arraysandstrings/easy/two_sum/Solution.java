package com.app.arraysandstrings.easy.two_sum;


public class Solution {
    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        for (int i : result)
            System.out.print(i + " ");
    }
}
