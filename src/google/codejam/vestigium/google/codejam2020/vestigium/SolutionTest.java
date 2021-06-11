package google.codejam2020.vestigium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class SolutionTest {

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
        try {
            File obj = new File("src/google/codejam2020/vestigium/reversort_sample_ts1_input.txt");
            Scanner scanner = new Scanner(obj);
            String noOfInputs = scanner.nextLine();

            for( int i = 0 ; i <= Integer.parseInt(noOfInputs) ; i++) {
                int intLen = Integer.parseInt(scanner.nextLine());
                String inputString = scanner.nextLine();
                int[] numbers = Arrays.stream(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
                String result = String.format("Case #%d: %d", i+1, sort(numbers));
                System.out.println( result );
            }
            scanner.close();

        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch(Exception e) {
            System.err.println("File not found" + e.getMessage());
        }
    }

    public int sort(int [] a) {
        int n = a.length;
        int count=0;

        if ( n == 2 ) {
           return 1;
        }

        for (int i = 0; i < n-1; i++) {
            int min = i;
            int j = i+1;
            count += j-i+1;

            for (; j < n-1; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }

//        System.out.println(count);
        return count;
   }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(int v, int w) {
        return v < w ? true:false;
    }
}
