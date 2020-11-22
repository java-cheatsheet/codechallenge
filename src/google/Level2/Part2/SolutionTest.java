package google.Level2.Part2;

import google.Level2.Part1.SecondSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    void x9y9() {
        long x = 9;
        long y = 9;
        String want = "145";
        String got = Solution.solution(x,y);
        Assertions.assertEquals(want, got);
    }

    @Test
    void x5y6() {
        long x = 5;
        long y = 6;
        String want = "50";
        String got = Solution.solution(x,y);
        Assertions.assertEquals(want, got);
    }

    @Test
    void x13y1() {
        long x = 13;
        long y = 1;
        String want = "91";
        String got = Solution.solution(x,y);
        Assertions.assertEquals(want, got);
    }
}

class SumOfYTest {
    @Test
    void WhenX5Y8() {
        long x = 5;
        long y = 8;
        long want = 56;
        long got = Solution.yColSum(x,y);
        Assertions.assertEquals(want, got);
    }
    @Test
    void WhenX14Y15() {
        long x = 14;
        long y = 14;
        long want = 260;
        long got = Solution.yColSum(x,y);
        Assertions.assertEquals(want, got);
    }

    @Test
    void WhenX5Y5() {
        long x = 5;
        long y = 4;
        long want = 18;
        long got = Solution.yColSum(x,y);
        Assertions.assertEquals(want, got);
    }
}

class StartOfXTest {
    @Test
    void WhenXEq5() {
        long x = 5;
        long want = 15;
        long got = Solution.getStartX(x);
        Assertions.assertEquals(want, got);
    }

    @Test
    void WhenXEq12() {
        long x = 12;
        long want = 78;
        long got = Solution.getStartX(x);
        Assertions.assertEquals(want, got);
    }
}