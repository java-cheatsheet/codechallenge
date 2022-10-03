package hackerranktest.java;

import hackerrank.java.StringToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *
 * Problem
 * https://www.hackerrank.com/challenges/java-string-tokens/
 *
 */
public class StringTokensTest {

    @Test
    void givenASentencePrintWithoutTokens() {
        String given =  "He is a very very good boy, isn't he?";
        String expected =  "Heisaveryverygoodboyisnthe";

        StringToken obj = new StringToken(given);
        String[] actualArr = obj.tokenFilter();
        String actual = String.join("", actualArr);

        Assertions.assertEquals(10, actualArr.length);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenAnEmptyStringPrintReturnEmptyString() {
        String given =  "";
        String expected =  "";

        StringToken obj = new StringToken(given);
        String[] actualArr = obj.tokenFilter();
        String actual = String.join("", actualArr);

        Assertions.assertEquals(0, actualArr.length);
        Assertions.assertEquals(expected, actual);
    }
}
