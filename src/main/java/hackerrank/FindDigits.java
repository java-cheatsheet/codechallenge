package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDigits {

    public static void main(String[] args) {
        validTestCase1();
    }

    private static void validTestCase1() {
        int n = 1012;
        int expected = 3;
        int result = findDigits(n);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     * Thought process:
     * Make a char array from the input
     * Count the frequency of the numbers
     * Check if divisible or not
     * If divisible, add the frequency of the number to the total sum count
     * Return total sum count
     *
     * @param n
     * @return
     */
    static int findDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        Map<Integer, Integer> digitsCountMap = getFrequencyMapFromArray(digits);
        int countDivisorDigits = 0;
        for( Map.Entry<Integer, Integer> entry : digitsCountMap.entrySet()) {
            int digit = entry.getKey();

            if( digit > 0 )
                if( n % digit == 0 ) countDivisorDigits += entry.getValue();

        }

        return countDivisorDigits;
    }

    private static Map<Integer, Integer> getFrequencyMapFromArray(char[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(char key : arr){
            int digit = Character.getNumericValue(key);
            if(map.containsKey(digit)) map.put(digit, map.get(digit)+1);
            else map.put(digit, 1);
        }
        return map;
    }
}
