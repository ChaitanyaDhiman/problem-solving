package com.app.streamingAPI.sort_a_list;

import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
    public List<Integer> sortDescending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> numbers = List.of(5, 3, 8, 1, 2);
        List<Integer> sortedNumbers = solution.sortAscending(numbers);
        System.out.println("Sorted numbers in ascending order: " + sortedNumbers);

        List<Integer> reverseSorted = solution.sortDescending(numbers);
        System.out.println("Sorted numbers in descending order: " + reverseSorted);
    }
}
