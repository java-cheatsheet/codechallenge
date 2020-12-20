package google.Level3.Part3;

import java.math.BigInteger;

public class Solution {

    public static int solution(String s) {
        BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger n = new BigInteger(s);
        int count = 0;

        while (n.compareTo(MAX_LONG) > 0) {
            int zeros = n.getLowestSetBit();

            if (zeros > 0) {
                n = n.shiftRight(zeros);
                count += zeros;
            } else {

                if (n.testBit(1))
                    n = n.add(BigInteger.ONE);
                else
                    n = n.subtract(BigInteger.ONE);
                count++;
            }
        }

        long lv = n.longValue();

        while ( lv > 3 ) {
            int zeros = Long.numberOfTrailingZeros(lv);

            if (zeros > 0) {
                lv >>= zeros;
                count += zeros;
            } else {

                if (lv % 4 == 1)
                    lv--;
                else
                    lv++;
                count++;
            }
        }

        if ( lv > 2 ) count += 2;
        else if ( lv > 1 ) count += 1;

        return count;
    }

}
