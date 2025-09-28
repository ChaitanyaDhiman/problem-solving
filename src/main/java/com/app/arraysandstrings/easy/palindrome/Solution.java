package com.app.arraysandstrings.easy.palindrome;

public class Solution {
    public static boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    public static void main(String[] args) {
        String s = "racecar";
        String s2 = "hello";
        System.out.println(isPalindrome(s)); // Output: true
        System.out.println(isPalindrome(s2)); // Output: false
    }
}
