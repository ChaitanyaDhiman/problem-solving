package com.app.arraysandstrings.easy.add_one_to_number_array;

public class Solution {

    static public int[] addOne(int[] arr) {
        int n = arr.length;

        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            carry = sum / 10;
            arr[i] = sum % 10;
        }
        if (carry > 0) {
            int[] newArr = new int[n + 1];
            newArr[0] = carry;
            System.arraycopy(arr, 0, newArr, 1, n);
            return newArr;
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] res = addOne(arr);

        for (int i : res){
            System.out.print(i);
        }

        System.out.println();
        int[] arr2 = {9,9,9};
        int[] res2 = addOne(arr2);

        for (int i : res2){
            System.out.print(i);
        }
    }
}
