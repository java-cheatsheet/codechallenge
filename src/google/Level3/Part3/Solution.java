package google.Level3.Part3;

import java.math.BigInteger;

public class Solution {

    public static int solution(String s) {

        BigInteger n = new BigInteger(s);
        if ( isPrimitive(n) ) {
            return longOps(0, n.longValue());
        }

        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger four = new BigInteger("4");
        int count = 0;

        while (n.compareTo(one) == 1) {
            count++;

            if( n.and(one).byteValue() == 0 ){
                n = n.shiftRight(1);

                if ( isPrimitive(n) )
                    return longOps(count, n.longValue());

            } else if ( n.byteValue() == 3 || n.mod(four).byteValue() == 1)
                n = n.subtract(one);
            else
                n = n.add(one);
        }

        return count;
    }


    public static int longOps(int count, long n) {

        while (n > 1) {
            count++;

            // If number is divisible by 2
            if ( (n & 1) == 0 )

                // Check if the number is power of two
                if ((n&(n-1)) == 0)
                    return (int)Math.ceil(Math.log(n)/Math.log(2)) + count - 1;
                else
                    n = n >> 1;// Binary Division

            else if ( n == 3 || n%4 == 1 )
                n--;
            else
                n++;
        }

        return count;
    }

    public static boolean isPrimitive(BigInteger n) {
        return n.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) < 0;
    }

}