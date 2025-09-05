package com.app.arraysandstrings.easy;

import com.app.arraysandstrings.easy.anagram.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagram() {
        assertTrue(Solution.isAnagram("a", "a"));
        assertFalse(Solution.isAnagram("a", "b"));

    }

    @Test
    void isAnagram2() {
        assertTrue(Solution.isAnagram2("", ""));
    }
}