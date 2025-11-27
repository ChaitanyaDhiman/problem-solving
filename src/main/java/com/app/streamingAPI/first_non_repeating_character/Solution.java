package com.app.streamingAPI.first_non_repeating_character;

import java.util.Optional;

public class Solution {

    public char firstNonRepeatingCharacter(String str) {
        Optional<Character> fistNonRepeating = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst();

        return fistNonRepeating.orElse('_');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "swiss";

        System.out.println("First non-repeating character: " + solution.firstNonRepeatingCharacter(input));
    }
}
