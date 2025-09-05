package com.app.hashing.easy.find_frequency_in_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

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
