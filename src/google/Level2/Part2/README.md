# Problem

Bunny Prisoner Locating
=======================

Keeping track of Commander Lambda's many bunny prisoners is starting to get tricky. You've been tasked with writing a 
program to match bunny prisoner IDs to cell locations.

The LAMBCHOP doomsday device takes up much of the interior of Commander Lambda's space station, and as a result the prison 
blocks have an unusual layout. They are stacked in a triangular shape, and the bunny prisoners are given numerical IDs starting from the corner, as follows:

| 7
| 4 8
| 2 5 9
| 1 3 6 10

Each cell can be represented as points (x, y), with x being the distance from the vertical wall, and y being the height from the ground. 

For example, the bunny prisoner at (1, 1) has ID 1, the bunny prisoner at (3, 2) has ID 9, and the bunny prisoner at (2,3) has ID 8. This pattern of numbering continues indefinitely (Commander Lambda has been taking a LOT of prisoners). 

Write a function solution(x, y) which returns the prisoner ID of the bunny at location (x, y). Each value of x and y will be at least **1 and no greater than 100,000**. Since the prisoner ID can be very large, return your solution as a **string** representation of the number.


Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Java cases -- 
Input:
Solution.solution(3, 2)
Output:
    9

Input:
Solution.solution(5, 10)
Output:
    96


# Solution
Y
13 | 79 ** ** ** ** ?? 
12 | 67 80 
11 | 56 68 81
10 | 46 57 69 82 ** ** ** ** ** 181   
9  | 37 47 58 70 83          145 
8  | 29 38 48 59 71 84    113       
7  | 22 30 39 49 60 72 85
6  | 16 23 31 40 50 61 73 86  
5  | 11 17 24 32 41 51 62 74 87 ??
4  | 7  12 18 25 33 42 52 63 75 88
3  | 4  8  13 19 26 34 43 53 64 76 89
2  | 2  5  9  14 20 27 35 44 54 65 77 90
1  | 1  3  6  10 15 21 28 36 45 55 66 78 91 
   --------------------------------------------- 
   X 1  2  3  4  5  6  7  8  9  10 11 12 13

    


### Analysis

###### Coordiantes Values

   **Read from bottom, 1.**

   8. Diagonal Values
   1  5   13  25   41   61  85  113 145 181
   +4  +8  +12  +16  +20 +24  +28 +32  +36


   7. Second Row Value
   2  | 2  5  9  14 20 27 35 44 54 65 77 90 91
   X    1  2  3  4  5  6  7  8  9  10 11 12 13
   The values increases in a pattern: prev. value + (row+1)
   (2,2) = 2 + 3
   (2,3) = 5 + 4, and so on..


   6. Second Column Value
   13 | 92 
   12 | 80 
   11 | 68
   10 | 57
   9  | 47
   8  | 38
   7  | 30
   6  | 23
   5  | 17
   4  | 12
   3  | 8
   2  | 5
   1  | 3
      X 2 
   The logic is also same as of first column.
   First Column Value = Row + Column = 1 + 2
   Second, ... Values = Prev. Column Val + Column 
   Second Column Value = First Col. Val. + Column = 3 + 2 = 5
   13 Col. Val. = 12 Col. Val. + Column = 80 + 12 = 92



   5. First Row Value 
   Y 1  | 1  3  6  10 15 21 28 36 45 55 66 78 91 
   X      1  2  3  4  5  6  7  8  9  10 11 12 13 
   Row = Row + Prev. Value
   1   = 1 + 0
   2   = 2 + 1 = 3
   3   = 3 + 3 = 6
   4   = 4 + 6 = 10
   5   = 5 + 10 = 15
   6   = 6 + 15 = 21
   The current row value of first row is the 
   sum of numbers till that row, or prefix sum.


   4. First Column Value
   The first column value is the addition of
   previous column value to previous column
   number.
   13 | 79 = 67 + 12
   12 | 67 = 56 + 11
   11 | 56 = 46 + 10 
   10 | 46 = 37 + 9
   9  | 37 = 29 + 8
   8  | 29 = 22 + 7
   7  | 22 = 16 + 6
   6  | 16 = 11 + 5
   5  | 11 = 7 + 4 
   4  | 7  = 4 + 3
   3  | 4  
   2  | 2  
   1  | 1  
   The logic to the formula starts from third row.


   3. Coordinate Increment
   We want to know by how much the value needs
   to be added at specific coordinate as 
   we know the value increments by one but we
   want to get the value by a formula.
   For 6 row, the starting incremental value is 7.
   6,2 = 16 + 7,
   6,3 = (6,2) + 8
   6,4 = (6,3) + 9
   From row number we can determine the initial 
   incremental value, i.e. for 6 row it is 6+1 = 7,
   then the next value will be sum of previous 
   value + next incremental value as shown above.


   2. Value Increments
   At row 1, the value increments starts by 2 and +previous numbers for other values.
   1   3  6 10 15 21 28 36 45  55  66  78  91 
      +2 +3 +4 +5 +6 +7 +8 +9 +10 +11 +12 +13
   At row 2, the value increment starts by 3, and so on for other numbers.
   2  5  9  14  20  27  35  44  54  65  77  90
   +3 +4 +5  +6  +7  +8  +9  +10 +11 +12 +13
   And so on for other numbers.


   1. Square Coordinates
The value at square coordinate like (2,2) or (5,5) will be
sum of square of that coordiate + square of the number 
1 less than the coordiate.
At (7,7), the value is 85 = 7*7 + 6*6 = 49 + 36.
At (6,6), the value is 61 = 6*6 + 5*5 = 36 + 25.
Value of 10*10 =  10*10 + 9*9 = 100+81 = 181


###### Break Point
After finding some sequence and making some sense of
the problem, I wanted to find out if there was a specific
math formula and if this type of sequence even had some 
formal name.

With some search came to know this type of triangle
is called Floyd's Triangle, but the original is inverted.

https://stackoverflow.com/questions/39467778/how-do-you-find-which-row-and-column-a-number-belongs-to-in-floyd-triangle
https://en.wikipedia.org/wiki/Floyd%27s_triangle
   
   \/ 1   2   3   4  5
   1  1
   2  2   3
   3  4   5   6
   4  7   8   9   10
   5  11  12  13  14  15 

Provided problem triangle is flipped 180 degrees.

     11
     7 12
     4 8 13
     2 5 9 14
     1 3 6 10 15
     

The sum of row for Floyd's triangle is:
n(n^2 + 1)/2 = 7(7*7 + 1) = 7 * 50 =  350




###### Finding formula for a coordinate's value
https://github.com/besa96/2varFloydsTriangle/blob/master/floyds_triangle.c

Found more formulas for analysis
//(n² + n + 2) / 2           	Lazy caterer's sequence (left side of triangle) [n+1]

//n(n + 1) / 2                  Triangular number       (right side of triangle)

//n(n² + 1) / 2                	Floyd's triangle sum    (row sum)
//T(T(n))                   	Triangular's Triangular (total sum) [n=row]
//(√((8 * n) + 1)) / 2 - 0.5	Reverse Triangular


Lets try with 6
((n² + n + 2) / 2) = 22
The number generated is for (7,1)

((n² + n + 2) / 2) - 6 = 16 : Starting value
Substracting 6 gives value for (6,1)


n(n + 1) / 2  = 21 : End value
Value of (1,6)


n(n² + 1) / 2 = 111
The sum of diagonal for our triangle.
(6,1) to (6,6) : 16+17+18+19+20+21

(((8 * n) + 1)) / 2 - 0.5 = 3


There exists a series of number so I tried 
find if there would be an existing mathematical
formula. 

I searched with Arithmetic Sequence but continuing
the search to know more about the nature of the
arithmetic sequence, the problem was not about
arithmetic sequence as the difference between 
two consequtive numbers differs.

So searched for other forms of Geometric Sequence
and Linear Function.

The basis of this can be traced to the linear function. Some of the real-time samples are also based on the progressions and series. An arithmetic progression is formed by adding the same value to the previous number in order to obtain the next number. A linear function is used to establish a relationship with various other equations so as to obtain the solution.

The difference between an arithmetic sequence and a linear function is that an arithmetic sequence is a sequence of numbers increasing or decreasing with a constant difference whereas a linear function is a polynomial function.

https://askanydifference.com/difference-between-arithmetic-sequence-and-linear-function/


The key difference between Arithmetic and Geometric Sequence lies in the fact that while an arithmetic sequence has the difference between its two consecutive terms remains constant, a geometric sequence has the ratio between its two consecutive terms remains constant.

The difference between two consecutive terms in an arithmetic sequence is referred to as the common difference.

On the other hand, the ratio of two consecutive terms in a geometric sequence is referred to as the common ratio.

###### Table Extended
   15 | 106 122 139 157 176 
   14 | 92  107         158                                   365  
   13 | 79  93  108 124 141 159 178 198  219  241 264 288 313         
   12 | 67  80  94  109 125 **  **   **   **  **  **  256
   11 | 56  68  81  95  110 **  **   **   **      221 **  **
   10 | 46  57  69  82  96  111 127 144  162 181 201  
   9  | 37  47  58  70  83  97  112      145 
   8  | 29  38  48  59  71  84  98  113       
   7  | 22  30  39  49  60  72  85  99   114 130 147 165 184 204
   6  | 16  23  31  40  50  61  73  86   100 115             **  
   5  | 11  17  24  32  41  51  62  74   87  101             **
   4  | 7   12  18  25  33  42  52  63   75  88  102         **
   3  | 4   8   13  19  26  34  43  53   64  76  89  103     **
   2  | 2   5   9   14  20  27  35  44   54  65  77  90  104 **  
   1  | 1   3   6   10  15  21  28  36   45  55  66  78  91  105
      --------------------------------------------------------
   Y/X  1   2   3   4   5   6   7   8    9   10  11  12  13  14

###### Day 2: Working out a formula

Lets say we want to find(5,6), which is 50

The easiest way to move forward would be 
get the starting row value 5,1 and add the 
increment numbers. So the process would be
   1. First find the starting value of row, i.e. (X,1)
   so, n = 5
   `n(n + 1) / 2`  = 5*(5+1)/2 = 15

   2. Find the arithmetic sequence sum from towards column from (X,1)
   `(n*( 2*a + (n - 1) d))/2`
   Here the terms will be the (Y-1), 
   and n = Y-1, as Y=6, so n = 6-1 = 5
   (5*(2*5 + (5 - 1) *1))/2 = 35

    3. Sum 1 + 2 = 15 + 35 = 50
   
 

Lets try for another coordinate:  (3,9)
1. n(n + 1) / (2+1) = 3(3+1)/3 = 4
2. n=Y-1=9-1=8;d=1; (8*(2*4 + (8 - 1)))/2 = 60

(3,9) = 58, but got 60.
There is an issue while getting the value of(X,1)
1. n(n + 1) / 2 = 3(3+1)/2 = 6; So,
2. (n(2a + (n - 1) d))/2; n = Y-1 = 9-1 = 8; d=1; a=3; (8*(2*3 + (8 - 1)))/2 = 52
3. Sum =  6 + 52 = 58 :)

Lets try for another coordinate:  (12,13) = 
1. n(n + 1) / 2; n=12; 12(12+1)/2 = 78
2. (n(2a + (n - 1) d))/2; n = Y-1 = 13-1 = 12; d=1; a=12; (12*(2*12 + (12 - 1)))/2 = 210
3. Sum =  78 + 210 = 288 :)

Lets try for another coordinate:  (8,8) = 
1. n(n + 1) / 2; n=8; 8(8+1)/2 = 36
2. (n(2a + (n - 1) d))/2; n = Y-1 = 8-1 = 7; d=1; a=8; (7*(2*8 + (7 - 1)))/2 = 77
3. Sum =  36 + 77 = 113 :)


###### Formula for Sum of Arithmetic Sequence Formula
https://byjus.com/sum-of-arithmetic-sequence-formula 
There are two ways with which we can find the sum of the arithmetic sequence. The formulas for the sum of the arithmetic sequence are given below:
Sum of Arithmetic Sequence Formula
When the Last Term is Given 	S = n⁄2 (a + L)
When the Last Term is Not Given 	S = (n(2a + (n - 1) d))/2

Notations:

    “S” is the sum of the arithmetic sequence,
    “a” as the first term,
    “d” the common difference between the terms,
    “n” is the total number of terms in the sequence and
    “L” is the last term of the sequence.


# SOLVED
The solution is accepted.