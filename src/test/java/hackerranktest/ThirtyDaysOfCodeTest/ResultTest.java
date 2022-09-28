package hackerranktest.ThirtyDaysOfCodeTest;

import hackerrank.thirtydaysofcode.TwentyNine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void checkBitwise() {
        int N = 5, K = 2, expected = 1;
        int N1 = 8, K1 = 5, expected1 = 4;
        int N2 = 2, K2 = 2, expected2 = 0;
        Assertions.assertEquals(expected, TwentyNine.bitwiseAnd(N, K));
        Assertions.assertEquals(expected1, TwentyNine.bitwiseAnd(N1, K1));
        Assertions.assertEquals(expected2, TwentyNine.bitwiseAnd(N2, K2));
    }

    @Test
    public static void given_binaryLiteral_thenReturnDecimalValue() {

        byte five = 0b101;
        Assertions.assertEquals((byte) 5, five);

        short three = 0b11;
        Assertions.assertEquals((short) 3, three);

        int nine = 0B1001;
        Assertions.assertEquals(9, nine);

        long twentyNine = 0B11101;
        Assertions.assertEquals(29, twentyNine);

        int minusThirtySeven = -0b100101;
        Assertions.assertEquals(-37, minusThirtySeven);

    }
}
