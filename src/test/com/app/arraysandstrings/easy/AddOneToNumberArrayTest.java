package com.app.arraysandstrings.easy;

import com.app.arraysandstrings.easy.add_one_to_number_array.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOneToNumberArrayTest {

    @Test
    void addOne() {
        assertArrayEquals(new int[]{1, 2, 4}, Solution.addOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, Solution.addOne(new int[]{9, 9, 9}));
        assertArrayEquals(new int[]{2}, Solution.addOne(new int[]{1}));
        assertArrayEquals(new int[]{0, 0, 1}, Solution.addOne(new int[]{0, 0, 0}));
        assertArrayEquals(new int[]{1}, Solution.addOne(new int[]{}));
    }
}