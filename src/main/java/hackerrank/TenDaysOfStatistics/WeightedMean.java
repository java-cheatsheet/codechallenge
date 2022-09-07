package hackerrank.TenDaysOfStatistics;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WeightedMean {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] weight;
    private static int[] data;
    private static int totalNumbers;

    public static int[] getData() { return data;}
    public static int[] getWeight() { return weight;}
    public static int getTotalNumbers() { return totalNumbers;}

    public static void main(String[] args) {
//        calculateWeightedMeanCMDInput();
        testWithExampleData();
    }

    private static void testWithExampleData() {
        int[] data = {1, 3, 5};
        int[] weight = {2, 4, 6};
        int totalNumbers = 3;
        String weightedMean = "";
        weightedMean = printWeightedMean(data, weight, totalNumbers);
        System.out.println(weightedMean);
    }

    private static void calculateWeightedMeanCMDInput() {
        String weightedMean = "";
        try {
            readInputFromCMD();
            weightedMean = printWeightedMean(
                getData(),
                getWeight(),
                getTotalNumbers());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(weightedMean);

    }

    private static void readInputFromCMD() throws IOException {
        totalNumbers = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        data = new int[totalNumbers];
        weight = new int[totalNumbers];

        for (int i = 0; i <= totalNumbers - 1; i++)
            data[i] = scanner.nextInt();

        for (int i = 0; i <= totalNumbers - 1; i++)
            weight[i] = scanner.nextInt();

        scanner.close();

    }

    private static String printWeightedMean( int[] data, int[] weight, int totalNumbers ) {
        double totalWeightedMean = 0.0;
        int totalWeight = 0;
        for ( int i = 0 ; i < totalNumbers; i++ ){
            totalWeightedMean += ( data[i] * weight[i] );
            totalWeight += weight[i];
        }
        // When the return was a whole number, the answer expected
        // was X.0 i.e. 37.0, but it returned only 37 when pattern
        // was new DecimalFormat("#.#"). So it was changed to 0.0.
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(totalWeightedMean/totalWeight);
    }


}
