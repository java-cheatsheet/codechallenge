package hackerrank.String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/valid-username-checker/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 *
 * https://stackoverflow.com/questions/28392975/regex-to-match-a-username
 *
 * You are updating the username policy on your company's internal networking platform. According to the policy, a username is considered valid if all the following constraints are satisfied:
 *
 * The username consists of to characters inclusive. If the username consists of less than or greater than
 * characters, then it is an invalid username.
 * The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters
 * uppercase characters , and digits.
 * The first character of the username must be an alphabetic character, i.e., either lowercase character
 * or uppercase character.
 *
 *
 */
public class ValidUserNameRegEx {

    public static void main(String[] args) {
        /**
         * "(?=^.{8,30}$)^[a-zA-Z][a-zA-Z0-9_]*[a-zA-Z0-9]+$"
         * This regex was also accepted
         *
         */

        String regex = "(?=^.{8,30}$)^[a-zA-Z][a-zA-Z0-9]*[_]?[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            if (m.matches()) {
                // Prints the modified sentence.
                System.out.println("Valid");

            } else {
                System.out.println("Invalid");

            }


        }

        in.close();
    }
}
