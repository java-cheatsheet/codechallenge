package google.Level3.Part3;

import java.math.BigInteger;
import java.util.*;

public class Solution {

    private static final BigInteger ONE= new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger ZERO= new BigInteger("0");
    private static final Map<BigInteger, Integer> cache = new HashMap<>(); // The storage

    public static int solution (String n) {
        cache.put(TWO, -1); // This special case can go directly into the storage
        return helper(new BigInteger(n));
    }

    public static int helper (BigInteger n) {
//        Integer cachedResult = cache.get(n);
//        if (cachedResult != null) { // A previously computed value exists, use it
//            return cachedResult;
//        }
//        Integer result;
        // Compute this result once
        if (n.mod(TWO).equals(ZERO)) {
            result = helper(n.divide(TWO)) + 1;
        } else {
            result = Math.min(helper(n.add(ONE).divide(TWO)) + 2, helper(n.subtract(ONE).divide(TWO)) + 2);
        }
        // Store the result for future use
//        cache.put(n, result);
        return result;
    }

    public static int solutions(String s) {
        BigInteger n = new BigInteger(s);
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger four = new BigInteger("4");
        int count = 0;

        while ( n.compareTo(one) > 0 ) {
            count++;

            if( n.and(one).byteValue() == 0 )
                n = n.divide(two);
            else if ( n.byteValue() == 3 || n.mod(four).byteValue() == 1)
                n = n.subtract(one);
            else
                n = n.add(one);
        }

        return count;
    }
}


