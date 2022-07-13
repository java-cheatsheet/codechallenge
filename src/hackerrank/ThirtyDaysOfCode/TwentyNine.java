package hackerrank.ThirtyDaysOfCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class TwentyNine {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int count = Integer.parseInt(firstMultipleInput[0]);

                int lim = Integer.parseInt(firstMultipleInput[1]);

                int res = Result.bitwiseAnd(count, lim);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
class Result {

    /*
     * Complete the 'bitwiseAnd' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER K
     */

    public static int bitwiseAnd(int N, int K) {
        int max = 0;

        for (int i=1; i<N+1; i++) {

            for (int j=i+1; j<N+1; j++){
                int andOp = i & j;

                if ( andOp < K && andOp > max )
                    max = andOp;
            }
        }

        return max;
    }

}



class ResultTest {

    @Test
    void checkBitwise() {
        int N = 5, K = 2, expected = 1;
        int N1 = 8, K1 = 5, expected1 = 4;
        int N2 = 2, K2 = 2, expected2 = 0;
        Assertions.assertEquals(expected, Result.bitwiseAnd(N,K));
        Assertions.assertEquals(expected1, Result.bitwiseAnd(N1,K1));
        Assertions.assertEquals(expected2, Result.bitwiseAnd(N2,K2));
    }

    @Test
    public void given_binaryLiteral_thenReturnDecimalValue() {

        byte five = 0b101;
        Assertions.assertEquals((byte) 5, five);

        short three = 0b11;
        Assertions.assertEquals((short) 3, three);

        int nine = 0B1001;
        Assertions.assertEquals(9, nine);

        long twentyNine = 0B11101;
        Assertions.assertEquals(29, twentyNine);

        int minusThirtySeven = -0b100101;
        Assertions.assertEquals(-37, minusThirtySeven);

    }
}
