package google.Level3.Part3;

import google.Level3.Part3.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SolutionTest {

    @Test
    void cases() {
//        int a = 2147483647;
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

        HashMap<String,Integer> cases = new HashMap<String,Integer>();
        cases.put("4", 2);
        cases.put("15", 5);
//        cases.put("1", 0);
//        cases.put("0", 1);
//        cases.put("25", 6);
//        cases.put("70", 8);
//        cases.put("157", 10);
//        cases.put("113", 9);
//        cases.put("45", 8);

//        cases.put("-4", 4);
//        cases.put("-1", 2);
//        cases.put("-157", 12);


        for (Map.Entry<String,Integer> entry : cases.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

            Assertions.assertEquals(entry.getValue(),
                    Solution.solution(entry.getKey()));
        }
    }

}