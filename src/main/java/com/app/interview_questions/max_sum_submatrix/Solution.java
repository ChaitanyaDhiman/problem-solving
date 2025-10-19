package com.app.interview_questions.max_sum_submatrix;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int bestSum = Integer.MIN_VALUE;
        int bestArea = Integer.MAX_VALUE;
        int bestRowStart = Integer.MAX_VALUE;
        int bestColStart = Integer.MAX_VALUE;

        for (int top = 0; top < rows; top++) {
            int[] temp = new int[cols];

            for (int bottom = top; bottom < rows; bottom++) {
                for (int c = 0; c < cols; c++) {
                    temp[c] += matrix[bottom][c];
                }

                KadeaneResult result = kadean(temp);
                int currentSum = result.sum;
                int currentArea = (bottom - top + 1) * (result.end - result.start + 1);
                int currentRowStart = top;
                int currentColStart = result.start;

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestArea = currentArea;
                    bestRowStart = currentRowStart;
                    bestColStart = currentColStart;
                } else if (currentSum == bestSum) {
                    if (currentArea < bestArea ) {
                        bestArea = currentArea;
                        bestRowStart = currentRowStart;
                        bestColStart = currentColStart;
                    } else if ( currentArea == bestArea ) {
                        if (currentRowStart < bestRowStart) {
                            bestRowStart = currentRowStart;
                            bestColStart = currentColStart;
                        } else if (currentRowStart == bestRowStart) {
                            if (currentColStart < bestColStart) {
                                bestColStart = currentColStart;
                            }
                        }
                    }
                }
            }
        }
        return bestSum;
    }

    private KadeaneResult kadean(int[] arr) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentStart = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = currentStart;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
        }
        return new KadeaneResult(maxSum, start, end);
    }

    private static class KadeaneResult {
        int sum;
        int start;
        int end;

        KadeaneResult(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, -1},
                {-3, 4, 5},
                {2, -1, -2}
        };
        int result = solution.maxSumSubmatrix(matrix);
        System.out.println("Max Sum Submatrix: " + result); // Expected output: 10
    }

}
