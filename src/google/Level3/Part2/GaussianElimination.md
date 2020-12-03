
# Gaussian E

Gaussian elimination is a method for solving matrix equations of the form Ax=b.

The fundamental idea is to add multiples of one equation to the others in order to eliminate a variable and to continue this process until only one variable is left. Once this final variable is determined, its value is substituted back into the other equations in order to evaluate the remaining unknowns. This method, characterized by step‐by‐step elimination of the variables, is called Gaussian elimination.

x + y = 3
3 x − 2 y = 4

Coefficient Matrix 
[ 1, 1 ]
[ 3, 2 ]

Augmented Matrix
[ 1, 1 | 3 ]
[ 3, 2 | 4 ]

Gaussian elimination can be summarized as follows. Given a linear system expressed in matrix form, A x = b, first write down the corresponding augmented matrix: [ A | b ]

Then, perform a sequence of elementary row operations, which are any of the following:
Type 1. Interchange any two rows.
Type 2. Multiply a row by a nonzero constant.
Type 3. Add a multiple of one row to another row.

The goal of these operations is to transform—or reduce—the original augmented matrix into one of the form where A' is upper triangular (aij' = 0 for i > j), any zero rows appear at the bottom of the matrix, and the first nonzero entry in any row is to the right of the first nonzero entry in any higher row; such a matrix is said to be in echelon form. The solutions of the system represented by the simpler augmented matrix, [ A'|b' ], can be found by inspectoin of the bottom rows and back‐substitution into the higher rows. Since elementary row operations do not change the solutions of the system, the vectors x which satisfy the simpler system A'x = b' are precisely those that satisfy the original system, A x = b. 



https://www.dummies.com/education/math/calculus/how-to-use-gaussian-elimination-to-solve-systems-of-equations/
https://www.cliffsnotes.com/study-guides/algebra/linear-algebra/linear-systems/gaussian-elimination