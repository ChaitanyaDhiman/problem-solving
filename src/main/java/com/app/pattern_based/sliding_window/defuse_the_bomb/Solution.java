package com.app.pattern_based.sliding_window.defuse_the_bomb;

public class Solution {
    /**
     * Decrypts a circular array based on the given key k.
     * - If k > 0: Replace each element with sum of next k elements
     * - If k < 0: Replace each element with sum of previous |k| elements
     * - If k = 0: Replace all elements with 0
     *
     * @param code The input circular array to decrypt
     * @param k The decryption key determining direction and count
     * @return The decrypted array
     */
    static int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];

        // If k is 0, return array filled with zeros
        if( k == 0) return result;

        // Process each element in the array
        for (int i = 0; i < length; i++){
            if (k > 0){
                // Sum the next k elements (circular)
                for(int j = 1; j <= k; j++){
                    int circularIndex = (i + j) % length;
                    result[i] += code[circularIndex];
                }
            } else {
                // Sum the previous |k| elements (circular)
                for(int j = k; j < 0; j++){
                    // Add arrayLength to handle negative indices correctly
                    int circularIndex = (i + j + length) % length;
                    result[i] += code[circularIndex];
                }
            }
        }

        return result;
    }

    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int[] result = decrypt(new int[]{5,7,1,4}, 3);
        printArray(result);

        System.out.println();
        int[] result2 = decrypt(new int[]{1,2,3,4}, 0);
        printArray(result2);

        System.out.println();
        int[] result3 = decrypt(new int[]{2,4,9,3}, -2);
        printArray(result3);

    }
}
