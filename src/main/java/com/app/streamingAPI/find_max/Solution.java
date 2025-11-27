package com.app.streamingAPI.find_max;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("Maximum number in the list: " + max);
    }
}
