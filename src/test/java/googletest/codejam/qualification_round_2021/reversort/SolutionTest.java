package googletest.codejam.qualification_round_2021.reversort;

import googletest.codejam.FileInputTest.FileInputTest;
import google.codejam.qualification_round_2021.reversort.Solution;
import org.junit.jupiter.api.Test;

import java.io.*;

public class SolutionTest {
    private final PrintStream originalOut = System.out;

    String result = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
    String expected = "did you see last night's episode?";

    @Test
    void testMain() {
        try {

            FileInputTest myObj = new FileInputTest();
            final boolean DEBUG = true;
            String dir = "src/google/codejam/qualification_round_2021/reversort/test_data/";
            String inputFile = dir + "test_set_1/ts1_input.txt";
            String outputFile = dir + "test_set_1/ts1_output.txt";
            String generatedOutputFile = dir + "output/ts1_output.txt";
            long beginTime = System.nanoTime();

            final InputStream original = System.in;
            final FileInputStream fips = new FileInputStream(inputFile);
            System.setIn(fips);
            Solution.main(null);
            System.setIn(original);


            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", "diff -q " + outputFile +" "+  generatedOutputFile);
            // Run a shell script
            //processBuilder.command("path/to/hello.sh");
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                System.out.println("Fail!");
                System.out.println(output);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
