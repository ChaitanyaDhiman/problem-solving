package com.app.arraysandstrings.easy.palindrome;

public class Solution {
    public static boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    public static boolean isPalindrome2(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        return s.equals(reverse);
    }

    public static boolean isPalindrome3(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "racecar";
        String s2 = "hello";
        System.out.println(isPalindrome(s)); // Output: true
        System.out.println(isPalindrome(s2)); // Output: false
        System.out.println(isPalindrome2(s)); // Output: true
        System.out.println(isPalindrome2(s2)); // Output: false
        System.out.println(isPalindrome3(s)); // Output: true
        System.out.println(isPalindrome3(s2)); // Output: false
    }
}
