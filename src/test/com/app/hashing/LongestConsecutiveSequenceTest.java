package com.app.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutiveSequence() {
        assertEquals(0, LongestConsecutiveSequence.longestConsecutiveSequence(new int[]{}));
        assertEquals(1, LongestConsecutiveSequence.longestConsecutiveSequence(new int[]{1}));
        assertEquals(2, LongestConsecutiveSequence.longestConsecutiveSequence(new int[]{1, 2}));
        assertEquals(6, LongestConsecutiveSequence.longestConsecutiveSequence(new int[]{2, 6, 1, 9, 4, 5, 3}));
        assertEquals(3, LongestConsecutiveSequence.longestConsecutiveSequence(new int[]{1,1,1,2,2,3}));
    }
}