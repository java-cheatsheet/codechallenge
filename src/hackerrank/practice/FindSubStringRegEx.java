package hackerrank.practice;

import java.util.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindSubStringRegEx {


    private Scanner scanner = new Scanner(System.in);
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private List<String> linesOfSentences = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        new FindSubStringRegEx().readLineWithBufferedReader();
//        new FindSubStringRegEx().findSubStringRegEx();
//        String result = new FindSubStringRegEx().checkNumberExists();
//        System.out.println(result);
//        new FindSubStringRegEx().checkPalindrome();
    }

    public void findSubStringRegEx() {
        //read int for number of lines of sentences
        //read strings each sentences as defined
        //read int for number of words to search for i nthe string
        //read string for each word.
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        List<String> inputLines = new ArrayList<>();
        int numOfSentences, numOfWords = 0;

        try {
            while ((inputLine = bufferedReader.readLine()) != null
                    && inputLine.length() != 0) {

                inputLines.add(inputLine);
            }

            int lenOfInput = inputLines.size() - 1;
            numOfSentences = Integer.parseInt(inputLines.get(0));
            numOfWords =  Integer.parseInt(inputLines.get(numOfSentences + 1));
            int startingIndexOfWords = numOfSentences + 2;

            HashMap<String, Integer> repetedWord = new HashMap<>();

            for( int i = 0;  i < numOfWords; i++ ) {
                int numOfSentencesToSearch = numOfSentences;
                int matchWord = 0;
                String wordToSearch = inputLines.get(startingIndexOfWords);

                while ( numOfSentencesToSearch > 0) {
                    int startingIndexOfSentence = 1;
                    String sentence = inputLines.get(startingIndexOfSentence);
                    Pattern pattern =
                            java.util.regex.Pattern.compile("[\\w]" + wordToSearch + "[\\w]",
                                    java.util.regex.Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(sentence);

                    while (matcher.find())
                        repetedWord.put(wordToSearch, ++matchWord);

                    numOfSentencesToSearch--;
                    startingIndexOfSentence++;

                }
                startingIndexOfWords++;
            }

            repetedWord.forEach((key,value) -> System.out.println(key + " = " + value));

        } catch (Exception e) {
            //Log ExceptionSystem.out.println("Exception " + e.getMessage());
        }


    }


    public void readLineWithBufferedReader() {
        String line;
        String[] input = new String[0];
        try {
            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                input = line.split(" ");

//            if (input.length == 1) {
                String sentence = String.join(" ", input);
                System.out.println(sentence);
//            }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }

    public void readLineWithScanner() {
        String s = scanner.nextLine();
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);

        while (st != null && st.hasMoreElements()) {
            tokens.add(st.nextToken());
        }

        int i = scanner.nextInt();
        Double d = scanner.nextDouble();
        System.out.println("String: " + tokens.toString());
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        scanner.close();
    }

    public String checkNumberExists() {
        int k = 3;
        List<Integer> arr = new ArrayList<>();//{1, 2, 4, 6, 7}
        arr.add(5);arr.add(31);arr.add(13);arr.add(1);arr.add(43);

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == k) {
                 return "Yes";
            }
        }
        return "No";
    }

    public void checkPalindrome() {
        String strToCheck = "sracecars";//"madam";//"meem";
        int lenOfStr = strToCheck.length();
        int midPoint = lenOfStr/2;
        int lastIndex = lenOfStr - 1;
        boolean isPalindrome = true;

        for(int i=0 ; i < midPoint; i++, lastIndex--) {
            char firstChar = strToCheck.charAt(i);
            char lastChar  = strToCheck.charAt(lastIndex);

            if( firstChar != lastChar )
                isPalindrome = false;
        }

        System.out.println(isPalindrome);
    }


}
