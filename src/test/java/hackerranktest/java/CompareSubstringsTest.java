package hackerranktest.java;

import hackerrank.Java.CompareSubstrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CompareSubstringsTest {
    @ParameterizedTest
    @CsvSource({
            "welcometojava, 3, ava wel",
            "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs, 30, ASDFHDSFHsdlfhsdlfLDFHSDLFHsdl sdlkfhsdlfhsLFDLSFHSDLFHsdkfhs"
    })
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(
            String s, int k, String expected) {

        CompareSubstrings compareSubstrings = new CompareSubstrings();
        String actual = compareSubstrings.getSmallestAndLargest(s, k);
        Assertions.assertEquals(expected, actual);
    }
}
