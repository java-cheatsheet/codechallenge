package google.Level2.Part1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.sort;

public class InitialSolutionTest {


    void verification() {
//        int[] A = {};
        int a = 1999999999;
        int[] maxInt = Integer.toString(Integer.MAX_VALUE).chars().map(c -> c-'0').toArray();
        System.out.println(Integer.MAX_VALUE);

//        int[] A = {3, 1, 4, 1, 5, 9};
//        94311
//        int a= 954311;
//        String sa= "954311";
//        int count=0;
//        int newInt = Integer.parseInt("16");
//        System.out.println(sa.charAt(0));

//        System.out.printf("count %d mod %d%n", count++, 954311 % 3);
//
//        System.out.printf("count %d mod %d%n", count++, 954311 % 3);
//        System.out.printf("count %d mod %d%n", count++, 954113 % 3);
//
//        System.out.printf("count %d mod %d%n", count++, 953411 % 3);
//        System.out.printf("count %d mod %d%n", count++, 953141 % 3);
//        System.out.printf("count %d mod %d%n", count++, 953114 % 3);

//        System.out.printf("count %d mod %d%n", count++, (9+4+3+1+1)%3);
//        System.out.printf("count %d mod %d%n", count++, 94312%3);
//        System.out.printf("count %d mod %d%n", count++, 49311%3);
//        System.out.printf("count %d mod %d%n", count++, 14391%3);
//        System.out.printf("count %d mod %d%n", count++, 11349%3);
    }

    @Test
    void seventyOne() {
        int[] A = {1,7};
        int want = 0;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
//        Assertions.assertEquals(0, 88765431%3);
    }

    @Test
    void strIsLessIntMax() {
        String sortedInt = "2147483647";
        boolean want = true;
        boolean got = InitialSolution.isNumMoreThanIntMax(sortedInt);
        Assertions.assertEquals(want, got);
//        Assertions.assertEquals(0, 88765431%3);
    }

    @Test
    void with023456788() {

        int[] A = {1,2,3,4,5,6,7,8,8};
        int want = 88765431;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
//        Assertions.assertEquals(0, 88765431%3);
    }

    @Test
    void with0001111() {

        int[] A = {0,0,0,0,1,1,1,1};
        int want = 1110000;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
//        Assertions.assertEquals(0, 1110000%3);
    }

    @Test
    void lessThan100() {
        for (int i=1; i<100; i++ ) {
            int want = i%3==0?i:0;
            int got = InitialSolution.solution(new int[]{i});
            Assertions.assertEquals(want, got);
        }
    }

    @Test
    void one() {
        int[] A = {1};
        int want = 0;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void tenNines() {
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        int want = 0;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void allZeros() {
        int[] A = {0,0,0,0,0};
        int want = 0;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void empty() {
        int[] A = {};
        int want = 0;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void oneToNine() {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int want = 987654321;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void allSameNum() {
        int[] A = {2,2,2,2,2,2,2};
        int want = 222222;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void sameFirstAndLastNumber() {
        int[] A = {4,4,4,4,4,4,4,4};
        int want = 444444;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void invalidOneNum() {
        int[] A = {4};
        int want = 0;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void validOneNum() {
        int[] A = {3};
        int want = 3;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void validTwoNums() {
        int[] A = {3, 7, 7};
        int want = 3;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void validNumAfterOne() {
        int[] A = {6, 8};
        int want = 6;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void sampleExampleOne() {
        int[] A = {3, 1, 4, 1};
        int want = 4311;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    @Test
    void sampleExampleTwo() {
        int[] A = {3, 1, 4, 1, 5, 9};
        int want = 94311;
        int got = InitialSolution.solution(A);
        Assertions.assertEquals(want, got);
    }

    void main() {
//        String actual = CaesarCipher.solution(result);
//        Assertions.assertEquals(expected, actual);

//        System.out.println(4311%3);

        int[] A = {3, 1, 4, 1, 5, 9};
        sort(A);
        String helloString = "123";
        System.out.println( helloString);

//        String[] strArr = {1", "2", "3"};
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            strBuilder.append(String.valueOf(A[i]));
        }
        String newString = strBuilder.toString();
        System.out.println(newString);

        System.out.println(Integer.parseInt(newString.substring(1,A.length))%3);


//        int[] intArray = { 1, 2, 3, 4, 5 };
//
//        String strArray[] = Arrays.stream(intArray)
//                .mapToObj(String::valueOf)
//                .toArray(String[]::new);
//        String A = Arrays.toString(strArray);
//
//        System.out.println(intArray[1]);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        int result = numbers
//                .stream()
//                .reduce(0, (subtotal, element) -> subtotal + element);
//        Assertions.assertEquals(result, 21);

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}