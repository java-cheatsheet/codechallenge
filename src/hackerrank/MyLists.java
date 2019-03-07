package hackerrank;

import java.util.*;


import java.util.stream.Collectors;


// ...
public class MyLists {

    public static void main( String[] args ){
        MyLists bT = new MyLists();

//        bT.basicsList();

//        basicTest.basicQueue();

//        basicTest.basicsHashMaps();

//        HashMap<String, Integer> stringCountHM = basicTest.countWords("Gabba gabba hey, gabba gabba hey!");
//        System.out.println(stringCountHM);

//        int[] compareArraya  = {1,2,4};
//        int[] compareArrayb  = {1,2,3};
//        List<Integer> compareLista = Arrays.stream(compareArraya).boxed().collect(Collectors.toList());
//        List<Integer> compareListb = Arrays.stream(compareArrayb).boxed().collect(Collectors.toList());
//        List<Integer> comparedReturn = bT.compareTriplets(compareLista, compareListb);
//        System.out.println(comparedReturn);


//        long[] toBeSummed = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
////        5000000015
//        long returnedLongSum = bT.aVeryBigSum(toBeSummed);
//        System.out.println(returnedLongSum);

//        int[][] multD = {{1, 2, 3}, {4, 5, 6}, {7, 8, 15}};
//        System.out.println( bT.diagonalDifference(multD) );

//        int[] plusMinus = {-4, 3, -9, 0, 4, 1 };
//        bT.plusMinus(plusMinus);

//        bT.staircase(6);
        int[] minMax= {938071625, 256741038, 623958417, 467905213, 714532089, 938071625};//{5, 5, 5, 5, 5}; //{1, 1, 2, 3, 3};   //{1, 2, 3, 4, 5};
        bT.miniMaxSum(minMax);

    }

    /**
     *  get the sum of the int[] without min and max integers.
     *
     * @param arr
     */
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        int min = stat.getMin();
        int max = stat.getMax();

        if( min == max ) {
            long minMaxSame = 4*min;
            System.out.print( minMaxSame + " " + minMaxSame);

        } else {
            int lenghtOfArray = arr.length -2;
            long sumWithMax = 0;
            long sumWithMin = 0;

            long[] longArray = Arrays.stream(arr).asLongStream().toArray();
//            System.out.println(longArray[0]);
            List<Long> longMaxList = Arrays.stream(longArray).boxed().collect(Collectors.toList());
//
//            longMinList.remove(max);
//            longMaxList.remove(min);
            Collections.sort(longMaxList);
            int sizeOfArray = longMaxList.size();

//            System.out.println(longMaxList.get());
//            System.out.println(longMinList);

            while (sizeOfArray >= 0) {

//                sumWithMin += longMinList.get(lenghtOfArray);
                sumWithMax += longMaxList.get(lenghtOfArray);
                sizeOfArray--;
            }

            System.out.print(sumWithMin + " " + sumWithMax);
        }
    }

    /**
     *      #  | # 1, empty n-1
     *     ##  | # 2, empty n-2
     *    ###  | # 3, empty n-3
     *   ####  | # 4, empty n-4 ..
     *  #####
     * ######
     *
     * @param n
     */
    public void staircase(int n) {

        int countRows = 0;
        int numberToPrint = n;

        while ( countRows <  numberToPrint ) {
            int countColumns = 0;

            while ( countColumns < numberToPrint) {

                if( countColumns < numberToPrint - (countRows + 1) ) System.out.print(" ");

                else System.out.print("#");

                countColumns++;
            }
            System.out.println();
            countRows++;
        }
    }

    // Complete the plusMinus function below.
    public void plusMinus(int[] arr) {
        int numOfPositiveNum = 0, numOfNegativeNum = 0, numOfZero = 0;
        int lengthOfArray = arr.length;
        int lengthOfArrayForFraction = lengthOfArray;

        while( --lengthOfArray >= 0 ) {

            if ( arr[lengthOfArray] == 0 ) numOfZero++;

            else if (arr[lengthOfArray] < 0) numOfNegativeNum++;

            else numOfPositiveNum++;

        }
        float zeroSum = (float) numOfZero/lengthOfArrayForFraction;
        float negativeSum = (float) numOfNegativeNum/lengthOfArrayForFraction;
        float positiveSum = (float) numOfPositiveNum/lengthOfArrayForFraction;

        System.out.println(String.format ("%.5f", positiveSum));
        System.out.println(String.format ("%.5f", negativeSum));
        System.out.println(String.format ("%.5f", zeroSum));
    }

    public int diagonalDifference(int[][] arr) {
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         *
         * D 2 3 D
         * 4 D D 4
         * 9 D D 4
         * D 8 9 D
         *
         * D 0 3 D 5 6 D
         * 2 D 5 4 5 D 7
         * 3 5 D 4 D 6 7
         * 4 8 9 D 5 6 7
         * 5 8 D 5 D 6 7
         * 6 D 9 D 5 D 7
         * D 8 9 D 5 6 D
         *
         * For \ Back Diagonal
         * 0:1, 1:2, 2:3..
         *
         * For / Front Diagonal
         * 0:length-1, 1:length-2
         *
         */

        int numberOfRows = arr[0].length;
        int numberOfColumns = numberOfRows - 1;
        int sumOfBackDiagonal = 0;
        int sumOfFrontDiagonal = 0;

        for( int i = 0; i < numberOfRows; i++, numberOfColumns--) {
            sumOfBackDiagonal += arr[i][i];
            sumOfFrontDiagonal += arr[i][numberOfColumns];    //0,3 | 1, 2 | 2, 1
        }

        return Math.abs( sumOfBackDiagonal - sumOfFrontDiagonal);
    }

    public long aVeryBigSum(long[] ar) {
        int lengthOfArray = ar.length;

        if (lengthOfArray < 1 ||  lengthOfArray > 10) return 0;

         long sumResult = 0;

         //boolean valueOfIndexIsLessThanMaxLimit = true;
//       10
//        6
//        5
//        10 - 6 > = 5

        while( lengthOfArray > 0 ) {
            --lengthOfArray;

            System.out.println(Long.MAX_VALUE  - sumResult);

            if ( ar[lengthOfArray] < Long.MIN_VALUE
                    || ar[lengthOfArray] > Long.MAX_VALUE
                    || Long.MAX_VALUE  - sumResult <= ar[lengthOfArray]
                    )
                throw new ArithmeticException("Value out of bound");

            sumResult += ar[lengthOfArray];
        }

        return sumResult;
    }

    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> comparisionResult = new ArrayList<>(Arrays.asList(0, 0));
        int sizeOfa = a.size();
        int sizeOfb = b.size();

        if (sizeOfa != sizeOfb) return comparisionResult;
        if( sizeOfa < 0 || sizeOfa > 100  ) return comparisionResult;

        while (sizeOfa > 0) {
            --sizeOfa;
            int comparedValue = 0;

            if (a.get(sizeOfa) > b.get(sizeOfa)) {

                comparedValue = comparisionResult.get(0) + 1;
                comparisionResult.set(0, comparedValue);
            }

            if (a.get(sizeOfa) < b.get(sizeOfa)) {
                comparedValue = comparisionResult.get(1) + 1;
                comparisionResult.set(1, comparedValue);
            }

        }

        return comparisionResult;
    }

     public void basicsList(){
         List<Integer> a = new ArrayList<>();
         List<Integer> b = new LinkedList<>();

         for (int i = 0; i < 10; i++) {
             a.add(i);
             b.add(i);
         }

         a.set(5, 0);
         b.remove(5);
         System.out.println(a); // [0, 1, 2, 3, 4, 0, 6, 7, 8, 9]
         System.out.println(b); // [0, 1, 2, 3, 4, 6, 7, 8, 9]

         System.out.println(a.get(1));


     }

    public void basicStack(){

         Stack<Integer> stacka = new Stack<>();

         stacka.push(1);
         stacka.push(2);
         System.out.println(stacka.pop()); // 2
         stacka.push(3);
         System.out.println(stacka); // [1, 3]
     }

    public void basicQueue() {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // [1, 2, 3]

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        System.out.println(queue);

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        System.out.println(stack); // [3, 2, 1]
    }

    public void basicsHashMaps() {
        HashSet<String> set = new HashSet<>();
        set.add("dog");
        set.add("cat");
        set.add("fish");
        System.out.println(set.contains("dog")); // true
        System.out.println(set.contains("horse")); // false

        HashMap<String, String> map = new HashMap<>();
        map.put("Jenny", "867-5309");
        System.out.println(map.get("Jenny")); // 867-5309
    }

    public HashMap<String, Integer> countWords(String document) {

        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : document.split(" ")) {
            String key = word.toLowerCase().replaceAll("[^a-zA-Z]", "");

            if (counts.containsKey(key)) {
                counts.put(key, counts.get(key) + 1);
            } else {
                counts.put(key, 1);
            }
        }
        return counts;
    }



}
