
# Linear Algebra with Python by Robert Campbell 17 Nov, 2013 
http://www.math.umbc.edu/~campbell/Computers/Python/linalg.html


# Contents:
Basic Matrix Operations
Solving Linear Systems
    Gaussian Elimination
    Back Substitution
    Pivoting
Triangularization & LU Decompositions
Eigenvalues & Eigenvectors
Packages for Linear Algebra in Python


The Python programming language has no built-in support for linear algebra, but it is fairly straightforward to write code which will implement as much as you need. The most obvious way to represent vectors and matrices are as lists and nested lists.

For serious numerical linear algebra, the best option is to install and use the NumPy package. A more flexible solution is to use SAGE, a Python-based symbolic algebra system which includes NumPy.
Basic Matrix Operations

A simple representation of a vector could be as a list and a matrix could be represented as a list of lists, for example:

>>> A = [[1.0,2.0],[3.0,4.0]]

could represent the matrix
[1.0   2.0]
[         ]
[3.0   4.0]

The simplest way to implement many matrix and vector operations is through list comprehensions. Two vectors, a matrix and a vector, or two matrices could be added and multiplied by:

```python
>>> v = [-1.0,3.0]
>>> A = [[1.0,2.0],[3.0,4.0]]
>>> B = [[3.0,-2.0],[2.0,1.0]]
>>> C = [[1.0,1.5,-2.0],[2.0,1.0,-1.0],[3.0,-1.0,2.0]]
>>> [[A[i][j]+B[i][j] for j in range(len(B[0]))] for i in range(len(A))]  # the matrix A+B
>>> sum(v[i]*v[i] for i in range(len(v)))  # the dot product v.v
>>> [sum(A[i][j]*v[j] for j in range(len(v))) for i in range(len(A))]  # the vector A*v
>>> [[sum(A[i][k]*B[k][j] for k in range(len(b))) for j in range(len(B[0]))] for i in range(len(A))]  # the matrix A*B
```

In all of these computations we assume that the dimensions of the matrices and vectors are appropriate. If not, the computation will either fail or return an incorrect value. Properly written code would check for matching dimensions and raise an exception otherwise.

Before going any further, we write a pair of short routines to display matrices and vectors in the more familiar format:

```python
>>> import string
>>> def vectfmt(thevect,fmt):
...    return string.join(['[']+[fmt.format(x) for x in thevect]+[']'],'')

>>> def matfmt(themat,fmt):
...    return string.join([vectfmt(x,fmt)+'\n' for x in themat],'')

So we can now format our matrices as:
>>> print vectfmt(v,'{:10.4f}')
[   -1.0000    3.0000]
>>> print matfmt(B,'{:8.4f}')
[  3.0000 -2.0000]
[  2.0000  1.0000]
```

### Solving Linear Systems
A system of linear equations can be converted to matrix form by deciding on a fixed order of the variables, and using the coefficients of each equation as the elements of a row of the matrix. Thus the system of equations

x + 3y + 2z = 4
2x - y + z = 1
3x + y - 2z = 2

can be represented by the matrix

[1.0   3.0   2.0   4.0]
[2.0  -1.0   1.0   1.0]
[3.0   1.0  -2.0   2.0]

which in turn can be represented in Python as

```python
>>> D = [[1.0, 3.0, 2.0, 4.0], [2.0, -1.0, 1.0, 1.0], [3.0, 1.0, -2.0, 2.0]]
```

This form, where the constant terms are explicitly viewed as coefficients, and hence form a column of the matrix is called an augmented matrix. One approach to solving a system of linear equations is to form the augmented matrix and manipulate it.

A second approach is to form a matrix A of the non-constant coefficients of the equations, and a separate vector c consisting of the constant terms. The problem now is to find the vector v such that A*v=c.

No matter how the system is moved to matrix form the problem is made more difficult by the lack of guarantee that such a vector exists or that it is unique.

### Gaussian Elimination
The basic operation of Gaussian elimination is to subtract some multiple of a row of a matrix from some other row, replacing the second row with the result. This can be implemented in Python as:

```python
>>> C[1] = [C[1][i]-2.0*C[0][i] for i in range(len(C[0]))]
>>> print matfmt(C,'{:8.4f}')
[  1.0000  1.5000 -2.0000]
[  0.0000 -2.0000  3.0000]
[  3.0000 -1.0000  2.0000]
```

This operation can be used to zero out part of the resulting row. This is equivalent to eliminating a variable from the equation the row represents. Gaussian reduction is a way to systematically zero out the lower left corner of the matrix. This puts the matrix in what is called "triangular" form, as the non-zero values in the matrix are now limited to the upper-right triangle. When this is done, the final row will represent an equation with very few variables. If only a single variable remains, then this equation can be solved for the remaining variable.

Gaussian elimination works a column at a time, working from left to right. For each column, rows are manipulated so that the column has only zeroes below the diagonal of the matrix. When working on the ith column, multiples of the ith row are subtracted from lower rows. The appropriate multiple to use when working on the jth row will be the ratio of the ith element of the ith row divided by the ith element of the ith row.

```python
>>> C = [[1.0,1.5,-2.0],[2.0,1.0,-1.0],[3.0,-1.0,2.0]]
>>> m = C[1][0]/C[0][0]   # Ratio of (1,0) element by (0,0) element
>>> C[1] = [C[1][i]-m*C[0][i] for i in range(len(C[0]))]
>>> print matfmt(C,'{:8.4f}')
[  1.0000  1.5000 -2.0000]
[  0.0000 -2.0000  3.0000]
[  3.0000 -1.0000  2.0000]
>>> m = C[2][0]/C[0][0]   # Ratio of (2,0) element by (0,0) element
>>> C[2] = [C[2][i]-m*C[0][i] for i in range(len(C[0]))]
>>> print matfmt(C,'{:8.4f}')
[  1.0000  1.5000 -2.0000]
[  0.0000 -2.0000  3.0000]
[  0.0000 -5.5000  8.0000]
>>> m = C[2][1]/C[1][1]   # Ratio of (2,1) element by (0,1) element
>>> C[2] = [C[2][i]-m*C[1][i] for i in range(len(C[1]))]
>>> print matfmt(C,'{:8.4f}')
[  1.0000  1.5000 -2.0000]
[  0.0000 -2.0000  3.0000]
[  0.0000  0.0000 -0.2500]
```

The result is a systematic approach to diagonalizing a matrix. Written as a Python routine this takes the form:

```python
def gausselim1(themat):
   for i in range(len(themat[0])):
      for j in range(i+1,len(themat)):
         m = themat[j][i]/themat[i][i]   # Ratio of (i,j) elt by (i,i) (diagonal) elt
         themat[j] = [themat[j][k]-m*themat[i][k] for k in range(len(themat[0]))]
```


### Back Substitution

### Pivoting
But the Gaussian Reduction algorithm requires dividing by the value of a matrix element. If this element is zero the operation and algorithm will fail. The first thing we might try to avoid this is to see if there is a another row below this one whose corresponding element is non-zero, and swap the two rows. Swapping the rows is equivalent to swapping the order of the equations in the linear system - it should not affect the answer. This procedure is called "row pivoting" and the element that you end up dividing by is called the pivot.

```python
def gausselim2(themat): # Basic row pivoting
   m = len(themat); n = len(themat[0])
   for j in range(min(n,m)):  # for each column on the main diag
      if(themat[j][j]==0): # Find a non-zero pivot and swap rows
         thecolumn = [themat[k][j] for k in range(j,m)]
         ipivot = thecolumn.index(max(thecolumn))
         temp = themat[j]; themat[j] = themat[ipivot]; themat[ipivot] = temp
      for i in range(j+1,m):
         c = themat[i][j]/themat[j][j]   # Ratio of (i,j) elt by (j,j) (diagonal) elt
         themat[i] = [themat[i][k]-c*themat[j][k] for k in range(n)]
   return themat
```

Pivoting is also used in numerical linear algebra when the original pivot element was small but not zero. By moving a larger element in as the pivot the error in the computation is reduced.
OK - I guess I should take the time to actually write this page
Triangularization & LU Decompositions

```python
  def TriSimple(mm):  # Simple matrix triangularization, fields, no pivoting
        n = len(mm); m = len(mm[0]); 
        for i in range(min(n,m)):
                print map(lambda y: map(lambda x:"{0:.2f}".format(x),y),mm)
                for j in range(i+1,n):
                        for k in range(i,m):
                                mm[j][k] = mm[j][k] - (mm[j][i]/mm[i][i])*mm[i][k]
        return mm

```


### Appendices:
Packages for Linear Algebra in Python

A number of authors have implemented packages for linear algebra operations in Python. A partial list is:

NumPy - An extensive Python library for numerical linear algebra. Now embedded in the larger SciPy package, and also accessible through the SAGE symbolic algebra system.
[http://numpy.scipy.org/]

Linear algebra in NumPy 
[http://docs.scipy.org/doc/numpy/reference/routines.linalg.html] 

SAGE - A Python-based symbolic algebra system which implements (among other things) both numerical linear algebra and linear algebra over more general algebraic structures.
[http://www.sagemath.org/]

Linear Algebra Tutorial in SAGE [http://www.sagemath.org/doc/tutorial/tour_linalg.html]

Linear Algebra Constructions [http://www.sagemath.org/doc/constructions/linear_algebra.html] 

Basic Matrix Class (Bill McNeill) - A basic pure Python class implementing matrix operations and basic linear algebra.
[http://code.activestate.com/recipes/189971-basic-linear-algebra-matrix/] 


# My Additional 

https://mathworld.wolfram.com/Gauss-JordanElimination.html
A method for finding a matrix inverse. To apply Gauss-Jordan elimination, operate on a matrix


https://mathworld.wolfram.com/Condensation.html
A method of computing the determinant of a square matrix due to Charles Dodgson (1866) (who is more famous under his pseudonym Lewis Carroll). The method is useful for hand calculations because, for an integer matrix, all entries in submatrices computed along the way must also be integers. The method is also implemented efficiently in a parallel computation. Condensation is also known as the method of contractants (Macmillan 1955, Lotkin 1959).

Given an n×n matrix, condensation successively computes an (n-1)×(n-1) matrix, an (n-2)×(n-2) matrix, etc., until arriving at a 1×1 matrix whose only entry ends up being the determinant of the original matrix. To compute the k×k matrix (n-1>=k>=1), take the k^2 2×2 connected subdeterminants of the (k+1)×(k+1) matrix and divide them by the k^2 central entries of the (k+2)×(k+2) matrix, with no divisions performed for k=n-1. The k×k matrices arrived at in this manner are the matrices of determinants of the k^2(n-k+1)×(n-k+1) connected submatrices of the original matrices. 