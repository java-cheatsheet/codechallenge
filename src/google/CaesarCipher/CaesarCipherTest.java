package google.CaesarCipher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaesarCipherTest {

    String result = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
    String expected = "did you see last night's episode?";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

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