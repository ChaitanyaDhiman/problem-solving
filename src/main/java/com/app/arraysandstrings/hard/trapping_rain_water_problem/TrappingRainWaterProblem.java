package com.app.arraysandstrings.hard.trapping_rain_water_problem;

public class TrappingRainWaterProblem {

    public static int maxWater(int[] arr){
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int res = 0;

        // Fill left array
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        // Fill right array
        right[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }

        // Calculate the accumulated water element by element
        for (int i = 1; i < n - 1; i++) {
            int minOfTwo = Math.min(left[i], right[i]);
            res += minOfTwo - arr[i];
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater(arr));
    }
}
