package hackerrank.Java;

import java.util.*;
import java.io.*;

/**
 * Problem:
 * Java's System.out.printf function can be used to print formatted output. The purpose of this exercise is to test your understanding of formatting output using printf.
 * To get you started, a portion of the solution is provided for you in the editor; you must format and print the input to complete the solution.
 *
 * Input Format
 * Every line of input will contain a String followed by an integer.
 * Each String will have a maximum of 10 alphabetic characters, and each integer will be in the inclusive range from 0 to 999.
 *
 * Output Format
 * In each line of output there should be two columns:
 * The first column contains the String and is left justified using exactly 15 characters.
 * The second column contains the integer, expressed in 3 exactly digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.
 *
 * Sample Input
 * java 100
 * cpp 65
 * python 50
 *
 * Sample Output
 * ================================
 * java           100
 * cpp            065
 * python         050
 * ================================
 *
 * Explanation
 * Each String is left-justified with trailing whitespace through the first 15 characters.
 * The leading digit of the integer is the 16th character, and each integer that was less
 * than 3 digits now has leading zeroes.
 *
 * Link: https://www.hackerrank.com/challenges/java-output-formatting
 */
public class OutputFormatting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            System.out.printf("%-15s%03d %n", s1, x);
        }
        System.out.println("================================");
    }
}

/**
 * NOTE:
 *
 * `System.out.printf( “format-string” [, arg1, arg2, ... ] );`
 *
 * Format String is composed of literals and format specifiers.
 * Arguments are required only if there are format specifiers
 * in the format string. Format specifiers include: flags, width,
 * precision, and conversion characters in the following sequence:
 *
 * ` % [flags] [width] [.precision] conversion-character ( square brackets denote optional parameters )`
 *
 * Flags:
 * `-` : left-justify ( default is to right-justify )
 * `+` : output a plus ( + ) or minus ( - ) sign for a numerical value
 * `0` : forces numerical values to be zero-padded ( default is blank padding )
 * `,` : comma grouping separator (for numbers > 1000)
 * `:` : space will display a minus sign if the number is negative or a space if it is positive
 *
 * Width:
 * Specifies the field width for outputting the argument
 * and represents the minimum number of characters to be
 * written to the output. Include space for expected commas
 * and a decimal point in the determination of the width
 * for numerical values.
 * Default print is left aligned.
 *
 * Precision: Used to restrict the output depending on the
 * conversion. It specifies the number of digits of precision
 * when outputting floating-point values or the length of a
 * substring to extract from a String. Numbers are rounded to
 * the specified precision.
 *
 * Conversion-Characters:
 * `d` : decimal integer [byte, short, int, long]
 * `f` : floating-point number [float, double]
 * `c` : character, Capital C will uppercase the letter
 * `s` : String, Capital S will uppercase all the letters in the string
 * `t` : Date/Time
 * `h` : hashcode, A hashcode is like an address. This is useful for printing  a reference
 * `n` : newline, Use %n
 *
 * Example:
 * ```
 * double dblTotal = 123456789.12345d;
 * System.out.printf("Total: %,16.3f:  %n", dblTotal);
 * ```
 * Output: `Total: 123,456,789.123`
 * The number of characters '123,456,789.123' is 15.
 * As the width is provided 16, it adds a space in
 * front of the number.
 * When the flag is set to `-`, space added at last.
 * `Total:123,456,789.123 `
 *
 * Other samples:
 *         double dblTotal = 123456789.123456;
 *         int intValue = 1;
 *         String stringVal = "Hello";
 *         System.out.printf("Total is: $%,.2f%n", dblTotal);
 *         System.out.printf("Total:%,-16.3f%n", dblTotal);
 *         System.out.printf("%d %n", intValue);
 *         System.out.printf("%-15s%03d", stringVal, intValue);
 *         String s = "Hello World";
 *         System.out.printf("The String object %-5s is at hash code %h %d", s, s, intValue);
 */
