package google.CaesarCipher;

import java.util.*;

/**
 * Problem:
 * Fortunately for you, the minions aren't exactly advanced cryptographers.
 * In their code, every lowercase letter [a..z] is replaced with the
 * corresponding one in [z..a], while every other character (including
 * uppercase letters and punctuation) is left untouched.  That is, 'a'
 * becomes 'z', 'b' becomes 'y', 'c' becomes 'x', etc.  For instance,
 * the word ""vmxibkgrlm"", when decoded, would become ""encryption""
 *
 * Note:
 * ASCII value a = 97, z= 122.
 * There are 26 letters in English alphabets `a` to `z`.
 *
 * Read the blog at https://codenit.com/google-foobar-first-codechallenge-caesar-cipher
 */
public class CaesarCipher {
    /**
     * Decrypt cipher text.
     *
     * Encryption is done with replacing small letters
     * a with z, b with y and so on...
     *
     * @param String cipher
     *
     * @return String
     */
    public static String solution(String cipher) {
        int cipherLen = cipher.length();
        char[] decryptedCharArr = new char[cipherLen];

        for (int i = 0; i < cipherLen; i++) {
            int character = cipher.charAt(i);

            if ( character >= 97 && character <= 122 )
                decryptedCharArr[i]  = (char) ( 'z' - ( ( character + 7) % 26 ));
            else
                decryptedCharArr[i] = (char)character;
        }

        return new String(decryptedCharArr);
    }

    /**
     * Solution submitted to Google.
     */
    public static String submittedSolution(String textToEncrypt) {
        StringBuilder result = new StringBuilder();

        for (char character : textToEncrypt.toCharArray()) {

            if ( (int)character >= 97 && (int)character <= 122 ) {
                int originalAlphabetPosition = character - 'z';
                int newAlphabetPosition = (originalAlphabetPosition + 25 ) % 26;
                result.append((char) ('z' - newAlphabetPosition));

            } else {
                result.append(character);
            }
        }

        return new String(result);
    }

    /**
     * Encrypt small letters `a` to `z` only in the text.
     *
     * @param String textToEncrypt
     *
     * @return String
     */
    public static String encrypt(String textToEncrypt) {
        StringBuilder result = new StringBuilder();

        for (char character : textToEncrypt.toCharArray()) {

            if ( (int)character >= 97 && (int)character <= 122 ) {
                int originalAlphabetPosition = character - 'z';
                int newAlphabetPosition = (originalAlphabetPosition + 25 ) % 26;
                result.append((char) ('z' - newAlphabetPosition));

            } else {
                result.append(character);
            }
        }

        return new String(result);
    }

    public static String solnWithArray(String encryptedText) {
        char[] encryptedCharArr = new char[encryptedText.length()];
        Map<Integer, Character> decryptKey = new HashMap<>();
        char encodedChar;

        for (int i = 122, j = 97; i >= 97; i--, j++) {
            encodedChar = (char) i;
            decryptKey.put(j, encodedChar);
        }

        for (int i = 0; i < encryptedText.length(); i++) {
            char ascii = encryptedText.charAt(i);

            if ( ascii >= 97 && ascii <= 122) {
                encryptedCharArr[i] = decryptKey.get((int)ascii);

            } else encryptedCharArr[i] = ascii;
        }

        return new String(encryptedCharArr);
    }

    public static String solnWithStrBuilder(String x) {
        StringBuilder stb = new StringBuilder();
        x.chars().forEach(i -> stb.append(decrypt(i)));
        return stb.toString();
    }

    /**
     * Decrypt small letters `a` to `z` only.
     *
     * First letter `a` is encrypted with the last
     * letter `z`, `b` with `y`, and so on.
     * ASCII values: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
     *
     * @param ascii int
     * @return decrypt char
     */
    public static char decrypt(int ascii) {
        if ( ascii >= 97 && ascii <= 122) {
            char encodedChar;
            Map<Integer, Character> decryptKey = new HashMap<>();
            for (int i = 122, j = 97; i >= 97; i--, j++) {
                encodedChar = (char) i;
                decryptKey.put(j, encodedChar);
            }
            // key.forEach((k,v) -> System.out.println(k + "=" + v));
            return decryptKey.get(ascii);
        }

        else return (char)ascii;
    }

}


