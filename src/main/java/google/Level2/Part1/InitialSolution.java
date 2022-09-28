package google.Level2.Part1;

import java.util.Arrays;
import java.util.Collections;

/**
 * Fails the 4th hidden test!
 */
public class InitialSolution {

    /**
     * Test 4 failed  [Hidden]
     *
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        int lenA = A.length;

        if ( lenA == 0 || lenA > 10 ) return 0;

        Integer[] sortedA = new Integer[lenA];
        sortedA = Arrays.stream(A).boxed().toArray( Integer[]::new );
        Arrays.sort(sortedA, Collections.reverseOrder());
        String sortedAStr = arrIntToStr(sortedA);

        if ( lenA >= 10 )
            if ( !isNumMoreThanIntMax(sortedAStr) )
                return 0;

        if ( sortedA[0] == sortedA[lenA-1] && sortedA[0] == 0 )
            return 0;

        int skip = lenA;
        for (int i = 0; i < lenA && skip >= i && lenA > 1; skip--) {

            if (skip == i) {
                i++;
                skip = lenA--;

                if (lenA == 1) break;
            }

            int num = strToInt(sortedAStr, i, skip);
            if(num%3 == 0){
                return num;
            }
        }

        int lastNum = sortedA[sortedA.length-1];
        if( lastNum%3 == 0){
            return lastNum;
        }

        return 0;
    }

    // check if the sortedA does not exceed Integer.MAX_VALUE
    public static boolean isNumMoreThanIntMax(String sortedA) {
        return Long.parseLong(sortedA, 10)
                <= Long.valueOf(Integer.MAX_VALUE);
    }

    public static String arrIntToStr(Integer[] sortedArr) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < sortedArr.length; i++) {
            strBuilder.append(sortedArr[i]);
        }

        return strBuilder.toString();
    }

    public static int strToInt(String numStr, int start, int skip) {
        String newStr = numStr.substring(start, skip);

        if ( skip < numStr.length() )
            newStr += numStr.substring(skip+1);

        return  Integer.parseInt(newStr);
    }

    public static int solutionA(int[] A) {
        int lenA = A.length-1;
        Integer[] sortedA = Arrays.stream( A ).boxed().toArray( Integer[]::new );
        Arrays.sort(sortedA, Collections.reverseOrder());

//        System.out.println(A[0]);
//        System.out.println(newA[0]);
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            strBuilder.append(sortedA[i]);
        }
        String newAString = strBuilder.toString();
//        System.out.println(newAString);

        for (int i = 0; i < lenA; i++) {
//            System.out.println(sortedA[i]);



            // loop through all except one,
            // skip one from end
            int skip = lenA;
            String subString = "";

            for (int j = i; j < lenA; j++) {

                if( j != skip ) {
//                    edA[j].toString();
                }

            }
            System.out.printf("substring %s%n", subString);
//                String subString = newAString.substring(i, j+1);
//                System.out.printf("substring %s%n", subString);
//                int subIntString = Integer.parseInt(subString);
//
//                if (  subIntString % 3 == 0 ) {
//                    return subIntString;
//                }
//                sum += sortedA[j];


//            for int j=i; j < lenA; j++
//            if( j != skip )
//                string += A[i]
//            mod check
//            skip--


        }
//

        return 0;
    }
}
