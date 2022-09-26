package codilitytest.fibobacci.ladder;

import codility.fibobacci.ladder.Solution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SolutionTest {
    @Test
    void test() {
        int[] A = new int[]{4,4,5,5,1};
        int[] B = new int[]{3,2,4,3,1};
        int[] expected = {5,1,8,0,1};
        int[] actual = Solution.solution(A, B);

        Assertions.assertArrayEquals(expected, actual);
    }
}