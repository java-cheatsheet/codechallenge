package leetcode.datastructure.duplicate.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    void shouldPassWithExample1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }


}
