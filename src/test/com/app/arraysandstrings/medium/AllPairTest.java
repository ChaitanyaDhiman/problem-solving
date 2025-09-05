package com.app.arraysandstrings.medium;

import com.app.arraysandstrings.medium.all_pair.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllPairTest {

    @Test
    void testAllPairs_Example1() {
        assertArrayEquals(new Solution[] { new Solution(1, 8), new Solution(4, 5), new Solution(5, 4) },
                Solution.allPairs(9, new int[] {1, 2, 4, 5, 7}, new int[] {5, 6, 3, 4, 8}));
        assertArrayEquals(new Solution[] { new Solution(4, 4), new Solution(5, 3) },
                Solution.allPairs(8, new int[] {-1, -2, 4, -6, 5, 7}, new int[] {6, 3, 4, 0}));
        assertArrayEquals(new Solution[] { new Solution(1, 8), new Solution(4, 5), new Solution(4, 5), new Solution(5, 4), new Solution(5, 4) },
                Solution.allPairs(9, new int[] {1, 2, 4, 5, 7, 4}, new int[] {5, 6, 3, 4, 8, 4}));
    }
}