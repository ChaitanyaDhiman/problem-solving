package com.app.arraysandstrings.easy;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MaxProductOfTripletsInArrayTest {
    @Test
    public void testCases() {
        assertEquals(60, MaxProductOfTripletsInArray.maxProductOfThreeApproach1(new int[]{1, 2, 3, 4, 5}));
        assertEquals(60, MaxProductOfTripletsInArray.maxProductOfThreeApproach2(new int[]{1, 2, 3, 4, 5}));
        assertEquals(60, MaxProductOfTripletsInArray.maxProductOfThreeApproach3(new int[]{1, 2, 3, 4, 5}));
        assertEquals(Integer.MIN_VALUE, MaxProductOfTripletsInArray.maxProductOfThreeApproach1(new int[]{1, 2}));
        assertEquals(0, MaxProductOfTripletsInArray.maxProductOfThreeApproach2(new int[]{1, 2}));
        assertEquals(0, MaxProductOfTripletsInArray.maxProductOfThreeApproach3(new int[]{1, 2}));
        assertEquals(6, MaxProductOfTripletsInArray.maxProductOfThreeApproach1(new int[]{1, 2, 3}));
        assertEquals(6, MaxProductOfTripletsInArray.maxProductOfThreeApproach2(new int[]{1, 2, 3}));
        assertEquals(6, MaxProductOfTripletsInArray.maxProductOfThreeApproach3(new int[]{1, 2, 3}));

    }
}