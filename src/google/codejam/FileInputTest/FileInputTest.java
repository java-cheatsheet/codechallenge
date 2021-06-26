package google.codejam.FileInputTest;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileInputTest {

    @Test
    void testMe() {
        FileInputTest myObj = new FileInputTest();
        final boolean DEBUG = false;
        String DIR = "src/google/codejam/qualification_round_2021/reversort/";
        String inputFile = DIR + "test_data/test_set_1/ts1_input.txt";
        String outputFile = DIR + "test_data/output/ts1_output.txt";
        long beginTime = System.nanoTime();
        StringBuilder output = new StringBuilder();

        try {
            Scanner scanner = new Scanner(
                    new BufferedReader(new InputStreamReader(new FileInputStream(inputFile))));
        } catch(Exception e) {
            System.err.println(e.fillInStackTrace());
        }
    }

}
