package com.app.arraysandstrings.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllPairTest {

    @Test
    void testAllPairs_Example1() {
        assertArrayEquals(new AllPair[] { new AllPair(1, 8), new AllPair(4, 5), new AllPair(5, 4) },
                AllPair.allPairs(9, new int[] {1, 2, 4, 5, 7}, new int[] {5, 6, 3, 4, 8}));
        assertArrayEquals(new AllPair[] { new AllPair(4, 4), new AllPair(5, 3) },
                AllPair.allPairs(8, new int[] {-1, -2, 4, -6, 5, 7}, new int[] {6, 3, 4, 0}));
        assertArrayEquals(new AllPair[] { new AllPair(1, 8), new AllPair(4, 5), new AllPair(4, 5), new AllPair(5, 4), new AllPair(5, 4) },
                AllPair.allPairs(9, new int[] {1, 2, 4, 5, 7, 4}, new int[] {5, 6, 3, 4, 8, 4}));
    }
}