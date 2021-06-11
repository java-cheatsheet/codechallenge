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
are considered equivalent by grouping rather
than by order. That is, for a given set of
configurations, if you exchange the position
of any two columns or any two rows some number
of times, you'll find that all of those configurations
are equivalent in that way -- in grouping,
rather than order.

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


# Solution

'''txt
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
'''

'''python
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
    Because we are going to need the gcd of many pairs of numbers
    we compute the full gcd table of the numbers that we need, instead 
    of applying Euclid's algorithm for each pair.
    Note that Euclid's algorithm essentially computes, for large inputs, the gcd
    of many smaller values too. Since we need them all, we compute them
    bottom up, as in Dynamic Programming.
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
    Iterative algorithm to generate all partitions of 
    the positive integer n.
    In addition to each partition, we compute the following number:
        if the partition has i_1 1s, i_2 2s, ..., i_n ns, we compute
        n!/(1^{i_1}i_1!2^{i_2}i_2!...n^{i_n}i_n!)
    This algorithm comes from https://arxiv.org/abs/0909.2331
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
'''
  - https://stackoverflow.com/questions/61689832/disorderly-escape-google-foobar-2020-not-passing-test-cases#62478260 
  - https://franklinvp.github.io/2020-06-05-PolyaFooBar


## Combinatorics
 - https://en.wikipedia.org/wiki/Combinatorics 

Combinatorics is involved with:
- The enumeration (counting) of specified structures, sometimes referred to as arrangements or configurations in a very general sense, associated with finite systems,
- The existence of such structures that satisfy certain given criteria,
- The construction of these structures, perhaps in many ways, 
- optimization, finding the "best" structure or solution among several possibilities, be it the "largest", "smallest" or satisfying some other optimality criterion.

### Approaches And Subfields
#### Enumerative combinatorics
Five binary trees on three vertices, an example of Catalan numbers.
Enumerative combinatorics is the most classical area of combinatorics and concentrates on counting the number of certain combinatorial objects. Although counting the number of elements in a set is a rather broad mathematical problem, many of the problems that arise in applications have a relatively simple combinatorial description. Fibonacci numbers is the basic example of a problem in enumerative combinatorics. The twelvefold way provides a unified framework for counting permutations, combinations and partitions.

#### Analytic combinatorics
Analytic combinatorics concerns the enumeration of combinatorial structures using tools from complex analysis and probability theory. In contrast with enumerative combinatorics, which uses explicit combinatorial formulae and generating functions to describe the results, analytic combinatorics aims at obtaining asymptotic formulae.

#### Partition theory
A plane partition.

Partition theory studies various enumeration and asymptotic problems related to integer partitions, and is closely related to q-series, special functions and orthogonal polynomials. Originally a part of number theory and analysis, it is now considered a part of combinatorics or an independent field. It incorporates the bijective approach and various tools in analysis and analytic number theory and has connections with statistical mechanics.

#### Graph theory
Petersen graph.
Graphs are fundamental objects in combinatorics. Considerations of graph theory range from enumeration (e.g., the number of graphs on n vertices with k edges) to existing structures (e.g., Hamiltonian cycles) to algebraic representations (e.g., given a graph G and two numbers x and y, does the Tutte polynomial TG(x,y) have a combinatorial interpretation?). Although there are very strong connections between graph theory and combinatorics, they are sometimes thought of as separate subjects.[20] While combinatorial methods apply to many graph theory problems, the two disciplines are generally used to seek solutions to different types of problems.

#### Design theory
Design theory is a study of combinatorial designs, which are collections of subsets with certain intersection properties. Block designs are combinatorial designs of a special type. This area is one of the oldest parts of combinatorics, such as in Kirkman's schoolgirl problem proposed in 1850. The solution of the problem is a special case of a Steiner system, which systems play an important role in the classification of finite simple groups. The area has further connections to coding theory and geometric combinatorics.

#### Finite geometry
Finite geometry is the study of geometric systems having only a finite number of points. Structures analogous to those found in continuous geometries (Euclidean plane, real projective space, etc.) but defined combinatorially are the main items studied. This area provides a rich source of examples for design theory. It should not be confused with discrete geometry (combinatorial geometry).

#### Order theory
Hasse diagram of the powerset of {x,y,z} ordered by inclusion.
Order theory is the study of partially ordered sets, both finite and infinite. Various examples of partial orders appear in algebra, geometry, number theory and throughout combinatorics and graph theory. Notable classes and examples of partial orders include lattices and Boolean algebras.

#### Matroid theory
Matroid theory abstracts part of geometry. It studies the properties of sets (usually, finite sets) of vectors in a vector space that do not depend on the particular coefficients in a linear dependence relation. Not only the structure but also enumerative properties belong to matroid theory. Matroid theory was introduced by Hassler Whitney and studied as a part of order theory. It is now an independent field of study with a number of connections with other parts of combinatorics.

#### Extremal combinatorics
Extremal combinatorics studies extremal questions on set systems. The types of questions addressed in this case are about the largest possible graph which satisfies certain properties. For example, the largest triangle-free graph on 2n vertices is a complete bipartite graph Kn,n. Often it is too hard even to find the extremal answer f(n) exactly and one can only give an asymptotic estimate.

Ramsey theory is another part of extremal combinatorics. It states that any sufficiently large configuration will contain some sort of order. It is an advanced generalization of the pigeonhole principle.

#### Probabilistic combinatorics
Self-avoiding walk in a square grid graph.
In probabilistic combinatorics, the questions are of the following type: what is the probability of a certain property for a random discrete object, such as a random graph? For instance, what is the average number of triangles in a random graph? Probabilistic methods are also used to determine the existence of combinatorial objects with certain prescribed properties (for which explicit examples might be difficult to find), simply by observing that the probability of randomly selecting an object with those properties is greater than 0. This approach (often referred to as the probabilistic method) proved highly effective in applications to extremal combinatorics and graph theory. A closely related area is the study of finite Markov chains, especially on combinatorial objects. Here again probabilistic tools are used to estimate the mixing time.

Often associated with Paul Erdős, who did the pioneering work on the subject, probabilistic combinatorics was traditionally viewed as a set of tools to study problems in other parts of combinatorics. However, with the growth of applications to analyze algorithms in computer science, as well as classical probability, additive number theory, and probabilistic number theory, the area recently grew to become an independent field of combinatorics.

#### Algebraic combinatorics
Young diagram of a partition (5,4,1).

Algebraic combinatorics is an area of mathematics that employs methods of abstract algebra, notably group theory and representation theory, in various combinatorial contexts and, conversely, applies combinatorial techniques to problems in algebra. Algebraic combinatorics is continuously expanding its scope, in both topics and techniques, and can be seen as the area of mathematics where the interaction of combinatorial and algebraic methods is particularly strong and significant.

#### Combinatorics on words
Construction of a Thue–Morse infinite word.

Combinatorics on words deals with formal languages. It arose independently within several branches of mathematics, including number theory, group theory and probability. It has applications to enumerative combinatorics, fractal analysis, theoretical computer science, automata theory, and linguistics. While many applications are new, the classical Chomsky–Schützenberger hierarchy of classes of formal grammars is perhaps the best-known result in the field.

#### Geometric combinatorics
An icosahedron.

Geometric combinatorics is related to convex and discrete geometry, in particular polyhedral combinatorics. It asks, for example, how many faces of each dimension a convex polytope can have. Metric properties of polytopes play an important role as well, e.g. the Cauchy theorem on the rigidity of convex polytopes. Special polytopes are also considered, such as permutohedra, associahedra and Birkhoff polytopes. Combinatorial geometry is an old fashioned name for discrete geometry.

#### Topological combinatorics
Splitting a necklace with two cuts.

Combinatorial analogs of concepts and methods in topology are used to study graph coloring, fair division, partitions, partially ordered sets, decision trees, necklace problems and discrete Morse theory. It should not be confused with combinatorial topology which is an older name for algebraic topology.

#### Arithmetic combinatorics
Arithmetic combinatorics arose out of the interplay between number theory, combinatorics, ergodic theory, and harmonic analysis. It is about combinatorial estimates associated with arithmetic operations (addition, subtraction, multiplication, and division). Additive number theory (sometimes also called additive combinatorics) refers to the special case when only the operations of addition and subtraction are involved. One important technique in arithmetic combinatorics is the ergodic theory of dynamical systems.

#### Infinitary combinatorics
Infinitary combinatorics, or combinatorial set theory, is an extension of ideas in combinatorics to infinite sets. It is a part of set theory, an area of mathematical logic, but uses tools and ideas from both set theory and extremal combinatorics.

Gian-Carlo Rota used the name continuous combinatorics to describe geometric probability, since there are many analogies between counting and measure. 

## Partition
 - https://en.wikipedia.org/wiki/Partition_(number_theory)

A partition of a positive integer n, also called an integer partition, is a way of writing n as a sum of positive integers. Two sums that differ only in the order of their summands are considered the same partition. (If order matters, the sum becomes a composition.) For example, 4 can be partitioned in five distinct ways:
    4
    3 + 1
    2 + 2
    2 + 1 + 1
    1 + 1 + 1 + 1 

## Polya Theorem
( Or the Pólya enumeration theorem or the Redfield–Pólya theorem or Pólya counting) 

It is a theorem in combinatorics that both 
follows from and ultimately generalizes 
Burnside's lemma on the number of orbits 
of a group action on a set.


https://github.com/DevAlone/google_foobar_solutions/blob/master/level%205/Disorderly%20Escape/main.py
https://github.com/xphoniex/Google-Foobar/issues/5
https://en.wikipedia.org/wiki/Permutation
https://en.wikipedia.org/wiki/Burnside%27s_lemma