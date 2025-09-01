package com.app.arraysandstrings.easy;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    // Using in-build functions
    public static char getFirstNonRepeatingChar(String s){

        if(s == null || s.isEmpty()) {
            return ' ';
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c)){
                return c;
            }
        }
        return ' ';
    }

    // Using HashMap
    public static char getFirstNonRepeatingChar2(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        // Populate the map with character frequencies
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if(map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s1 = "abbacbcded";
        String s2 = "abcde";
        String s3 = "aaabbee";

        System.out.println("Which is the first Non Repeating character in " + s1 + ": " + getFirstNonRepeatingChar(s1));
        System.out.println("Which is the first Non Repeating character in " + s2 + ": " + getFirstNonRepeatingChar2(s2));
        System.out.println("Which is the first Non Repeating character in " + s3 + ": " + getFirstNonRepeatingChar2(s3));
    }
}
