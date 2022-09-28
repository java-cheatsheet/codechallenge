package google.Level3.Part2;

import java.util.ArrayList;

public class Solution {

    public static int[] solution(int[][] m) {

        if ( (m.length == 1) && ( m[0][0] == 0 ) )
                return new int[]{1, 1};


        double[][] mDouble = toDouble(m);
        //TODO: change the double back into an int

        // GOAL ONE: find Q matrix :
        // 1:seperate the input into two 2d arrays
        ArrayList<double[]> ters = new ArrayList<double[]>();
        ArrayList<double[]> nonTers = new ArrayList<double[]>();

        for(int i = 0; i < mDouble.length; i++){
            boolean isTerminal = true;
            int sum = 0;
            for(int j = 0; j < mDouble[0].length; j++){
                sum += mDouble[i][j];
                if(mDouble[i][j] != 0){
                    isTerminal = false;
                }
            }

            if(isTerminal){
                ters.add(mDouble[i]);
            }else{
                for(int j = 0; j < mDouble[0].length; j++){
                    mDouble[i][j] = mDouble[i][j]/sum;
                }
                nonTers.add(mDouble[i]);
            }
        }

        double[][] terminalStates = new double[ters.size()][m.length];
        for(int i = 0; i < ters.size(); i++){
            terminalStates[i] = ters.get(i);
        }

        double[][] nonTerminalStates = new double[nonTers.size()][m.length];
        for(int i = 0; i < nonTers.size(); i++){
            nonTerminalStates[i] = nonTers.get(i);
        }

        // 2: Plug into a function that will create the 2d array
        double[][] QMatrix = getQMatrix(nonTerminalStates);


        // GOAL TWO: find I matrix
        double[][] IMatrix = makeIMatrix(QMatrix.length);


        //GOAL 3: Find F matrix
        //1: subtract the q matrix from the I matrix
        double[][] AMatrix = SubtractMatrices(IMatrix, QMatrix);

        //2: find the inverse TODO WRITE FUNCTION
        double[][] FMatrix = invert(AMatrix);


        //GOAL 4: multiply by R Matrix
        //1: find r Matrx
        double[][] RMatrix = getRMatrix(nonTerminalStates, terminalStates.length);

        //2: use multiply function to get FR Matrix
        double[][] FRMatrix = multiplyMatrices(FMatrix, RMatrix);


        //GOAL 5: find answer array
        int[] ans = fractionAns(FRMatrix[0]);
        return ans;
    }

    public static int[] fractionAns(double[] uAns){
        int[] ans = new int[uAns.length + 1];
        int[] denominators = new int[uAns.length];
        int[] numerators = new int[uAns.length];
        for(int i = 0; i < uAns.length; i++){
            denominators[i] = convertDecimalToFraction(uAns[i])[1];
            numerators[i] = convertDecimalToFraction(uAns[i])[0];
        }
        int lcm = (int) lcm_of_array_elements(denominators);
        for(int i = 0; i < uAns.length; i++){
            ans[i] = numerators[i]*(lcm/convertDecimalToFraction(uAns[i])[1]);
        }
        ans[ans.length-1] = lcm;
        return ans;
    }

    static private int[] convertDecimalToFraction(double x){
        double tolerance = 1.0E-10;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        return new int[]{(int)h1, (int)k1};
    }

    public static long lcm_of_array_elements(int[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

    public static double[][] toDouble(int[][] ma){
        double[][] retArr = new double[ma.length][ma.length];
        for(int i = 0; i < retArr.length; i++){
            for(int j = 0; j < retArr[0].length; j++){
                retArr[i][j] = (ma[i][j]);
            }
        }
        return retArr;
    }

    public static double[][] getRMatrix(double[][] nonTerminals, int terminalLength){
        double[][] retArr = new double[nonTerminals.length][terminalLength];
        for(int i = 0; i < retArr.length; i++){
            if (nonTerminals[0].length - nonTerminals.length >= 0)
                System.arraycopy(nonTerminals[i], nonTerminals.length, retArr[i], nonTerminals.length - nonTerminals.length, nonTerminals[0].length - nonTerminals.length);
        }
        return retArr;
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix){
        int r1 = firstMatrix.length;
        int c1 = firstMatrix[0].length;
        int c2 = secondMatrix[0].length;
        double[][] product = new double[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }

    public static double[][] SubtractMatrices(double[][] I, double[][] Q){
        double[][] retArr = new double[I.length][I.length];
        for(int i = 0; i < retArr.length; i++){
            for(int j = 0; j < retArr.length; j++){
                retArr[i][j] = I[i][j]-Q[i][j];
            }
        }
        return retArr;
    }

    public static double[][] getQMatrix(double[][] qArr){
        int size = qArr.length;
        double[][] retArr = new double[size][size];
        for(int i = 0; i < size; i++){
            System.arraycopy(qArr[i], 0, retArr[i], 0, size);
        }
        return retArr;
    }

    public static double[][] makeIMatrix(int size){
        double[][] retArr = new double[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j){
                    retArr[i][j] = 1;
                }else{
                    retArr[i][j] = 0;
                }
            }
        }
        return retArr;
    }


    public static double[][] invert(double[][] a) {
        int n = a.length;
        double[][] x = new double[n][n];
        double[][] b = new double[n][n];
        int[] index = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double[][] a, int[] index)
    {
        int n = index.length;
        double[] c = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    // https://github.com/rchen8/Algorithms/blob/master/Matrix.java
    private static double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

//

}
