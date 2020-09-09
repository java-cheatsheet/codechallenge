package google.Level2.Part1;

public class SecondSolution {

    public static int solution(int[] A) {

        if ( A.length == 1 ) return ( A[0] % 3 ) == 0 ? A[0] : 0;

        int[] countMod = new int[11];
        countMod = countMod(A);

        if ( countMod[10] == 0 ) return buildLargeNum(countMod);

        if ( updateCount(countMod) ) return buildLargeNum(countMod);

        return 0;
    }

    /**
     * Build an array containing count of 0-9 ints
     * and mod3 of their sum.
     *
     * @param A []int
     *
     * @return []int Contains count of 0-9 and Mod3 of their sum.
     */
    public static int[] countMod(int[] A) {
        int[] countMod = new int[11];

        for (int i = 0; i < A.length; i++) {
            countMod[A[i]]++;
            countMod[10]+=A[i];
        }
        countMod[10] = countMod[10] % 3;

        return countMod;
    }

    public static int buildLargeNum(int[] count) {
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 9; i >= 0; i--) {

            for ( int j = count[i]; j > 0; j-- ) {
                strBuilder.append(String.valueOf(i));
            }
        }

        return Integer.parseInt(strBuilder.toString());
    }


    /**
     * updateCount Make number divisible by 3.
     * If not possible return false.
     *
     * @param countMod int[]
     * Contains count of integers 0-9 and
     * Mod3 of sum of 0-9 at index 10.
     *
     * @return boolean
     */
    public static boolean updateCount(int[] countMod) {

//        Try to remove one small number first.
//        mod=1, remove one 1,4,7, or two of any 2,5,8
//        mod=2, remove one 2,5,8, or two of any 1,4,7

        // mod3 of countMod[0-9]
        int i = countMod[10];
//        i = i == 1 ? 2 : 1;
        boolean isUpdated = false;
        int singleDel = 0;

        search:
        for (int delMod=1; delMod < 4; delMod++) {

            for (; i < 9; i+=3) {

                if ( countMod[i] > 0 ) {

                    if ( delMod == 1 ) {
                        countMod[i]--;
                        countMod[10] = 0;
                        isUpdated = true;
                        break search;

                    } else if ( delMod > 1 ) {

                        if ( countMod[i] > 1 ) {
                            countMod[i] -= 2;
                            countMod[10] = 0;
                            isUpdated = true;
                            break search;
                        } else {
                            if ( singleDel < 2 ) {
                                countMod[i]--;

                                if ( singleDel++ == 2) {
                                    countMod[10] = 0;
                                    isUpdated = true;
                                    break search;
                                };
                            }
                        }
                    }
                }
            }

            i = i == 1 ? 2 : 1;
        }

        return isUpdated;
    }


}
