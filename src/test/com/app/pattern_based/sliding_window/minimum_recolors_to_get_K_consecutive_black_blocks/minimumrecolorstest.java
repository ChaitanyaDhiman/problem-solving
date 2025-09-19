package com.app.pattern_based.sliding_window.minimum_recolors_to_get_K_consecutive_black_blocks;

import org.junit.jupiter.api.Test;
import com.app.pattern_based.sliding_window.minimum_recolors_to_get_K_consecutive_black_blocks.Solution;
import static org.junit.jupiter.api.Assertions.*;

class minimumrecolorstest {

    @Test
    void minimumRecolors() {
        assertEquals(3, Solution.minimumRecolors("WBBWWBBWBW", 7));
    }
}