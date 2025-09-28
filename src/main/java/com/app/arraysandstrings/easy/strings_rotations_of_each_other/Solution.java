package com.app.arraysandstrings.easy.strings_rotations_of_each_other;

public class Solution {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // Concatenate s1 with itself, it generated all the possible rotations of s1.
        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }

    public static boolean isRotation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int len = s1.length();

        for (int i = 0; i < len; i++) {
            if(s1.equals(s2)) {
                return true;
            }

            char last = s1.charAt(len - 1);
            s1 = last + s1.substring(0, len - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2)); // Output: true
        System.out.println(isRotation2(s1, s2)); // Output: true
    }
}
