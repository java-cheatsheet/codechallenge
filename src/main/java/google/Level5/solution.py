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

if __name__ == '__main__':
    print(solution(2, 2, 2))
    # print(solution(2,3,4))
