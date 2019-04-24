package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// https://fizzbuzzer.com/sort-hotel-list-challenge/ TODO
/**
 *  Problem: TODO

 We have a lot of data from our customers,
 and we want to help new customers find the
 best hotels on our website.

 You must write a function that reads a list
 of hotel ids and scores from STDIN, and prints
 to STDOUT the hotel ids sorted in decreasing
 order of average of scores. If two hotels have
 the same average score, the hotel with the
 lower id will be printed first.

 You will notice that for the first of line of
 the input on STDIN contains an integer(N) that
 tells you how many more lines there are in the
 input. Each of the subsequent N lines contain
 two integers, which are a hotel id and a score
 respectively, separated by a space.

 Example:

 Sample Input:
 4
 1000 8
 2000 8
 2000 10
 1000 9

 Sample Output:
 2000
 1000

 *
 */
public class FindTheBestHotels {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashMap<Integer, Integer> hotelMap = new HashMap<>();

        for (int tItr = 0; tItr < t; tItr++) {
            int hotelId = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int  score = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            hotelMap.put(hotelId, score);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
