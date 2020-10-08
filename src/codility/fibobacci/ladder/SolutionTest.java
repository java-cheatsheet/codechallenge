package codility.fibobacci.ladder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        int[] A = new int[]{4,4,5,5,1};
        int[] B = new int[]{3,2,4,3,1};
        solution.solution(A, B);
    }

    @Test
    void main() {
    }
}