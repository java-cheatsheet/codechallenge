# Problem

Your planned escape route - and your backup route,
and your extra-backup route - have all been blocked
by debris from the space station or Commander Lambda's
starfighters. Your only remaining option is to try
deep space, and to boldly go where no bunny has gone
before.

Disorderly Escape
=================

Oh no! You've managed to free the bunny workers
and escape Commander Lambdas exploding space
station, but Lambda's team of elite starfighters
has flanked your ship. If you dont jump to
hyperspace, and fast, you'll be shot out of
the sky!

Problem is, to avoid detection by galactic law
enforcement, Commander Lambda planted the space
station in the middle of a quasar quantum flux
field. In order to make the jump to hyperspace,
you need to know the configuration of celestial
bodies in the quadrant you plan to jump through.
In order to do *that*, you need to figure out
how many configurations each quadrant could
possibly have, so that you can pick the optimal
quadrant through which you'll make your jump.

There's something important to note about
quasar quantum flux fields' configurations:
when drawn on a star grid, configurations
are considered equivalent by grouping, rather
than by order. That is, for a given set of
configurations, if you exchange the position
of any two columns or any two rows some 
number of times, you'll find that all of 
those configurations are equivalent in that 
way -- in grouping, rather than order.

Write a function solution(w, h, s) that takes
3 integers and returns the number of unique,
non-equivalent configurations that can be
found on a star grid w blocks wide and h blocks
tall where each celestial body has s possible
states. Equivalency is defined as above: any
two star grids with each celestial body in the
same state where the actual order of the rows
and columns do not matter (and can thus be
freely swapped around). Star grid standardization
means that the width and height of the grid
will always be between 1 and 12, inclusive.
And while there are a variety of celestial
bodies in each grid, the number of states of
those bodies is between 2 and 20, inclusive.
The solution can be over 20 digits long, so
return it as a decimal string.  The intermediate
values can also be large, so you will likely
need to use at least 64-bit integers.

For example, consider w=2, h=2, s=2. We have
a 2x2 grid where each celestial body is either
in state 0 (for instance, silent) or state 1
(for instance, noisy).  We can examine which
grids are equivalent by swapping rows and columns.

00
00

In the above configuration, all celestial bodies
are "silent" - that is, they have a state of 0 -
so any swap of row or column would keep it in the
same state.

00 00 01 10
01 10 00 00

1 celestial body is emitting noise - that is, has
a state of 1 - so swapping rows and columns can
put it in any of the 4 positions.  All four of
the above configurations are equivalent.

00 11
11 00

2 celestial bodies are emitting noise side-by-side.
Swapping columns leaves them unchanged, and swapping
rows simply moves them between the top and bottom.
In both, the *groupings* are the same: one row with
two bodies in state 0, one row with two bodies in
state 1, and two columns with one of each state.

01 10
01 10

2 noisy celestial bodies adjacent vertically.
This is symmetric to the side-by-side case,
but it is different because there's no way to
transpose the grid.

01 10
10 01

2 noisy celestial bodies diagonally. Both
have 2 rows and 2 columns that have one of
each state, so they are equivalent to each
other.

01 10 11 11
11 11 01 10

3 noisy celestial bodies, similar to the
case where only one of four is noisy.

11
11

4 noisy celestial bodies.

There are 7 distinct, non-equivalent grids
in total, so solution(2, 2, 2) would return 7.

Languages
=========

To provide a Java solution, edit Solution.java
To provide a Python solution, edit solution.py

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden
test cases not shown here.

-- Java cases --
Input:
Solution.solution(2, 3, 4)
Output:
    430

Input:
Solution.solution(2, 2, 2)
Output:
    7

-- Python cases --
Input:
solution.solution(2, 3, 4)
Output:
    430

Input:
solution.solution(2, 2, 2)
Output:
    7

Use verify [file] to test your solution and
see how it does. When you are finished editing
your code, use submit [file] to submit your
answer. If your solution passes the test cases,
it will be removed from your home folder.
+

# Solution


Good problem description.
```txt
Mathematics Description

This part is better read with nicely typeset formulas. See a concise explanation here where links to further reading are given.

    Let me add a reference directly here: For example Harary and Palmer's Graphical enumeration, Chapter 2.

In short, there is a set (the whole set of h x w-matrices, where the entries can take any of s different values) and a group of permutations that transforms some matrices in others. In the problem the group consists of all permutations of rows and/or columns of the matrices.

The set of matrices gets divided into classes of matrices that can be transformed into one another. The goal of the problem is to count the number of these classes. In technical terminology the set of classes is called the quotient of the set by the action of the group, or orbit space.

The good thing is that there is a powerful theorem (with many generalizations and versions) that does exactly that. That is Polya's enumeration theorem. The theorem expresses the number of elements of the orbit space in terms of the value of a polynomial known in the area as Cycle Index. Now, in this problem the group is a direct product of two special groups the group of all permutations of h and w elements, respectively. The Cycle Index polynomials for these groups are known, and so are formulas for computing the Cycle Index polynomial of the product of groups in terms of the Cycle Index polynomials of the factors.

Maybe a comment worth making that motivates the name of the polynomial is the following: Every permutation of elements can be seen as cycling disjoint subsets of those elements. For example, a permutation of (1,2,3,4,5) and can be (2,3,1,5,4), where we mean that 2 moved to the position of 1, 3 moved to the position of 2, 1 to the position of 3, 5 to the position of 4 and 4 to the position of 5. The effect of this permutation is the same as cycling 1-> 3 -> 2 and 2 back to 1, and cycling 4 -> 5 and 5 back to 4. Similar to how natural numbers can be factored into a product of prime factors, each permutation can be factored into disjoint cycles. For each permutation, the cycles are unique in a sense for each permutation. The Cycle Index polynomial is computed in terms of the number of cycles of each length for each permutation in the group.

Putting all these together we get that the total count is given by the last formula in the link.

Implementation

As seen in the final formula, we need to compute:

    Partitions of a number
    Greatest common divisors (gcd) of many numbers.
    Factorials of many numbers.

For these, we can do:

    To compute all partitions one can use the iterative algorithms here. Already written in Python here.
    An efficient way to compute gcd one could use Euclidean algorithm. However, since we are going to need the gcd of all pairs of numbers in a range and each one many times. It is better to pre-compute the full table of gcd all at once by dynamic programming. If a>b, then gcd(a,b)=gcd(a-b,b). This recurrence equation allows to compute gcd of larger pairs in terms of that of smaller pairs. In the table, one has the initial values gcd(1,a)=gcd(a,1)=1 and gcd(a,a)=a, for all a.
    The same happens for factorials. The formula will require the factorials of all numbers in a range many times each. So, it is better to compute them all from the bottom up using that n! = n(n-1)! and 0!=1!=1.
```

Solutoion with good comments to describe the process.
```python
from collections import Counter

def buildGCDTable(n):
    """
    Build the gcd table for all pairs (x,y) with x,y <= n.
    """
    result = [[0 for x in range(n)] for y in range(n)]
    for i in range(n):
        for j in range(i,n):
            if i == 0 or j == 0:
                result[i][j] = 1
                result[j][i] = 1
            elif i == j:
                result[i][j] = i+1
            else:
                result[i][j] = result[i][j-i-1]
                result[j][i] = result[i][j-i-1]
    return result

def gcd(x,y, gcdTable):
    """
    Because we are going to need the gcd of many 
    pairs of numbers we compute the full gcd table 
    of the numbers that we need, instead of applying 
    Euclid's algorithm for each pair.
    Note that Euclid's algorithm essentially computes, 
    for large inputs, the gcd of many smaller values 
    too. Since we need them all, we compute them bottom 
    up, as in Dynamic Programming.
    """
    return gcdTable[x-1][y-1]

def buildFactorialTable(n):
    """
    Build the factorials of all the numbers 1,2,3,...,n
    We will need them all. So, lets compute them also
    bottom up, as in Dynamic Programming.
    """
    result = [1]
    for i in range(n-1):
        result.append(result[-1]*(i+2))
    return result

def factorial(x, factorialTable):
    """
    Read from the pre-computed table.
    """
    return factorialTable[x-1]

def coefficientFactor(c, n,factorialTable):
    """
    Computes 
    
        n!/(1^{i_1}i_1!2^{i_2}i_2!...n^{i_n}i_n!)
    where c is a partition of n that has 
    i_1 1s, i_2 2s, ..., and i_n ns.
    """
    cc=factorial(n,factorialTable)
    for a, b in Counter(c).items():
        cc//=(a**b)*factorial(b,factorialTable)
    return cc

def partitionsAndCycleCount(n, factorialTable):
    """
    Iterative algorithm to generate all partitions 
    of the positive integer n.
    
    In addition to each partition, we compute the 
    following number:
        if the partition has i_1 1s, i_2 2s, ..., i_n ns, 
        we compute
        n!/(1^{i_1}i_1!2^{i_2}i_2!...n^{i_n}i_n!)
    
    This algorithm comes from https://arxiv.org/abs/0909.2331.
    """
    k = 0  # Index of last element in a partition 
    p = n*[0] # To store a partition in p[0:k+1]
    p[0] = n  # First partition is [n]
    result = [] # To store all partitions
    # The loop stops when the current partition has all 1s 
    a = [0 for i in range(n + 1)]
    k = 1
    y = n - 1
    result = []
    while k != 0:
        x = a[k - 1] + 1
        k -= 1
        while 2 * x <= y:   
            a[k] = x
            y -= x
            k += 1
        l = k + 1
        while x <= y:
            a[k] = x
            a[l] = y
            partition = a[:k+2]
            result.append((partition, coefficientFactor(partition,n,factorialTable)))
            x += 1
            y -= 1
        a[k] = x + y
        y = x + y - 1
        partition = a[:k+1]
        result.append((partition, coefficientFactor(partition,n,factorialTable)))
    return result

def solution(w, h, s):
    # We are going to need the gcd for all pairs of numbers (a,b)
    # with a<= w and b <= h. So, let's compute them all.
    n = max(w,h)
    
    gcdTable = buildGCDTable(n)

    # We will also need the factorials of all numbers 1,2,...,max(w,h)
    factorialTable = buildFactorialTable(n)
    
    # Consider G=S_w\times S_h, acting on X=W\times H, where 
    # W={1,2,...,w}, H={1,2,...,h}, S_w and S_h are the symmetric group
    # acting as permutations of W and H, respectively.
    # Each matrix is a function f\in S^X, f:X to S, where 
    # S={1,2,...,s}.
    # G acts on S^X, by (gf)(x)=f(gx) for g\in G and f\in S^X.
    # We need to compute the orbits of G in S^X.
    # Polya's enumeration theorem, tell us how to obtain it 
    # from the Cycle Index Polynomial of the group action.
    # See https://franklinvp.github.io/2020-06-05-PolyaFooBar/
    # for the formula.

    grid=0
    for cpw in partitionsAndCycleCount(w,factorialTable):
        for cph in partitionsAndCycleCount(h,factorialTable):
            m=cpw[1]*cph[1]
            grid+=m*(s**sum([sum([gcd(i, j, gcdTable) for i in cpw[0]]) for j in cph[0]]))
    return str(grid//(factorial(w,factorialTable)*factorial(h,factorialTable)))
```

Another solution that I find simpler. 
```python
from collections import Counter

def answer(w, h, s):    
    grid=0
    for pw in partitions(w):
        for ph in partitions(h):            
            m=count(pw, w)*count(ph, h)
            grid+=m*(s**sum([sum([gcd(i, j) for i in pw]) for j in ph]))
              
    return grid//(factorial(w)*factorial(h))
    
def count(c, n):
    cnt=factorial(n)
    for a, b in Counter(c).items():
        cnt//=(a**b)*factorial(b)
    return cnt        

def partitions(n, i=1):
    yield [n]
    for i in range(i, n//2 + 1):
        for p in partitions(n-i, i):
            yield [i] + p

def gcd(x,y):
    while y:
        x,y=y,x%y
    return x

def factorial(n):
    if n==0:
        return 1
    else:
        return n*factorial(n-1)
```

Description of problem of similar sorts.

Problem: Coloring a rectangle with 3 rows and 4 columns using two colors.
```txt
I want to color a 3x4 rectangle using 2 colors. The number of squares colored by each color must equal 6. However, we say that two colorings are equal if they can be obtained from each other by permutating rows or by cyclically permutating columns, e.g.
1011    0001
1000 =  1001   
0110    1110

Solution1:
First you have to work out in what ways you can transform one of your rectangles in general. You can cyclicly permute the columns in 4 ways, and permute the rows in 6 ways. You can combine these (in either order) to get 24 ways in which a rectangle can be transformed. Each of those 24 ways may or may not actually result in a different pattern. I'll denote the transformation by [r,c] where r is the row permutation, and c

is the column permutation.

For each of those 24 transformations [r,c]
you now have to count how many of the rectangles remain unchanged.

Solution2:
There are, as you noted, 924 ways to colour the grid if you ignore symmetry.

The symmetries give a group action on those 924 colorings, you want to count the orbits of that action.

Burnside's counting lemma says that to count the orbits, you can average the number of colourings fixed by each element of the group.

The symmetry group is S_3 × S_4, which has 144 elements, so that's a lot of work, but you can simplify things a bit as follows.

Instead of counting orbits of the 924 colourings, you realise that the action of S_4 preserves the column counts, so a colouring with 3 in one column, 2 in another, 1 in a third column and 0 in a fourth column will always have those counts, no matter how you permute the rows and columns. So, I'll count colourings with those numbers of coloured squares in the first, second, third and fourth columns respectively, and average the number of such colourings fixed by each element of S_3.
```

Simple solution for counting neckalces configurations with N stones and M colors.
```java
class GFG{

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
            
        return gcd(b % a, a);
    }

    // Function to find result using
    // Orbit counting theorem
    // or Burnside's Lemma
    static void countDistinctWays(int N, int M)
    {
        int ans = 0;

        // According to Burnside's Lemma
        // calculate distinct ways for each
        // rotation
        for(int i = 0; i < N; i++)
        {
            // Find GCD
            int K = gcd(i, N);
            ans += Math.pow(M, K);
        }

        ans /= N;
        System.out.print(ans);
    }

    public static void main(String []args)
    {
        int N = 4, M = 3;
        countDistinctWays(N, M);
    }
}
```

## Final Submitted Solution
```python
from collections import Counter

def solution(w, h, s):
    '''
    Le's consider G = S_w times S_h, acting on X = W times H, 
    where W = {1,2,...,w}, H = {1,2,...,h}, S_w and S_h 
    are the symmetric group acting as permutations of 
    W and H, respectively.

    Each matrix is a function f in S^X, f:X to S, 
    where S={1,2,...,s}.
    
    G acts on S^X, by (gf)(x)=f(gx) for g in G and f 
    in S^X.
    
    We need to compute the orbits of G in S^X.
    
    We use Polya's enumeration theorem to obtain it from 
    the Cycle Index Polynomial of the group action.
    '''
    grid=0
    n = max(w,h)    
    facTbl = factorialTable(n)
    gcdTbl = gcdTable(n)

    for pw in partition(w):
        for ph in partition(h):

            coe = coefficient(pw, w, facTbl) * coefficient(ph, h, facTbl)

            grid += coe*(s**sum([sum([gcd(i, j, gcdTbl) for i in pw]) for j in ph]))

    return str(grid // (factorial(w, facTbl) * factorial(h, facTbl)))
    
def coefficient(c, n, factorialTable):
    """
    Computes coefficient factorial.
    
    Mathematically:
        n!/(1^{i_1}i_1!2^{i_2}i_2!...n^{i_n}i_n!)

    where c is a partition of n that has 
        i_1 1s, i_2 2s, ..., and i_n ns.
    """

    coe=factorial(n, factorialTable)
    for a, b in Counter(c).items():
        coe//=(a**b)*factorial(b, factorialTable)
    return coe        

def partition(n, i=1):
    '''
    Partitions a number into it's sum of numbers
    (greater than 0).

    Example: 3 can be partitioned as: 1+1+1, 2+1
    '''
    yield [n]
    for i in range(i, n//2 + 1):
        for p in partition(n-i, i):
            yield [i] + p

def gcdTable(n):
    x=[0 for x in range(n)]
    result = [[0 for x in range(n)] for y in range(n)]

    for i in range(n):
        for j in range(i,n):
            if i == 0 or j == 0:
                result[i][j] = 1
                result[j][i] = 1
            elif i == j:
                result[i][j] = i+1
            else:
                result[i][j] = result[i][j-i-1]
                result[j][i] = result[i][j-i-1]
    return result

def gcd(x,y, gcdTable):
    return gcdTable[x-1][y-1]

def factorialTable(n):
    result = [1]
    for i in range(n-1):
        result.append(result[-1]*(i+2))
    return result

def factorial(x, factorialTable):
    return factorialTable[x-1]

```

I believe that there is more places to improve 
the code. One sure place I think can be reviewed
is partition(). As the partition is generating,
partitions of the numbers, which probably can 
be generated and stored like GCD and Factorials.
And even the partition logic can be improved.

I will leave this for further continued research.

# Resources
- https://franklinvp.github.io/2020-06-05-PolyaFooBar
- https://github.com/cbrowncodes/Disorderly_Escape/blob/master/Disorderly_Escape.py
- https://bogobogosort.wordpress.com/2018/03/30/completing-google-foobar, https://github.com/pijel/assorted-algos/blob/master/foobar_5.py   
- https://github.com/nhulbert/DisorderlyEscape/blob/master/src/disorderly/DisorderlyEscape.java
- https://stackoverflow.com/questions/61689832/disorderly-escape-google-foobar-2020-not-passing-test-cases#62478260
- https://math.stackexchange.com/questions/2403174/coloring-a-rectangle-with-3-rows-and-4-columns-using-two-colors
- https://puzzling.stackexchange.com/questions/54433/combinations-of-pentagons-on-a-3-by-3-dot-grid-how-to-use-burnsides-lemma?newreg=226d9eea75ce415f9691191281952caf
- https://www.geeksforgeeks.org/orbit-counting-theorem-or-burnsides-lemma
- https://mathoverflow.net/questions/50033/intuitive-explanation-of-burnsides-lemma?newreg=18f301a02daf4a9a9580a919ae0b1d30
- https://github.com/xphoniex/Google-Foobar/issues/5
- https://www.sciencedirect.com/science/article/pii/0012365X75900412
- https://cp-algorithms.com/combinatorics/burnside.html
- 