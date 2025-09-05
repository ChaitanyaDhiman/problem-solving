package com.app.hashing;

import com.app.hashing.longest_consecutice_sequence.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutiveSequence() {
        assertEquals(0, Solution.longestConsecutiveSequence(new int[]{}));
        assertEquals(1, Solution.longestConsecutiveSequence(new int[]{1}));
        assertEquals(2, Solution.longestConsecutiveSequence(new int[]{1, 2}));
        assertEquals(6, Solution.longestConsecutiveSequence(new int[]{2, 6, 1, 9, 4, 5, 3}));
        assertEquals(3, Solution.longestConsecutiveSequence(new int[]{1,1,1,2,2,3}));
    }
}