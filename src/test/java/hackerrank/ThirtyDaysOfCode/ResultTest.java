package hackerrank.ThirtyDaysOfCode;

import org.junit.Test;
import org.junit.Assert;

public class ResultTest {

    @Test
    void checkBitwise() {
        int N = 5, K = 2, expected = 1;
        int N1 = 8, K1 = 5, expected1 = 4;
        int N2 = 2, K2 = 2, expected2 = 0;
        Assert.assertEquals(expected, Result.bitwiseAnd(N, K));
        Assert.assertEquals(expected1, Result.bitwiseAnd(N1, K1));
        Assert.assertEquals(expected2, Result.bitwiseAnd(N2, K2));
    }

    @Test
    public static void given_binaryLiteral_thenReturnDecimalValue() {

        byte five = 0b101;
        Assert.assertEquals((byte) 5, five);

        short three = 0b11;
        Assert.assertEquals((short) 3, three);

        int nine = 0B1001;
        Assert.assertEquals(9, nine);

        long twentyNine = 0B11101;
        Assert.assertEquals(29, twentyNine);

        int minusThirtySeven = -0b100101;
        Assert.assertEquals(-37, minusThirtySeven);

    }
}
