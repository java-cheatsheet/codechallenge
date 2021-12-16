package leetcode.datastructure.containsduplicate.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    void shouldPassWithExample1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyAlmostDuplicate(
                new int[]{1,2,3,1}, 3, 0));
    }

    @Test
    void shouldPassWithExample2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyAlmostDuplicate(
                new int[]{1,0,1,1}, 1, 2));
    }

    @Test
    void shouldFailWithExample3() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyAlmostDuplicate(
                new int[]{1,5,9,1,5,9}, 2, 3));
    }

    @Test
    void shouldFailEmptyArray() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyAlmostDuplicate(
                new int[]{}, 2, 3));
    }

    @Test
    void shouldFailSingeArrayElement() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyAlmostDuplicate(
                new int[]{1}, 2, 3));
    }

    @Test
    void shouldPassWithTestCase40() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyAlmostDuplicate(
                new int[]{1,2,5,6,7,2,4}, 4, 0));
    }

    @Test
    void shouldFailWithTestCase41() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyAlmostDuplicate(
                new int[]{-2147483648,2147483647}, 1, 1));
    }

    @Test
    void shouldPassWithTestCase47() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyAlmostDuplicate(
                new int[]{2147483646,2147483647}, 3, 3));
    }

    @Test
    void shouldFailWithTestCase47() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyAlmostDuplicate(
                new int[]{1,2}, 0, 1));
    }

    @Test
    void shouldPassWithTestCase49() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyAlmostDuplicate(
                new int[]{4,1,6,3}, 100, 1));
    }
}
