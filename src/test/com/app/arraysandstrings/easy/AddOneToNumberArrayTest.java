package com.app.arraysandstrings.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddOneToNumberArrayTest {

    @Test
    void addOne() {
        assertArrayEquals(new int[]{1, 2, 4}, AddOneToNumberArray.addOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, AddOneToNumberArray.addOne(new int[]{9, 9, 9}));
        assertArrayEquals(new int[]{2}, AddOneToNumberArray.addOne(new int[]{1}));
        assertArrayEquals(new int[]{0, 0, 1}, AddOneToNumberArray.addOne(new int[]{0, 0, 0}));
        assertArrayEquals(new int[]{1}, AddOneToNumberArray.addOne(new int[]{}));
    }
}