package hackerranktest.java;

import hackerrank.java.CompareSubstrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CompareSubstringsTest {
    @ParameterizedTest
    @CsvSource({
            "welcometojava, 3, ava wel",
            "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs, 30, ASDFHDSFHsdlfhsdlfLDFHSDLFHsdl sdlkfhsdlfhsLFDLSFHSDLFHsdkfhs"
    })
    void shouldCreateSmallestAndLargestSubstrings(
            String randomString, int substringLength, String expected) {

        CompareSubstrings compareSubstrings = new CompareSubstrings(
                randomString, substringLength);

        String actual = compareSubstrings.createSubstrings();

        Assertions.assertEquals(expected, actual);
    }
}
