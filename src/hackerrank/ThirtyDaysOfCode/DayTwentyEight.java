package hackerrank.ThirtyDaysOfCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 *
 * Print an alphabetically-ordered list of first names
 * for every user with a gmail account. Each name must
 * be printed on a new line.
 *
 * Input
 * 6
 * riya riya@gmail.com
 * julia julia@julia.me
 * julia sjulia@gmail.com
 * julia julia@gmail.com
 * samantha samantha@gmail.com
 * tanya tanya@gmail.com
 *
 * Output
 * julia
 * julia
 * riya
 * samantha
 * tanya
 *
 * Algorithm:
 * Filter the inputs with gmail.
 * Sort by first name.
 * Print.
 */
public class DayTwentyEight {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> names= new LinkedList<>();

        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];

                if( isGmail(emailID))
                    names.add(firstName);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();

        Collections.sort(names);
        for (int i=0; i< names.size(); i++)
            System.out.println(names.get(i));

    }

    public static boolean isGmail(String emailAddress) {
        String expression = "^[\\w.+\\-]+@gmail\\.com$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

}
