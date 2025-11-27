package com.app.streamingAPI.count_with_prefix;

import java.util.List;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Amanda");

        long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Number of names starting with 'A': " + count);
    }
}
