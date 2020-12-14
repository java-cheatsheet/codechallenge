Doomsday Fuel
=============

Making fuel for the LAMBCHOP's reactor core is a tricky process because of the exotic matter involved. It starts as raw ore, then during processing, begins randomly changing between forms, eventually reaching a stable form. There **may be multiple stable forms** that a sample could ultimately reach, not all of which are useful as fuel. 

Commander Lambda has tasked you to help the scientists increase fuel creation efficiency by 
**predicting the end state** of a given ore sample. 

You have carefully studied the different structures that the ore can take and which transitions it undergoes.

It appears that, while random, the **probability** of each structure transforming is fixed. 

That is, **each time the ore is in 1 state, it has the same probabilities of entering the next state** (which might be the same state).  

You have recorded the observed transitions in a matrix. 

The others in the lab have hypothesized more exotic forms that the ore can become, but you haven't seen all of them.

Write a function solution(m) that takes an array of array of nonnegative ints representing

### how many times that state has gone to the next state 

and return an array of ints for each terminal state giving the exact probabilities of each terminal state,

represented as the numerator for each state, then the denominator for all of them at the end and in simplest form.

The matrix is at most 10 by 10.

It is guaranteed that no matter which state the ore is in, there is a path from that state to a terminal state.

# That is, the processing will always eventually end in a stable state. The ore starts in state 0.
 
The denominator will fit within a signed 32-bit integer during the calculation, as long as the fraction is simplified regularly. 

For example, consider the matrix m:
[
  [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
  [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
  [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
  [0,0,0,0,0,0],  # s3 is terminal
  [0,0,0,0,0,0],  # s4 is terminal
  [0,0,0,0,0,0],  # s5 is terminal
]

So, we can consider different paths to terminal states, such as:
s0 -> s1 -> s3
s0 -> s1 -> s0 -> s1 -> s0 -> s1 -> s4
s0 -> s1 -> s0 -> s5

Tracing the probabilities of each, we find that
s2 has probability 0
s3 has probability 3/14
s4 has probability 1/7
s5 has probability 9/14

So, putting that together, and making a common denominator, gives an answer in the form of
[s2.numerator, s3.numerator, s4.numerator, s5.numerator, denominator] which is

[0, 3, 2, 9, 14].

Languages
=========

To provide a Java solution, edit Solution.java
To provide a Python solution, edit solution.py

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Java cases --
Input:
Solution.solution({{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}})

{0, 2, 1, 0, 0},
{0, 0, 0, 3, 4},
{0, 0, 0, 0, 0},
{0, 0, 0, 0, 0},
{0, 0, 0, 0, 0}

Output:
[7, 6, 8, 21]

Input:
Solution.solution({{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}})

{0, 1, 0, 0, 0, 1}, 
{4, 0, 0, 3, 2, 0}, 
{0, 0, 0, 0, 0, 0}, 
{0, 0, 0, 0, 0, 0}, 
{0, 0, 0, 0, 0, 0}, 
{0, 0, 0, 0, 0, 0}


Output:
    [0, 3, 2, 9, 14]

-- Python cases --
Input:
solution.solution([[0, 2, 1, 0, 0], [0, 0, 0, 3, 4], [0, 0, 0, 0, 0], [0, 0, 0, 0,0], [0, 0, 0, 0, 0]])
Output:
    [7, 6, 8, 21]

Input:
solution.solution([[0, 1, 0, 0, 0, 1], [4, 0, 0, 3, 2, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]])
Output:
    [0, 3, 2, 9, 14]

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

# Solution
https://sskaje.me/2017/05/googles-foo-bar-doomsday-fuel
https://en.wikipedia.org/wiki/Absorbing_Markov_chain
https://en.wikipedia.org/wiki/Mathematical_object
https://www.khanacademy.org/math


After some more search, ended up at https://en.wikipedia.org/wiki/Category:Markov_models
On the list of that page, it had Google Search algorithms or information about how Google Search worked were listed. I always try to find the meaning of work, even always thought about why the questions are being asked to solved by the Google's FooBar challenge. This is really a positive things to know which motivates more to dig dive more into the problem itself as now it gets a purpose.

### Day 2

https://en.wikipedia.org/wiki/Markov_chain
https://en.wikipedia.org/wiki/Absorbing_Markov_chain
https://en.wikipedia.org/wiki/Discrete_phase-type_distribution
https://en.wikipedia.org/wiki/Category:Markov_models
https://en.wikipedia.org/wiki/PageRank
https://en.wikipedia.org/wiki/Google_matrix

https://en.wikipedia.org/wiki/Citation_analysis
https://en.wikipedia.org/wiki/HITS_algorithm
https://en.wikipedia.org/wiki/Iterative_method
https://en.wikipedia.org/wiki/Attractor#Basins_of_attraction
https://en.wikipedia.org/wiki/Dynamical_system
https://en.wikipedia.org/wiki/Stochastic_process
https://en.wikipedia.org/wiki/Probability_theory
https://en.wikipedia.org/wiki/Measure_(mathematics)
https://en.wikipedia.org/wiki/Probability_axioms
https://en.wikipedia.org/wiki/Phase_space
https://en.wikipedia.org/wiki/Space_(mathematics)
https://en.wikipedia.org/wiki/Asymptotic_analysis
https://en.wikipedia.org/wiki/Eigenvalues_and_eigenvectors#Basic_reproduction_number
https://en.wikipedia.org/wiki/Introduction_to_eigenstates
https://en.wikipedia.org/wiki/Square_matrix
https://en.wikipedia.org/wiki/Probability_distribution
https://en.wikipedia.org/wiki/List_of_probability_distributions
https://en.wikipedia.org/wiki/Discrete_uniform_distribution
https://en.wikipedia.org/wiki/Random_permutation
https://en.wikipedia.org/wiki/Ewens%27s_sampling_formula
https://en.wikipedia.org/wiki/Permutation
https://en.wikipedia.org/wiki/Benford%27s_law
https://en.wikipedia.org/wiki/MegaHAL
https://en.wikipedia.org/wiki/Snakes_and_Ladders


### Day third
Made an interesting finding. After logging into the site, there is a message:

`Commander Lambda has six suits, three dress uniforms, four casual outfits, and one Dress-Uniform-For-Important-Speeches-Only. You know this because you've already had to take all of them to the dry cleaner's. Twice!`

So I just took out the numbers - 634122, and searched `634122 algorithms` and the results related to the problem. The nature of problem it pointed towards were https://en.wikipedia.org/wiki/Stochastic_process or simply random process, which so led to https://en.wikipedia.org/wiki/Markov_chain


https://towardsdatascience.com/bayesian-optimization-in-trading-77202ffed530


Lecture 18. Introduction to State Space Models and Sequential Importance Sampling
https://www.youtube.com/watch?v=619cVBbd3YY


Good description
https://github.com/ivanseed/google-foobar-help/blob/master/challenges/doomsday_fuel/doomsday_fuel.md

Primary video
https://www.youtube.com/watch?v=qhnFHnLkrfA&list=PLANMHOrJaFxPMQCMYcYqwOCYlreFswAKP&index=9


https://www.plussed.net/markov/index.php


Solution example:
https://stackoverflow.com/questions/61627375/hidden-test-cases-not-passing-for-google-foobar-challenge-doomsday-fuel

```
import java.util.ArrayList;
public class Solution {
    public static int[] solution(int[][] m) {
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
        double[][] nonTerminalStates = new double[nonTers.size()][m.length];

        for(int i = 0; i < ters.size(); i++){
            terminalStates[i] = ters.get(i);
        }
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
        //1: get the one dimensional answer
        double[] unsimplifiedAns = FRMatrix[0];
        //2: get fractions for the answers
        int[] ans = fractionAns(unsimplifiedAns);
        return ans;
    }
    public static int[] fractionAns(double[] uAns){
        int[] ans = new int[uAns.length + 1];
        int[] denominators = new int[uAns.length];
        int[] numerators = new int[uAns.length];
        for(int i = 0; i < uAns.length; i++){
            denominators[i] = (int)(convertDecimalToFraction(uAns[i])[1]);
            numerators[i] = (int)(convertDecimalToFraction(uAns[i])[0]);
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
            for(int j = nonTerminals.length; j < nonTerminals[0].length; j++){
                retArr[i][j-nonTerminals.length] = (nonTerminals[i][j]);
            }
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
    public static double[][] inverseMatrix(double[][] Amatrix){
        return null;
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
            for(int j = 0; j < size; j++){
                retArr[i][j] = qArr[i][j];
            }
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
    public static double[][] invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
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

    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];

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


}
```
https://gist.github.com/michaelcaterisano/98c11b81e8791f8819f0dd877df54b8c
This solution fails test 3 and 7. And takes longer time than the python solution below.

Below link has matrix implementation example but the solution fails when used.
https://github.com/rchen8/Algorithms/blob/master/Matrix.java


```python
from __future__ import division
from itertools import compress
from itertools import starmap
from operator import mul
import fractions

"""My solution to a Google foobar level 3 problem called "Doomsday Fuel". This solution implements the 
   method described at http://math.plussed.net/markov/ for
   determining the probability vector of a given state in a Markov chain. Refer to 
   doomsdayFuel.txt for the problem definition."""

# Test cases. Uncomment a single test case to use it as the input to the
# answer method. Each test case is a 2d array, m, which represents a given
# transition matrix for a Markov chain

# Case 1. Expected output: [0, 3, 2, 9, 14]

m = [[0, 1, 0, 0, 0, 1], [4, 0, 0, 3, 2, 0], [0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]

# Case 2. Expected output: [7, 6, 8, 21]

#m = [[0, 2, 1, 0, 0], [0, 0, 0, 3, 4], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]


def convertMatrix(transMatrix):
    """Converts transition matrix values to floats representing probabilities."""
    probMatrix = []

    for i in range(len(transMatrix)):
        row = transMatrix[i]
        newRow = []
        rowSum = sum(transMatrix[i])

        if all([v == 0 for v in transMatrix[i]]):
            for j in transMatrix[i]:
                newRow.append(0)

            newRow[i] = 1
            probMatrix.append(newRow)

        else:
            for j in transMatrix[i]:

                if j == 0:
                    newRow.append(0)

                else:
                    newRow.append(j / rowSum)
            probMatrix.append(newRow)

    return probMatrix




def terminalStateFilter(matrix):
    """Determines terminal states"""
    terminalStates = []

    for row in range(len(matrix)):

        if all(x == 0 for x in matrix[row]):
            terminalStates.append(True)

        else:
            terminalStates.append(False)
            
    return terminalStates




def probDistributionVector(matrix, row, timesteps):
    """Calculates the probability distribution vector for the given number of timesteps"""
    vector = matrix[row]

    for i in range(timesteps):
        newVector = [sum(starmap(mul, zip(vector, col)))
                     for col in zip(*matrix)]
        vector = newVector

    return vector



def solution(m):

    if len(m) == 1:
        return [1, 1]

    probMatrix = convertMatrix(m)
    terminalStates = terminalStateFilter(m)
    probVector = probDistributionVector(probMatrix, 0, 100)

    numerators = []
    for i in probVector:
        numerator = fractions.Fraction(i).limit_denominator().numerator
        numerators.append(numerator)

    denominators = []
    for i in probVector:
        denominator = fractions.Fraction(i).limit_denominator().denominator
        denominators.append(denominator)

    factors = [max(denominators) / x for x in denominators]
    numeratorsTimesFactors = [a * b for a, b in zip(numerators, factors)]
    terminalStateNumerators = list(compress(numeratorsTimesFactors, terminalStates))

    # append numerators and denominator to answerList
    answerlist = []
    for i in terminalStateNumerators:
        answerlist.append(i)
    answerlist.append(max(denominators))

    return list(map(int, answerlist))


Fails test case 5 and 10.

Also failed case from comment 
m=[
[0, 7, 0, 17, 0, 1, 0, 5, 0, 2],
[0, 0, 29, 0, 28, 0, 3, 0, 16, 0],
[0, 3, 0, 0, 0, 1, 0, 0, 0, 0],
[48, 0, 3, 0, 0, 0, 17, 0, 0, 0],
[0, 6, 0, 0, 0, 1, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
]
Expected output=[4, 5, 5, 4, 2, 20],but code given output=[2, 2, 2, 2, 1, 10]

```

https://www.datacamp.com/community/tutorials/markov-chains-python-tutorial
https://calebfenton.github.io/2017/08/23/using-markov-chains-for-android-malware-detection/


https://www.geeksforgeeks.org/markov-matrix/
Approach : Initialize a 2D array, then take another single dimensional array to store the sum of each rows of the matrix, and check whether all the sum stored in this 1D array is equal to 1, if yes then it is Markov matrix else not.

```
static boolean checkMarkov(double m[][]) 
    { 
        // outer loop to access rows 
        // and inner to access columns 
        for (int i = 0; i < m.length; i++) { 
  
            // Find sum of current row 
            double sum = 0; 
            for (int j = 0; j < m[i].length; j++) 
                sum = sum + m[i][j]; 
  
            if (sum != 1) 
               return false; 
        } 
  
        return true; 
    } 
  
    public static void main(String args[]) 
    { 
        // Matrix to check 
        double m[][] = { { 0, 0, 1 }, 
                         { 0.5, 0, 0.5 }, 
                         { 1, 0, 0 } }; 
  
        // calls the function check() 
        if (checkMarkov(m)) 
            System.out.println(" yes "); 
        else
            System.out.println(" no "); 
    } 
} 
```

https://www.geeksforgeeks.org/c-program-multiply-two-matrices/?ref=leftbar-rightbar

Could be useful:
https://www.geeksforgeeks.org/finding-the-probability-of-a-state-at-a-given-time-in-a-markov-chain-set-2/


> Solution passes all test cases:
https://surajshetiya.github.io/Google-foobar/

```
from fractions import Fraction

def gcd(x, y):
    def gcd1(x, y):
        if y == 0:
            return x
        return gcd1(y, x%y)
    return gcd1(abs(x), abs(y))

def simplify(x, y):
    g = gcd(x, y)
    return Fraction(long(x/g), long(y/g))

def lcm(x, y):
    return long(x*y/gcd(x,y))

def transform(mat):
    sum_list = list(map(sum, mat))
    bool_indices = list(map(lambda x: x == 0, sum_list))
    indices = set([i for i, x in enumerate(bool_indices) if x])
    new_mat = []
    for i in range(len(mat)):
        new_mat.append(list(map(lambda x: Fraction(0, 1) if(sum_list[i] == 0) else simplify(x, sum_list[i]), mat[i])))
    transform_mat = []
    zeros_mat = []
    for i in range(len(new_mat)):
        if i not in indices:
            transform_mat.append(new_mat[i])
        else:
            zeros_mat.append(new_mat[i])
    transform_mat.extend(zeros_mat)
    tmat = []
    for i in range(len(transform_mat)):
        tmat.append([])
        extend_mat = []
        for j in range(len(transform_mat)):
            if j not in indices:
                tmat[i].append(transform_mat[i][j])
            else:
                extend_mat.append(transform_mat[i][j])
        tmat[i].extend(extend_mat)
    return [tmat, len(zeros_mat)]

def copy_mat(mat):
    cmat = []
    for i in range(len(mat)):
        cmat.append([])
        for j in range(len(mat[i])):
            cmat[i].append(Fraction(mat[i][j].numerator, mat[i][j].denominator))
    return cmat

def gauss_elmination(m, values):
    mat = copy_mat(m)
    for i in range(len(mat)):
        index = -1
        for j in range(i, len(mat)):
            if mat[j][i].numerator != 0:
                index = j
                break
        if index == -1:
            raise ValueError('Gauss elimination failed!')
        mat[i], mat[index] = mat[index], mat[j]
        values[i], values[index] = values[index], values[i]
        for j in range(i+1, len(mat)):
            if mat[j][i].numerator == 0:
                continue
            ratio = -mat[j][i]/mat[i][i]
            for k in range(i, len(mat)):
                mat[j][k] += ratio * mat[i][k]
            values[j] += ratio * values[i]
    res = [0 for i in range(len(mat))]
    for i in range(len(mat)):
        index = len(mat) -1 -i
        end = len(mat) - 1
        while end > index:
            values[index] -= mat[index][end] * res[end]
            end -= 1
        res[index] = values[index]/mat[index][index]
    return res

def transpose(mat):
    tmat = []
    for i in range(len(mat)):
        for j in range(len(mat)):
            if i == 0:
                tmat.append([])
            tmat[j].append(mat[i][j])
    return tmat

def inverse(mat):
    tmat = transpose(mat)
    mat_inv = []
    for i in range(len(tmat)):
        values = [Fraction(int(i==j), 1) for j in range(len(mat))]
        mat_inv.append(gauss_elmination(tmat, values))
    return mat_inv

def mat_mult(mat1, mat2):
    res = []
    for i in range(len(mat1)):
        res.append([])
        for j in range(len(mat2[0])):
            res[i].append(Fraction(0, 1))
            for k in range(len(mat1[0])):
                res[i][j] += mat1[i][k] * mat2[k][j]
    return res

def splitQR(mat, lengthR):
    lengthQ = len(mat) - lengthR
    Q = []
    R = []
    for i in range(lengthQ):
        Q.append([int(i==j)-mat[i][j] for j in range(lengthQ)])
        R.append(mat[i][lengthQ:])
    return [Q, R]

def answer(mat):
    res = transform(mat)
    if res[1] == len(mat):
        return [1, 1]
    Q, R = splitQR(*res)
    inv = inverse(Q)    
    res = mat_mult(inv, R)
    row = res[0]
    l = 1
    for item in row:
        l = lcm(l, item.denominator)
    res = list(map(lambda x: long(x.numerator*l/x.denominator), row))
    res.append(l)
    return res

```

All test cases: https://sskaje.me/2017/05/googles-foo-bar-doomsday-fuel

```python
assert (
    answer([
        [0, 2, 1, 0, 0],
        [0, 0, 0, 3, 4],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0]
    ]) == [7, 6, 8, 21]
)
 
assert (
    answer([
        [0, 1, 0, 0, 0, 1],
        [4, 0, 0, 3, 2, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0]
    ]) == [0, 3, 2, 9, 14]
)
 
assert (
    answer([
        [1, 2, 3, 0, 0, 0],
        [4, 5, 6, 0, 0, 0],
        [7, 8, 9, 1, 0, 0],
        [0, 0, 0, 0, 1, 2],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0]
    ]) == [1, 2, 3]
)
assert (
    answer([
        [0]
    ]) == [1, 1]
)
 
assert (
    answer([
        [0, 0, 12, 0, 15, 0, 0, 0, 1, 8],
        [0, 0, 60, 0, 0, 7, 13, 0, 0, 0],
        [0, 15, 0, 8, 7, 0, 0, 1, 9, 0],
        [23, 0, 0, 0, 0, 1, 0, 0, 0, 0],
        [37, 35, 0, 0, 0, 0, 3, 21, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]) == [1, 2, 3, 4, 5, 15]
)
 
assert (
    answer([
        [0, 7, 0, 17, 0, 1, 0, 5, 0, 2],
        [0, 0, 29, 0, 28, 0, 3, 0, 16, 0],
        [0, 3, 0, 0, 0, 1, 0, 0, 0, 0],
        [48, 0, 3, 0, 0, 0, 17, 0, 0, 0],
        [0, 6, 0, 0, 0, 1, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]) == [4, 5, 5, 4, 2, 20]
)
 
assert (
    answer([
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]) == [1, 1, 1, 1, 1, 5]
)
 
assert (
    answer([
        [1, 1, 1, 0, 1, 0, 1, 0, 1, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 0, 1, 1, 1, 0, 1, 0, 1, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 0, 1, 0, 1, 1, 1, 0, 1, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 0, 1, 0, 1, 0, 1, 1, 1, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 0, 1, 0, 1, 0, 1, 0, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]) == [2, 1, 1, 1, 1, 6]
)
 
assert (
    answer([
        [0, 86, 61, 189, 0, 18, 12, 33, 66, 39],
        [0, 0, 2, 0, 0, 1, 0, 0, 0, 0],
        [15, 187, 0, 0, 18, 23, 0, 0, 0, 0],
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]) == [6, 44, 4, 11, 22, 13, 100]
)
 
assert (
    answer([
        [0, 0, 0, 0, 3, 5, 0, 0, 0, 2],
        [0, 0, 4, 0, 0, 0, 1, 0, 0, 0],
        [0, 0, 0, 4, 4, 0, 0, 0, 1, 1],
        [13, 0, 0, 0, 0, 0, 2, 0, 0, 0],
        [0, 1, 8, 7, 0, 0, 0, 1, 3, 0],
        [1, 7, 0, 0, 0, 0, 0, 2, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]) == [1, 1, 1, 2, 5]
)
```


A good read on fractionon Java as there is not library like in Python.
https://codippa.com/how-to-work-with-fractions-in-java

https://www.javainterviewpoint.com/iterate-through-hashmap/


### Compare DEBUG VALUES

Analysing Python solution with the test case:

``` python
[
    [[1, 1, 1, 0, 1, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 1, 1, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 1, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 0, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 0, 1, 0, 1, 1],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
    [2, 1, 1, 1, 1, 6]
],
```

This test case is choosen because it fails in Java solution.


The Applications of Matrices | What I wish my teachers told me way earlier
https://www.youtube.com/watch?v=rowWM-MijXU

Essence of linear algebra
https://www.youtube.com/watch?v=fNk_zzaMoSs&list=PLZHQObOWTQDPD3MizzM2xVFitgF8hE_ab

Gaussian Elimination in slides
https://slides.com/miteshkhapra-2/cs6015_lecture4/fullscreen#/0/3/7


Solving Linear Systems, with code examples
http://www.math.umbc.edu/~campbell/Computers/Python/linalg.html


### Review After Submission 9th Dec.
Successfully submitted the solution but as I was still unable to grap the complete picture of what just happened I am reviewing the solution once again.

Taking the solution that failed in Java.
``` python
[
    [[1, 1, 1, 0, 1, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 1, 1, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 1, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 0, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 0, 1, 0, 1, 1],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
    [2, 1, 1, 1, 1, 6]
],
```

From the https://www.youtube.com/watch?v=qhnFHnLkrfA&list=PLANMHOrJaFxPMQCMYcYqwOCYlreFswAKP&index=9

We solve to find the **Limiting Matrix**.
https://www.probabilitycourse.com/chapter11/11_2_6_stationary_and_limiting_distributions.php
https://www.math.ucdavis.edu/~gravner/MAT135B/materials/ch15.pdf

To do so we follow the steps:
STEPS:
- Order the matrix so that rows start with terminal states first. Remember to sort the columns correctly too to reflect this so everything matches up.
- Now that you have done that you know how to find R and Q.
- Calculate F=(I-Q)⁻¹.
- Calculate FR.
- Get the first line of FR and then you have your probabilities.
- Find the common denominator and return the int array how the specification has asked it to be formatted.

https://github.com/ivanseed/google-foobar-help/blob/master/challenges/doomsday_fuel/doomsday_fuel.md

 0  1  2  3  4  5  6  7  8  9       total probability
[1, 1, 1, 0, 1, 0, 1, 0, 1, 0] 0    6
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 1    0
[1, 0, 1, 1, 1, 0, 1, 0, 1, 0] 2    6
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 3    0
[1, 0, 1, 0, 1, 1, 1, 0, 1, 0] 4    6
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 5    0
[1, 0, 1, 0, 1, 0, 1, 1, 1, 0] 6    6
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 7    0   
[1, 0, 1, 0, 1, 0, 1, 0, 1, 1] 8    6
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 9    0

Total probability of non-terminating states are 6, so 1/6 = 0.166, say p, is the probability.

Terminating States 1, 3, 5, 7, 9
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 1
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 3
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 5
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 7
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 9


Order Matrix
    1 3 5 7 9 0 2 4 6 8
1   0 0 0 0 0 0 0 0 0 0
3   0 0 0 0 0 0 0 0 0 0   
5   0 0 0 0 0 0 0 0 0 0
7   0 0 0 0 0 0 0 0 0 0
9   0 0 0 0 0 0 0 0 0 0

0   p 0 0 0 0 p p p p p
2   0 p 0 0 0 p p p p p          
4   0 0 p 0 0 p p p p p
6   0 0 0 p 0 p p p p p
8   0 0 0 0 p p p p p p

