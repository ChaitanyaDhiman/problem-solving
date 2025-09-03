package com.app.hashing.easy;

import java.util.HashMap;
import java.util.Map;

//  Fins frequency of element in an array.
//
//  Given an array of integers, the task is to find the frequency of num.
//
//  Examples:
//  Input: arr[] = [2, 6, 2, 9, 1, 5, 1], num = 6
//  Output: 1
//  Explanation:  The frequency of '6' is 1.
//
//  Input: arr[] = [1,1,1,2,2,3], num = 1
//  Output: 3
//  Explanation: The frequency of '1' is 3.
public class FindFrequencyInArray {

    static int findFrequency(int[] arr, int key) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        if(!map.containsKey(key)) return 0;

        return map.get(key);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

        System.out.println(findFrequency(arr, 1));
        System.out.println(findFrequency(arr, 9));
        System.out.println(findFrequency(arr, 2));
    }
}
