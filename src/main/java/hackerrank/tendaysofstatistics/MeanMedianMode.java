package hackerrank.tendaysofstatistics;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class MeanMedianMode {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        validGetModeTestSet1();
//        validGetModeTestSet2();
//        validGetModeExample();
//        validMeanExample();
//        validMedianExample();
//        int[] data = readInputCMD();
//        System.out.println(data);
        int[] data = {64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        printMeanModeMedian(data);
    }

    public static void validGetModeTestSet1() {
        int[] data = {1, 1, 2, 3};
        double expected = 1;
        double result = getMode( data, data.length );

        assert ( result == expected );
    }

    public static void validGetModeTestSet2() {
        int[] data = {1, 2, 3};
        double expected = 1;
        double result = getMode( data, data.length );

        assert ( result == expected );
    }

    public static void validModeExample() {
        int[] data = {64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        Arrays.sort(data);
        double expected = 4978;
        double result = getMode( data, data.length );

        assert ( result == expected );
    }

    public static void validMeanExample() {
        int[] data = {64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        Arrays.sort(data);
        double expected = 43900.6;
        double result = getMean( data, data.length );

        assert ( result == expected );
    }

    public static void validMedianExample() {
        int[] data = {64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        Arrays.sort(data);
        double expected = 44627.5;
        double result = getMedian( data, data.length );

        assert ( result == expected );
    }

    public static int[] readInputCMD() throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] data = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            data[i] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static void printMeanModeMedian( int[] data ) {
        int lenghtOfData =  data.length;
        Arrays.sort(data);

        double mean = getMean( data, lenghtOfData );
        double median = getMedian( data, lenghtOfData );
        double mode = getMode( data, lenghtOfData );

        printFormatted(mean);
        printFormatted(median);
        printFormatted(mode);
    }

    private static void printFormatted( double val ) {
        DecimalFormat df = new DecimalFormat("0.0");
        String strVal = String.valueOf(val);

        // When on "." is passed, it gives error as the split with
        // regex does not work. So need to escape the character.
        String[] splitValByDecimal = strVal.split("\\.");

        if ( Integer.parseInt(splitValByDecimal[1]) == 0 )
            System.out.println( splitValByDecimal[0]);
        else System.out.println(df.format(val));
    }

    private static Double getMean( int[] data, int lenghtOfData ){
        double sum = 0;
        int dataArrLen = lenghtOfData - 1;
        for( int i=0; i < lenghtOfData; i++ ) {
            sum +=  data[i];
        }
        return sum/lenghtOfData;

    }

    private static double getMedian( int[] data, int lengthOfData ){
        int maxIndex = 0;
        int minIndex = 0;

        // Get median index if length is ODD
        if ( lengthOfData / 2 == 0) maxIndex = (( lengthOfData + 1 ) / 2 )  - 1;
        else maxIndex = lengthOfData/2;

        minIndex =  maxIndex - 1;
        double median = (double)(data[minIndex] + data[maxIndex] ) / 2;
        return median;
    }

    private static double getMode( int[] data, int lenghtOfData ){
        int dataLen0Index = lenghtOfData - 1;
        int prev =  data[0];
        int count = 1;
        int tempCount = 1;
        for( int i = 0; i < dataLen0Index; i++ ) {

            if ( data[i] == data[ i + 1 ] ){
                tempCount++;
            } else {
                if (tempCount > count){
                    count =  tempCount;
                    prev = data[i];
                }
                tempCount = 1;
            }
        }

        return prev;
    }


}
