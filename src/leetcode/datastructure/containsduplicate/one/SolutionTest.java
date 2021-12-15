package leetcode.datastructure.containsduplicate.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    void shouldPassWithExample1() {
        Solution duplicate = new Solution();
        Assertions.assertTrue(duplicate.containsDuplicate( new int[]{1, 2, 3, 1}));
    }

    @Test
    void shouldFailWithExample2() {
        Solution duplicate = new Solution();
        Assertions.assertFalse(duplicate.containsDuplicate( new int[]{4, 2, 3, 1}));
    }

    @Test
    void shouldPassWithExample3() {
        Solution duplicate = new Solution();
        Assertions.assertTrue(duplicate.containsDuplicate( new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

}