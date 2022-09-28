package whiteboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Whiteboard {

    public static int tiktok(){
        int pairsCount=0;

//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
//        int k = 2;

        List<Integer> numbers = Arrays.asList(1,1,2,2,3,3,1);
        int k = 2;
        int output=6;

        List<Integer> listWithoutDuplicates = new ArrayList<>(
                new LinkedHashSet<>(numbers));
        Collections.sort(numbers);

        Hashtable<Integer, Integer> keyPairs
                = new Hashtable<Integer, Integer>();

        for(int i =0; i < numbers.size(); i++) {

            for(int j =i+1; j < numbers.size(); j++) {

                if (numbers.get(i) + k == numbers.get(j)){

                    if ( keyPairs.get(i) != numbers.get(i)) {
                        keyPairs.put(i, numbers.get(i));
                        pairsCount++;
                    }
                }
            }
        }

        return pairsCount;

    }
    public static void main(String[] args) {
        new Whiteboard().tiktok();
    }

    public int factorialRecursive(int n) {
        if ( n<0 ) return 0;

        if (n <= 1)
            return n;

        return factorialRecursive(n - 1) * n;
    }

    /**
     * Convert base10 number to base2.
     * Return maximum number of 1.
     *
     * @return int
     */
    public int findConsecutiveOnes(int number){
        if (number <= 1)
            return 0;

        String binaryString = Integer.toBinaryString(number);

        int count =0;
        int highestCount=0;
        char[] numChar =  binaryString.toCharArray();

        for ( int i=0; i<numChar.length; i++ ) {

            if ( (int)numChar[i] == 48 ) {
                if( count > highestCount )
                    highestCount = count;
                count = 0;
            } else count++;
        }

        return count>highestCount?count:highestCount;
    }

    public void maxHourGlassSum(){
        /**
         *
         * 2D 6*6 array
            1 1 1 0 0 0
            0 1 0 0 0 0
            1 1 1 0 0 0
            0 0 2 4 4 0
            0 0 0 2 0 0
            0 0 1 2 4 0

         contains below hour glasses
             1 1 1   1 1 0   1 0 0   0 0 0
               1       0       0       0
             1 1 1   1 1 0   1 0 0   0 0 0

             0 1 0   1 0 0   0 0 0   0 0 0
               1       1       0       0
             0 0 2   0 2 4   2 4 4   4 4 0

             1 1 1   1 1 0   1 0 0   0 0 0
               0       2       4       4
             0 0 0   0 0 2   0 2 0   2 0 0

             0 0 2   0 2 4   2 4 4   4 4 0
               0       0       2       0
             0 0 1   0 1 2   1 2 4   2 4 0

         Maximum sum hour glass is 19.
         2 4 4
           2
         1 2 4

         Hour Glass Creation
         First row, Thrid row, Skip first value for Second row
         Second row, Fourth row, Skip first value for Third row
         Third row, Fifth row, Skip first value for Fourth row
         Fourth row, Sixth row, Skip first value for Fifth row

         Only 4 rows and 4 columns can be used.
         For every middle row,

         take 3 elements, for top and bottom rows.
         take index+1 for middle row.
         **/
//        int rowSize = 6;
//        int colSize = 6;
//        int[][] myArray = new int[rowSize][colSize];
//
//        int count = 0;
//
//        for(int i = 0; i < rowSize; i++) {
//
//            for(int j = 0; j < colSize; j++, count++) {
//                myArray[i][j] = count;
//            }
//        }
//        for(int i = 0; i < rowSize; i++) {
//
//            // print the row of space-separated values
//            for(int j = 0; j < colSize; j++) {
//                System.out.print(myArray[i][j] + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

//        IntStream.range(0, 6).forEach(i -> {
//            try {
//                arr.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//                bufferedReader.close();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });

// Test case 0
//        List<Integer> row0 = List.of(1, 1, 1, 0, 0, 0);
//        List<Integer> row1 = List.of(0, 1, 0, 0, 0, 0);
//        List<Integer> row2 = List.of(1, 1, 1, 0, 0, 0);
//        List<Integer> row3 = List.of(0, 0, 2, 4, 4, 0);
//        List<Integer> row4 = List.of(0, 0, 0, 2, 0, 0);
//        List<Integer> row5 = List.of(0, 0, 1, 2, 4, 0);

// Failed test case 7
//        0 -4 -6 0 -7 -6
//        -1 -2 -6 -8 -3 -1
//        -8 -4 -2 -8 -8 -6
//        -3 -1 -2 -5 -7 -4
//        -3 -5 -3 -6 -6 -6
//        -3 -6 0 -8 -6 -7
//        Expected: -19

        List<Integer> row0 = List.of(0, -4, -6, 0, -7, -6);
        List<Integer> row1 = List.of(-1, -2, -6, -8, -3, -1);
        List<Integer> row2 = List.of(-8, -4, -2, -8, -8, -6);
        List<Integer> row3 = List.of(-3, -1, -2, -5, -7, -4);
        List<Integer> row4 = List.of(-3, -5, -3, -6, -6, -6);
        List<Integer> row5 = List.of(-3, -6, 0, -8, -6, -7);

        arr.add(row0);
        arr.add(row1);
        arr.add(row2);
        arr.add(row3);
        arr.add(row4);
        arr.add(row5);

        for(int i = 0; i < 6; i++) {
            // print the row of space-separated values
            for(int j = 0; j < 6; j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            // end of row is reached, print newline
            System.out.println();
        }
        System.out.println();

//        int max = 0;
//        for(int k=0; k<6; k++){
//            for (int l=0; l<6; l++){
////                int sum = 0;
//                for (int top=0; top<3; top++){
////                    sum+=arr.get(k).get(l);
//                    System.out.print(arr.get(k).get(l) + " ");
//                }
////                for (int m=0; m<3; m++){
//////                    sum+=arr.get(k).get(l);
////                    System.out.print(arr.get(k+1).get(l) + " ");
////                }
////                for (int bottom=0; bottom<3; bottom++){
//////                    sum+=arr.get(k).get(l);
////                    System.out.print(arr.get(k+2).get(l) + " ");
////                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        // get three values from top and bottom
        // get one value from second
        // there will be 16 hour glasses

//        for(int i = 0; i < 3; i++) {
//            // print the row of space-separated values
//            for(int j = 0; j < 3; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 1; i < 4; i++) {
//            // print the row of space-separated values
//            for(int j = 0; j < 3; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 2; i < 5; i++) {
//            // print the row of space-separated values
//            for(int j = 0; j < 3; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 3; i < 6; i++) {
//            // print the row of space-separated values
//            for(int j = 0; j < 3; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();

//        for(int i = 0; i < 3; i++) {
//            // print the row of space-separated values
//            for(int j = 1; j < 4; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 1; i < 4; i++) {
//            // print the row of space-separated values
//            for(int j = 1; j < 4; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 2; i < 5; i++) {
//            // print the row of space-separated values
//            for(int j = 1; j < 4; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 3; i < 6; i++) {
//            // print the row of space-separated values
//            for(int j = 1; j < 4; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();


//        for(int i = 0; i < 3; i++) {
//            // print the row of space-separated values
//            for(int j = 2; j < 5; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 1; i < 4; i++) {
//            // print the row of space-separated values
//            for(int j = 2; j < 5; j++) {
//                System.out.print(arr.get(i).get(j) + " ");
//            }
//            // end of row is reached, print newline
//            System.out.println();
//        }
        System.out.println(returnMax(arr));

    }
    public static int returnMax(List<List<Integer>> arr) {
//        int totalHourGlass = 1;
        int max = Integer.MIN_VALUE;
        for (int columnLoop = 0; columnLoop < 4; columnLoop++) {
            for (int rowLoop = 0; rowLoop < 4; rowLoop++) {
//                System.out.println("Hour Glass: "+totalHourGlass);
                int hourGlassSum = 0;
                // row loop
                // 03,14,25,36
                int midRow = 0;
                for(int i=rowLoop; i<rowLoop+3; i++ ) {
//                    System.out.println("i:" + i);
                    // column loop
                    // 03,14,25,36
                    if (midRow==0 || midRow ==2) {
                        for (int j = columnLoop; j < columnLoop + 3; j++) {
//                            System.out.print(arr.get(i).get(j) + " ");
                            hourGlassSum +=arr.get(i).get(j);
                        }
                    } else {
                        int midColumn = 0;
                        for (int j = columnLoop; j < columnLoop + 3; j++, midColumn++) {
                            if (midColumn == 1)
//                                System.out.print(arr.get(i).get(j) + " ");
                            hourGlassSum +=arr.get(i).get(j);
                        }
                    }
                    midRow++;
//                    System.out.println();
                }

                System.out.println("hourGlassSum " + hourGlassSum + " : max " + max);
                if (hourGlassSum > max) max=hourGlassSum;
//                totalHourGlass++;
            }
        }

        return max;
    }
    public char calculateAvg(int[] testScores) {
        int sum = 0; // initialize sum
        int len = testScores.length;
        int average = 0;

        for (int i = 0; i < len; i++)
            sum += testScores[i];

        average = sum/len;

        if (average > 89) return 'O';
        else if (average > 79) return 'E';
        else if (average > 69) return 'A';
        else if (average > 54) return 'P';
        else if (average > 39) return 'D';
        else return 'T';
    }
}

final class HashFunction {
    private final int[] frequency = new int[26];

    private int hashFunc(char c)
    {
        return ( c - 'a' );
    }

    public void countFre(String S) {
        for (int i = 0; i < S.length(); i++) {
            int index = hashFunc( S.charAt(i) );
            this.frequency[index]++;
        }

        for (int i = 0; i < 26; i++)
            System.out.printf( "Character %s count %d%n",
                    Character.toString((char) i + 97 ),
                    frequency[i] );

    }
}

final class Person {
    private int age;

    public Person(int initialAge) {
        // Add some more code to run some checks on initialAge
        if (initialAge<1) {
            System.out.println("Age is not valid, setting age to 0.");
            age = 0;

        } else age = initialAge;
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        if (age < 13)
            System.out.println("You are young.");
        else if ( age > 12 && age < 18 )
            System.out.println("You are a teenager.");
        else System.out.println("You are old.");
    }

    public void yearPasses() {
        // Increment this person's age.
        age++;
    }

    static void printAge() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }

    static void breakString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        for (int j=0; j < wordsCount; j++) {
            String s = bufferedReader.readLine().trim();
            StringBuilder oddS = new StringBuilder();
            StringBuilder evenS = new StringBuilder();
            evenS.append(s.charAt(0));

            for(int i=1; i< s.length(); i++) {

                if (i%2 == 0) evenS.append(s.charAt(i));
                else oddS.append(s.charAt(i));
            }

            System.out.println(evenS + " " + oddS);
        }
        bufferedReader.close();
    }


    public static void main(String[] args) {
        try {
            breakString();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Palindrome{
    public Stack<Character> stack;
    public Queue<Character> queue;
        // Write your code here.
    Palindrome(){
       stack = new Stack();
       queue = new LinkedList<>();
    }

    public void pushCharacter(char c){
        stack.push(c);
    }

    public void enqueueCharacter(char c) {
        queue.add(c);
    }

    public char popCharacter(){
        return stack.pop();
    }

    public char dequeueCharacter(){
        return queue.remove();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Palindrome p = new Palindrome();

        try {
            // Enqueue/Push all chars to their respective data structures:
            for (char c : s) {
                p.pushCharacter(c);
                p.enqueueCharacter(c);
            }

            // Pop/Dequeue the chars at the head of both data structures and compare them:
            boolean isPalindrome = true;
            for (int i = 0; i < s.length / 2; i++) {
                if (p.popCharacter() != p.dequeueCharacter()) {
                    isPalindrome = false;
                    break;
                }
            }

            //Finally, print whether string s is palindrome or not.
            System.out.println("The word, " + input + ", is "
                    + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
