package hackerranktest.java;

import hackerrank.java.Anagrams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * Problem
 * https://www.hackerrank.com/challenges/java-anagrams/problem
 *
 */
public class AnagramTest {

    @ParameterizedTest
    @CsvSource({
            "anagram, margana",
            "don, don",
            "Hello, hello"
    })
    void givenAllAnagramsShouldBeTrue(
            String first, String second) {

        Anagrams obj = new Anagrams(
                first, second);

        Assertions.assertTrue(obj.isAnagram());
    }

    @ParameterizedTest
    @CsvSource({
            "test, testt",
            "don, ddd"
    })
    void givenAllNotAnagramsShouldBeFalse(
            String first, String second) {

        Anagrams obj = new Anagrams(
                first, second);

        Assertions.assertFalse(obj.isAnagram());
    }
}
