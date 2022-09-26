package googletest.Level2.Part1;

import google.Level2.Part1.SecondSolution;
import google.Level2.Part1.Solution;
import google.Level2.Part1.Thirdparty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SolutionTest {

    @Test
    void sampleExampleOne() {
        int[] A = {0, 3, 1, 4, 1,0,0};
        int want = 4311000;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void sampleExampleTwo() {
        int[] A = {3, 1, 4, 1, 5, 9};//191443=22%3=1
        int want = 94311;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void sampleExampleOneWithZero() {
        int[] A = {3, 1, 4, 1, 0};
        int want = 43110;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void sampleExampleOneWithTwoZero() {
        int[] A = {0, 3, 1, 4, 1, 0};
        int want = 431100;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void validTwoNums() {
        int[] A = {3, 7, 7};
        int want = 3;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void validNumAfterOne() {
        int[] A = {6, 8};
        int want = 6;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void oneZero() {
        int[] A = {1,2,3,0,0,0,0,0,0};
        int want = 321000000;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void oneToNine() {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int want = 987654321;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void allSameNum() {
        int[] A = {2,2,2,2,2,2,2};
        int want = 222222;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void allOne() {
        int[] A = {1,1,1,1,1,1,1};
        int want = 111111;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void nineteen() {
        int[] A = {1,9};
        int want = 9;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void twoFives() {
        int[] A = {5,5};
        int want = 0;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void fourFives() {
        int[] A = {5,5,5,5};
        int want = 555;
        int got = Thirdparty.solution(A);
        Assertions.assertEquals(want, got);
    }

    // No need to check for this case.
    // A.length < 10
    void maxInteger() {
        int[] A = {2,0,4,7,4,8,3,6,4,7};
        int want = 0;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    // No need to check for this case.
    // A.length < 10
    void twelve9() {
        int[] A = {9,9,9,9,9,9,9,9,9,9,9,9};
        int want = 555;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void oneHundred() {
        int[] A = {1,0,0,};
        int want = 0;
        int got = Solution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void verification() {
        int oneMax = 199999999;
        int twoMax = Integer.MAX_VALUE; // 2147483647
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE%3);
//        System.out.println(1%3);
//        System.out.println(2%3);
////        System.out.println(71%3);
//        System.out.println((9988)%3);
//        System.out.println((9+9+8+8)%3);
//        System.out.println((98)%3);

//        System.out.println((666666666)%3);
//        System.out.println((66666666)%3);
//        System.out.println((6666)%3);

//        System.out.println((366966669)%3);
//
//        System.out.println((1111)%3);
//        System.out.println((11111)%3);
//        System.out.println((1111111)%3);

//        System.out.println((4444)%3);
//        System.out.println((44444)%3);
//
//        System.out.println((74)%3);

//        System.out.println(111111112%3);
//        System.out.printf("count %d mod %d%n", count++, 11349%3);

//        System.out.println((7483647)%3);
    }

}


class CountModTest {
    @Test
    void sampleExampleOneMod() {
        int[] A = {3, 1, 4, 1};
        int[] want = {0,2,0,1,1,0,0,0,0,0,0};
        int[] got = SecondSolution.countMod(A);
        Assertions.assertEquals(want[10], got[10]);
        Assertions.assertEquals(want[1], got[1]);
    }
}

class BuildNum {
    @Test
    void sampleExampleOneMod() {
        int[] A = {1,2,3};
        int want = 321;
        int got = Solution.buildNum(A, -1, -1);
        Assertions.assertEquals(want, got);
    }
}

class BuildLargeNum {
    @Test
    void sampleExampleOneMod() {
        int[] A = {3, 1, 4, 1};
        int want = 4311;
        int got = SecondSolution.buildLargeNum(SecondSolution.countMod(A));
        Assertions.assertEquals(want, got);
    }
}

class UpdateCount {
    @Test
    void sampleExampleOneUpdate() {
        int[] A = {1, 9};
        int[]countMod = SecondSolution.countMod(A);
        boolean want = true;
        boolean got = SecondSolution.updateCount(countMod);
        Assertions.assertEquals(want, got);
        Assertions.assertEquals(0, countMod[1]);
    }
}