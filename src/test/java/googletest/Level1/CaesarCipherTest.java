package googletest.Level1;

import google.Level1.CaesarCipher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CaesarCipherTest {

    String result = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
    String expected = "did you see last night's episode?";

    @Test
    void solution() {
        String actual = CaesarCipher.solution(result);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void submittedSolution() {
        String actual = CaesarCipher.submittedSolution(result);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void encrypt() {
        String expected = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
        String plainText = "did you see last night's episode?";
        result = CaesarCipher.encrypt(plainText);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void solnWithArray() {
        Assertions.assertEquals( expected, CaesarCipher.solnWithArray(result) );
    }

    @Test
    void solnWithStrBuilder() {
        Assertions.assertEquals(expected, CaesarCipher.solnWithArray(result) );
    }

    @Test
    void decrypt() {
        char expected = 'z';
        char result= 'a';
        Assertions.assertEquals( expected , CaesarCipher.decrypt(result) );
    }
}