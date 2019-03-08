package hackerrank;

public class MinimumSwapsTwo {

    public static void main(String args[]) {
        int[] arr = {4, 3, 1, 2};
        int expected = 3;
        int actual = minimumSwaps(arr);

        assert (actual == expected) : "Error";
    }

    static int minimumSwaps(int[] arr) {
        int swapCounts = 0;

        // loop over all the numbers
        // inner loop to check for the place of the number
        for ( int i = 0; i < arr.length; i++ ) {
            int indexVal = i + 1;

            if ( arr[i] != i + 1 ) {
               //find the value of i + 1
                for ( int j = i + 1; j < arr.length; j++) {

                    if ( indexVal == arr[j] ) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        swapCounts++;
                        break;
                    }

                }
            }

        }

        return swapCounts;
    }


}
