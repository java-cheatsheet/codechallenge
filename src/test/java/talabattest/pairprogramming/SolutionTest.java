package talabattest.pairprogramming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import talabat.pairprogramming.Solution;

public class SolutionTest {
    @Test
    void shouldFailWithNullOrEmpty() {
        Solution sol = new Solution();
        Assertions.assertNotNull(sol.currentPosition());
    }

    @Test
    void shouldFailForStartingPoint() {
        Solution sol = new Solution();
        String initpos = "00N";
        Assertions.assertEquals(initpos, sol.currentPosition());
    }



}
