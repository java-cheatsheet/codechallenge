package leetcode.datastructure.containsduplicate.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    void shouldPassWithExample1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    @Test
    void shouldPassWithExample2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    @Test
    void shouldAssertFalseWithExample3() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    @Test
    void shouldAssertTrueWithTestCase48() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{313,64,612,515,412,661,244,164,492,744,233,579,62,786,342,817,838,396,230,79,570,702,124,727,586,542,919,372,187,626,869,923,103,932,368,891,411,125,724,287,575,326,88,125,746,117,363,8,881,441,542,653,211,180,620,175,747,276,832,772,165,733,574,186,778,586,601,165,422,956,357,134,857,114,450,64,494,679,495,205,859,136,477,879,940,139,903,689,954,335,859,78,20}, 22));
    }

    @Test
    void shouldAssertTrueWithTestCase21() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{1,2,1}, 2));
    }

    @Test
    void shouldAssertFalseWithTestCase22() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyDuplicate(new int[]{13,23,1,2,3}, 5));
    }

    @Test
    void shouldAssertFalseWithTestCase28() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyDuplicate(new int[]{0,1,2,3,4,5,0}, 5));
    }

    @Test
    void shouldAssertFalseWithTestCase47() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{99,99}, 2));
    }

    @Test
    void shouldAssertFalseWithTestCase48() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyDuplicate(new int[]{1}, 1));
    }

    @Test
    void shouldAssertTrueWithTestCase49() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8,9,9}, 3));
    }

    @Test
    void shouldAssertTrueWithTestCase50() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{1,2,2,3}, 3));
    }

    @Test
    void shouldAssertTrueWithTestCase18() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{2,2}, 3));
    }

    @Test
    void shouldAssertTrueWithTestCase19() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsNearbyDuplicate(new int[]{0,1,2,3,4,5,0}, 6));
    }

    @Test
    void shouldAssertFalseWithTestCase50() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsNearbyDuplicate(new int[]{1,2,3,1,1,2,3}, 0));
    }
}
