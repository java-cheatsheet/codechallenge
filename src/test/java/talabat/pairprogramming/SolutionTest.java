package talabat.pairprogramming;

import org.junit.Test;
import org.junit.Assert;

public class SolutionTest {
    @Test
    void shouldFailWithNullOrEmpty() {
        Solution sol = new Solution();
        Assert.assertNotNull(sol.currentPosition());
    }

    @Test
    void shouldFailForStartingPoint() {
        Solution sol = new Solution();
        String initpos = "00N";
        Assert.assertEquals(initpos, sol.currentPosition());
    }



}
