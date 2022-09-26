package googletest.Level3.Part3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;

public class SolutionTest {

    @Test
    void cases() {
        HashMap<String,Integer> cases = new HashMap<String,Integer>();
        cases.put("4", 2);
        cases.put("15", 5);
        cases.put("25", 6);
        cases.put("70", 8);
        cases.put("157", 10);
        cases.put("113", 9);
        cases.put("45", 8);
        cases.put("92233720368547758071", 69);
        cases.put("92233720368547758071922337203685477580719223372036854775807192233720368547758071", 350);

        // These cases are not considered as the Google test cases does not include them.
//        cases.put("1", 0);
//        cases.put("0", 1);
//        cases.put("-4", 4);
//        cases.put("-1", 2);
//        cases.put("-157", 12);

        for (Map.Entry<String,Integer> entry : cases.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

//            Assertions.assertEquals(entry.getValue(),
//                    Solution.solution(entry.getKey()));
        }
    }

}

class TrialTests {
    @Test
    void trial() {
//        if (n < 1)
//            return Integer.MIN_VALUE;
//        return 32 - Integer.numberOfLeadingZeros(n - 1);

//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);
        int no = 13;
        no = no >> 1;
        int xa = no;
//        no = no >> 1;
        if ((xa >> 1) == 1) {
            System.out.println(no);
            return;
        }

//        while ( true ) {
//            break;
//        }

//        var d = Integer.MAX_VALUE  + 2; // 2147483648
//        System.out.println(d);

// Check if the number is some power of two
// Returns  0 if the number is power of two.
        long x = 32;
        System.out.println((x & (x - 1)));
//        System.out.println(x!=0 && ((x&(x-1)) == 0));
        BigInteger bi1 = new BigInteger("32");
        System.out.println(bi1.and(bi1.subtract(BigInteger.ONE)));
//        With that check, the two numbers must be equal

// Find the power of two of the number.
//      This gives the max digit based on power of two.
//        System.out.println(Math.pow(2, Math.ceil(Math.log(x)/Math.log(2))));
//      This gives the maximum power of two that is needed to accomodate the number.
//        System.out.println(Math.ceil(Math.log(x)/Math.log(2)));

//        String s = "8";
        BigInteger n = new BigInteger(String.valueOf(x));

        System.out.println(n.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) < 0);

        BigDecimal bn = new BigDecimal(n);

        if (n.equals(n.and(n.subtract(BigInteger.ONE)))) {
//            Math.ceil(bn.() / Math.log(2));
        }


//                int a = 2147483647;
//        BigInteger bi = new BigInteger("11");
//        System.out.println(bi.toString(2));
//        System.out.println(bi.bitCount());
//        System.out.println(bi.getLowestSetBit());
//        System.out.println(bi.testBit(4));
//
//        try {
//            int nn = Integer.parseInt("2147483648");
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);
    }
}