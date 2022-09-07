package google.Level1;

import org.junit.Test;
import org.junit.Assert;

public class CaesarCipherTest {

    String result = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
    String expected = "did you see last night's episode?";

    @Test
    void solution() {
        String actual = CaesarCipher.solution(result);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void submittedSolution() {
        String actual = CaesarCipher.submittedSolution(result);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void encrypt() {
        String expected = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
        String plainText = "did you see last night's episode?";
        result = CaesarCipher.encrypt(plainText);
        Assert.assertEquals(expected, result);
    }

    @Test
    void solnWithArray() {
        Assert.assertEquals( expected, CaesarCipher.solnWithArray(result) );
    }

    @Test
    void solnWithStrBuilder() {
        Assert.assertEquals(expected, CaesarCipher.solnWithArray(result) );
    }

    @Test
    void decrypt() {
        char expected = 'z';
        char result= 'a';
        Assert.assertEquals( expected , CaesarCipher.decrypt(result) );
    }
}