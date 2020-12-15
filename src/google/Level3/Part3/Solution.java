package google.Level3.Part3;

import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static int solution(String s) {
        BigInteger n = new BigInteger(s);
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger four = new BigInteger("4");
        int count = 0;

        while (n.compareTo(one) == 1) {
            count++;

            if( n.and(one).byteValue() == 0 )
                n = n.divide(two);
            else if ( n.byteValue() == 3 || n.divide(BigInteger.THREE).byteValue() == 1)
                n = n.subtract(one);
            else
                n = n.add(one);
        }

        return count;
    }
}


