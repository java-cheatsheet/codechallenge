import edu.princeton.cs.algs4.In;

import java.util.*;


//public class ReadmeAS {
//    interface BaseI { void method(); }
//
//
//
//    /**
//     * Problem:
//     * Fortunately for you, the minions aren't exactly advanced cryptographers.
//     * In their code, every lowercase letter [a..z] is replaced with the
//     * corresponding one in [z..a], while every other character (including
//     * uppercase letters and punctuation) is left untouched.  That is, 'a'
//     * becomes 'z', 'b' becomes 'y', 'c' becomes 'x', etc.  For instance,
//     * the word ""vmxibkgrlm"", when decoded, would become ""encryption""
//     *
//     * a b c d e
//     *
//     */
//    static public void googleEnc() {
//        // https://stackoverflow.com/questions/31888001/character-getnumericvalue-in-java-returns-same-number-for-upper-and-lower-ca
////        System.out.println((int)'a');
////        char ch = 'a';
////        char ch2 = 'z';
////        char chA = 'A';
////        char chZ = 'Z';
////        int num = Character.getNumericValue(ch);
////        int num2 = Character.getNumericValue(ch2);
////        int numA = Character.getNumericValue(chA);
////        int numZ = Character.getNumericValue(chZ);
////        System.out.println("ASCII value of char "+ch+ " is: "+num);
////        System.out.println("ASCII value of char "+ch2+ " is: "+num2);
////        System.out.println("ASCII value of char "+chA+ " is: "+numA);
////        System.out.println("ASCII value of char "+chZ+ " is: "+numZ);
//        // there 25 a-z characters. Distance form a to z is 25.
//        // 97  =  a 1
//        // 98  =  b
//        // 99  =  c
//        // 100  =  d
//        // 101  =  e
//        // 102  =  f
//        // 103  =  g
//        // 104  =  h
//        // 105  =  i
//        // 106  =  j 10
//        // 107  =  k
//        // 108  =  l 12
//        // 109  =  m 13 middle
//        // 110  =  n 14
//        // 111  =  o 15
//        // 112  =  p
//        // 113  =  q
//        // 114  =  r
//        // 115  =  s
//        // 116  =  t 20
//        // 117  =  u
//        // 118  =  v
//        // 119  =  w
//        // 120  =  x
//        // 121  =  y
//        // 122  =  z 26
//
//        // min 97, max 122
//        // a mapped to z
//        // b mapped to y
////        https://stackoverflow.com/questions/4234985/how-to-for-each-the-hashmap
//
////
//
//        String x = "\"Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!\"";
//        String out = solnWithStrBuilder(x);
//        System.out.println(out);
//    }
//
//    public static String solnWithStrBuilder(String x) {
//        StringBuilder stb = new StringBuilder();
//        x.chars()
//                .forEach(i -> stb.append(decrypt(i)));
//        return stb.toString();
//    }
//
//    /**
//     * Encrypt small letters `a` to `z` only.
//     *
//     * First letter `a` is encrypted with the last
//     * letter `z`, `b` with `y`, and so on.
//     * ASCII values: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
//     *
//     * @param encryptedVal int
//     * @return decrypt char
//     */
//    public static char decrypt(int encryptedVal) {
//        if ( encryptedVal >= 97 && encryptedVal <= 122) {
//            char encodedChar;
//            Map<Integer, Character> decryptKey = new HashMap<>();
//            for (int i = 122, j = 97; i >= 97; i--, j++) {
//                encodedChar = (char) i;
//                decryptKey.put(j, encodedChar);
//            }
//            // key.forEach((k,v) -> System.out.println(k + "=" + v));
//            return decryptKey.get(encryptedVal);
//        }
//
//        else return (char)encryptedVal;
//    }
//
//
////    public static String addChar(ch) {
////        char c;
////        Map<Integer, Character> key = new HashMap<>();
////
////        for (int i = 122, j= 97; i >= 97;  i--, j++) {
////            c = (char)i; //Converting ASCII value to Character
//////            System.out.println( i + "  =  " + c );
////            key.put(j, c);
////        }
////        char decryptedCh;
////        if ((int)ch < 26 && (int)ch >97)  decryptedCh = key.get(ch);
////        decryptedCh
////
////        StringBuilder sb = new StringBuilder();
////        sb.append(ch);
////        return sb.toString();
////    }
//
//    public static void main(String[] args) {
////        int threeMod = 12%3;
////        int fiveMod = 2%5;
////        System.out.println(threeMod);
////        System.out.println(fiveMod);
////
////        int threeDiv = 14/3;
////        int fiveDiv = 12/5;
////        System.out.println(threeDiv);
////        System.out.println(fiveDiv);
////        /**
////         * divide by 3/5 FB
////         * divided by 3 F
////         * divided by 5 B
////         * else dividend
////         */
////
//        googleEnc();
//    }
//
//    public static void minDist(){
//        List<Integer> a = new ArrayList<Integer>() {
//            {
//                add(5);
//                add(3);
//                add(1);
//                add(4);
//                add(6);
//            }
//        };
//        Collections.sort(a);
////        for (int ai : a) {
////            System.out.println(ai);
////        }
//
////        List<Integer> a = List.of(9, 8, 3, 15, 1);
//    }
//
//    public static void basicsList(){
//
//        // charge can not be > 100
//        // charge can not be < 0
//
//        List<Integer> a = List.of(25, -30, 70, -10);
//        int initialState = 50;
////        int intermediate = 0;
//        for (int aI : a) {
//            initialState = initialState + aI;
//
//            if ( initialState > 100 ) initialState = 100;
//            if ( initialState <= 0 ) initialState = 0;
//
//        }
//
//        System.out.println(initialState);
////        System.out.println(a); // [0, 1, 2, 3, 4, 0, 6, 7, 8, 9]
////        System.out.println(a.get(1));
//
//    }
//
//
//}

/**
 * Given an integer, n, perform the following conditional actions:
 * If n is odd, print Weird
 * If n is even and in the inclusive range of 2 to 5, print Not Weird
 * If n is even and in the inclusive range of 6 to 20, print Weird
 * If n is even and greater than 20, print Not Weird
 */
class Readme {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        checkOddEven(N);
        scanner.close();
    }


}


/**`
 * <p>You bought a new gaming laptop and like playing a game on it all day. It requires frequent charging due to high graphics usage. You want to know how much battery will be left after a number of playing and charging events.</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>Write a function that receives <em>n</em>&nbsp;records of the laptop's battery consumption and charging <em>events</em>. An <em>events[i]</em> value represents the number of minutes spent charging the laptop (positive value) or playing a game (negative value) . Every minute, the laptop charges <em>1% </em>or loses <em>1%</em> of its energy. The battery's charge cannot go over <em>100%</em>. Return the laptop's final charge percentage given that the initial charge is <em>50%</em>.<em> </em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>Example</strong></p>
 *
 * <p><em>n = 4</em></p>
 *
 * <p><em>events = [10, -20, 61, -15]</em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>Initially the laptop is charged to 50%. It is plugged in for <em>events[0] = 10</em>&nbsp;minutes and is charged to <em>50 + 10 = 60.</em>&nbsp; A game is played for <i>20 minutes at </i><em>events[1] = -20</em>&nbsp;bringing the charge to <em>40.</em>&nbsp; Charging for another <em>61</em>&nbsp;minutes stops when the charge reaches <em>100</em>, then <em>15</em> minutes of play results in a final charge of <em>85</em>.</p>
 * nbsp;
 * <p>
 * p class="section-title">Function Description</p>
 * <p>
 * p>Complete the function <em>getBattery</em> in the editor below. The function must return an integer.</p>
 * <p>
 * p>&nbsp;</p>
 * <p>
 * p><em>getBattery</em> has the following parameter:</p>
 * <p>
 * p>&nbsp;&nbsp;&nbsp;&nbsp;<em>events[events[0],...events[n-1]]:</em>&nbsp; an array of integers</p>
 * <p>
 * p>&nbsp;</p>
 * <p>
 * p class="section-title">Constraints</p>
 *
 * <ul>
 * <li><em>1 ≤&nbsp;n&nbsp;≤ 10<sup>5</sup></em></li>
 * <li><em>-100 ≤&nbsp;events[i]&nbsp;≤ 100</em></li>
 * <li>The battery charge never goes negative.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <!-- <StartOfInputFormat> DO NOT REMOVE THIS LINE-->
 *
 * <details><summary class="section-title">Input Format For Custom Testing</summary>
 *
 * <div class="collapsable-details">
 * <p>The first line contains an integer, <em>n</em>, denoting the number of elements in <em>events</em>.<br>
 * Each <em>i </em>line of the <em>n</em> subsequent lines (where <em>0 ≤ i &lt; n</em>) contains an integer describing <em>events[i]</em>.</p>
 *
 * <p>&nbsp;</p>
 * </div>
 * </details>
 * <!-- </StartOfInputFormat> DO NOT REMOVE THIS LINE-->
 *
 * <details open="open"><summary class="section-title">Sample Case 0</summary>
 *
 * <div class="collapsable-details">
 * <p class="section-title">Sample Input For Custom Testing</p>
 *
 * <pre>4
 * 25
 * -30
 * 70
 * -10
 * </pre>
 *
 * <p class="section-title">Sample Output</p>
 *
 * <pre>90</pre>
 *
 * <p class="section-title">Explanation</p>
 *
 * <p><em>n = 4</em></p>
 *
 * <p><em>events = [25, -30, 70, 10]</em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>The battery starts at <em>charge = 50%</em>.</p>
 *
 * <p>It is charged for 25 minutes,<em> charge = 75%</em>.</p>
 *
 * <p>Then it is used for 30 minutes, <em>charge = 45%</em>.</p>
 *
 * <p>After that, it is charged for 70 minutes, <em>charge = 100%</em> since it cannot charge over that.</p>
 *
 * <p>Finally, it is used for 10 minutes, <em>charge = 90%</em>.</p>
 *
 * <p>&nbsp;</p>
 * </div>
 * </details>
 *
 * <details><summary class="section-title">Sample Case 1</summary>
 *
 * <div class="collapsable-details">
 * <p class="section-title">Sample Input For Custom Testing</p>
 *
 * <pre>3
 * -10
 * 60
 * 10
 * </pre>
 *
 * <p class="section-title">Sample Output</p>
 *
 * <pre>100</pre>
 *
 * <p class="section-title">Explanation</p>
 *
 * <p><em>n = 3</em></p>
 *
 * <p><em>events = [-10, 60, 10]</em></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>The battery starts at 50%.</p>
 *
 * <p>It is used for 10 minutes,<em> charge = 40%</em>.</p>
 *
 * <p>Then it is charged for 60 minutes, <em>charge = 100%</em>.</p>
 *
 * <p>Finally, it is used for 10 minutes, <em>charge = 100%</em>.</p>
 * </div>
 * </details>
 * <p>
 * <p>
 * A number of points along the highway are in need of repair. An equal number of crews are available, stationed at various points along the highway. They must move along the highway to reach an assigned point. Given that one crew must be assigned to each job, what is the minimum total
 * <p>
 * A number of points along the highway are in need of repair. An equal number of crews are available, stationed at various points along the highway. They must move along the highway to reach an assigned point. Given that one crew must be assigned to each job, what is the minimum total
 * <p>
 * A number of points along the highway are in need of repair. An equal number of crews are available, stationed at various points along the highway. They must move along the highway to reach an assigned point. Given that one crew must be assigned to each job, what is the minimum total
 */
/**
 * A number of points along the highway are in need of repair. An equal number of crews are available, stationed at various points along the highway. They must move along the highway to reach an assigned point. Given that one crew must be assigned to each job, what is the minimum total
 */


