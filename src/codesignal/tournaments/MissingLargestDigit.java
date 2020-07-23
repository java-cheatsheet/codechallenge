package codesignal.tournaments;

/**
 * Problem: Find the largest digit in the number.
 */
public class MissingLargestDigit {

    public static void main(String[] args) {
      maxDigit(132);
    }

    static int maxDigit(int n) {

        int result = 0;
        while (n != 0) {
            result = n % 10 > result ? n % 10 : result;
            n /= 10;
        }

        return result;
    }
}
