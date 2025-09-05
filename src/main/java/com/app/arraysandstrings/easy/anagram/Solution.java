package com.app.arraysandstrings.easy.anagram;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    static public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    static public boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Populate the HashMap with character counts from str1
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Decrement character counts based on str2
        for (char c : str2.toCharArray()) {
            if(charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) - 1);
            } else {
                return false;
            }
        }

        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "anagram";

        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram2(str1, str2));
    }
}
