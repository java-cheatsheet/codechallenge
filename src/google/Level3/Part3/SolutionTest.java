package google.Level3.Part3;

import google.Level3.Part3.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SolutionTest {

    @Test
    void cases() {
        HashMap<String,Integer> cases = new HashMap<String,Integer>();
        cases.put("4", 2);
        cases.put("15", 5);
//        cases.put("1", 0);
//        cases.put("0", 1);
        cases.put("25", 6);
        cases.put("70", 8);
        cases.put("157", 10);
        cases.put("113", 9);
        cases.put("45", 8);

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