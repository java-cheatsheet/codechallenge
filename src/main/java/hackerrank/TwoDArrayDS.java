package hackerrank;

public class TwoDArrayDS {

    public static void main(String[] args) {

        int[][] twoDArrays = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0},
        };

        int[][] twoDArray = new int[][]{
                {-1, - 1, 0, - 9, - 2, - 2},
                {- 2, - 1, - 6, - 8, - 2, - 5},
                {- 1, - 1, - 1, - 2, - 3, - 4},
                {- 1, - 9, - 2, - 4, - 4, - 5},
                {- 7, - 3, - 3, - 2, - 9, - 9},
                {- 1, - 3, - 1, - 2, - 4, - 5}
        };

        hourglassSum(twoDArray);
    }

    /**
     * First 3X3 Array
     * arr[0][0] + arr[0][1] + arr[0][2] | i
     * + arr[1][1] | i+1
     * arr[2][0] + arr[2][1] + arr[2][2] | i+2
     *
     * Second Column 3X3 array
     * arr[0][1] + arr[0][1] + arr[0][2] | i
     * + arr[1][2] | i+1
     * arr[2][1] + arr[2][2] + arr[2][3] | i+2
     *
     * Second Row 3X3 array
     * arr[1][0] + arr[1][1] + arr[1][2] | i
     * + arr[2][1] | i+1
     * arr[3][0] + arr[3][1] + arr[3][2] | i+2
     *
     * @return int[][]
     */
    static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;

        for ( int i = 0; i < 4 ; i++ ) {

            for ( int j = 0; j < 4; j++ ) {

                // Condition is not necessary as it is provided in the constraints.
                if (
                        ( arr[i][j] < 10 &&  arr[i][j] >= -9 )
                                && ( arr[i][j + 1] <= 9 && arr[i][j + 1] >= -9 )
                                && ( arr[i][j + 2] <= 9 && arr[i][j + 2] >= -9 )

                                && ( arr[i + 1][j + 1] <= 9 && arr[i + 1][j + 1] >= -9 )

                                && ( arr[i + 2][j] <= 9 && arr[i + 2][j] >= -9 )
                                && ( arr[i + 2][j + 1] <= 9 && arr[i + 2][j + 1] >= -9 )
                                && ( arr[i + 2][j + 2] <= 9 && arr[i + 2][j + 2] >= -9 )
                        ) {


                    int sumHolder = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                            arr[i + 1][j + 1] +
                            arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                    if (sumHolder > sum) sum = sumHolder;
                }
            }
        }

        System.out.println(sum);
        return sum;
    }

}
