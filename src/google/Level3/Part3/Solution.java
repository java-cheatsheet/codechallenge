package google.Level3.Part3;

import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static int solution(String s) {
        BigInteger n = new BigInteger(s);

        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger zero = new BigInteger("0");

        if (n.compareTo(two) == -1) {
            return 0;
        }

//        if ( n.compare == 0 )
//            return 1;
//
//        if ( n == 1 )
//            return 0;

        int count = 0;

//        if ( n < 0 ) {
//            n *= -1;
//            count += 2;
//        }

        while (n.compareTo(one)) {
            count++;

            if((n & 1) == 0)
                n = n >> 1;
            else if((n==3) || ((n & 3)==1))
                n-=1;
            else
                n+=1;
        }
        return count;
    }
}


