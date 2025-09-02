package com.app.arraysandstrings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagram() {
        assertTrue(Anagram.isAnagram("a", "a"));
        assertFalse(Anagram.isAnagram("a", "b"));

    }

    @Test
    void isAnagram2() {
        assertTrue(Anagram.isAnagram2("", ""));
    }
}