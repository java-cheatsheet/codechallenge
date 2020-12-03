import unittest

'''
SOLUTION
    STEPS:
        Order the matrix so that rows start with terminal states first. Remember to sort the columns correctly too to reflect this so everything matches up.

        Now that you have done that you know how to find R and Q.

        Calculate F=(I-Q)⁻¹.

        Calculate FR.

        Get the first line of FR and then you have your probabilities.

        Find the common denominator and return the int array how the specification has asked it to be formatted.

        https://github.com/ivanseed/google-foobar-help/blob/master/challenges/doomsday_fuel/doomsday_fuel.md
'''

from fractions import Fraction

def solution(m):

    if ( (len(m) == 1) and ( m[0][0] == 0 ) ):
        return [1, 1]

    transformedMatrix, zeroMatLen = transform(m)

    Q, R = makeQRMatrices(transformedMatrix, zeroMatLen)

    F = inverse(Q)  

    FR = multiply(F, R)

    return fractionFR(FR[0])


'''
Returns transformed matrix and zero matrix length

    Param 2D int square matrix

    Transforms the original matrix into: 
        - Non Terminal Rows
        - Terminal Rows
'''
def transform(mat):
    sum_list = list(map(sum, mat))
    bool_indices = list(map(lambda x: x == 0, sum_list))
    indices = set([i for i, x in enumerate(bool_indices) if x])
    
    new_mat = []
    for i in range(len(mat)):
        new_mat.append(list(map(
            lambda x: Fraction(0, 1) if(sum_list[i] == 0) 
            else makeFraction(x, sum_list[i]), mat[i]
            )))
    
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

    return tmat, len(zeros_mat)


'''
Returns fraction of two integers    
'''
def makeFraction(x, y):
    g = gcd(x, y)
    return Fraction(int(x/g), int(y/g))


'''
Returns 2D sub-matrices of transformed matrix
    - Q Sub-matrix
    - R Sub-matrix
'''
def makeQRMatrices(mat, lengthR):
    lengthQ = len(mat) - lengthR
    Q = []
    R = []
    
    for i in range(lengthQ):
        Q.append([(i==j) - mat[i][j] for j in range(lengthQ)])
    
        R.append(mat[i][lengthQ:])

    return [Q, R]


'''
Returns inverse of a matrix
'''
def inverse(mat):
    tmat = transpose(mat)
    
    mat_inv = []
    
    for i in range(len(tmat)):
        values = [Fraction(int(i==j), 1) for j in range(len(mat))]
        
        mat_inv.append(gaussianElimination(tmat, values))
    
    return mat_inv


'''
Returns a transpose of a matrix
'''
def transpose(mat):
    tmat = []
    
    for i in range(len(mat)):        
        for j in range(len(mat)):
            
            if i == 0:
                tmat.append([])
            
            tmat[j].append(mat[i][j])

    return tmat


'''
Returns matrix created from Gaussian Elimination algorithm
'''
def gaussianElimination(matrix, values):
    mat = makeACopy(matrix)
    
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


'''
Returns a copy of 2D matrix
    The values are converted into fraction.
'''
def makeACopy(matrix):
    cmat = []
    
    for i in range(len(matrix)):
        cmat.append([])
        
        for j in range(len(matrix[i])):
            cmat[i].append(Fraction(matrix[i][j].numerator, matrix[i][j].denominator))

    return cmat


'''
Returns two matrix multiplied
'''
def multiply(mat1, mat2):
    res = []
    
    for i in range(len(mat1)):
        res.append([])
        
        for j in range(len(mat2[0])):
            res[i].append(Fraction(0, 1))
            
            for k in range(len(mat1[0])):
                res[i][j] += mat1[i][k] * mat2[k][j]

    return res


'''
Returns least common multiple of two integers
'''
def lcm(x, y):  
    return (x*y/gcd(x,y))


'''
Returns greatest common divisor of two integers
'''
def gcd(x, y):

    def gcdLambda(x, y):

        if y == 0:
            return x

        return gcdLambda(y, x%y)

    return gcdLambda(abs(x), abs(y))


'''
Returns first row of matrix in fraction
'''
def fractionFR(row):
    l = 1
    for item in row:
        l = lcm(l, item.denominator)

    row = list(map(lambda x: (x.numerator*l/x.denominator), row))
    row.append(l)

    return row


'''
UNIT TEST 
'''
class TestSolution(unittest.TestCase):
    cases = [   
                [
                    [[0, 2, 1, 0, 0],
                    [0, 0, 0, 3, 4],
                    [0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0]],
                    [7, 6, 8, 21]
                ],
                
                [
                    [[0, 1, 0, 0, 0, 1],
                    [4, 0, 0, 3, 2, 0],
                    [0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0]],
                    [0, 3, 2, 9, 14]
                ],
                [
                    [[1, 2, 3, 0, 0, 0],
                    [4, 5, 6, 0, 0, 0],
                    [7, 8, 9, 1, 0, 0],
                    [0, 0, 0, 0, 1, 2],
                    [0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0]],
                    [1, 2, 3]
                ],
                [
                    [
                        [1],
                    ],
                    [1,1]
                ],

                [
                    [[0, 0, 12, 0, 15, 0, 0, 0, 1, 8],
                    [0, 0, 60, 0, 0, 7, 13, 0, 0, 0],
                    [0, 15, 0, 8, 7, 0, 0, 1, 9, 0],
                    [23, 0, 0, 0, 0, 1, 0, 0, 0, 0],
                    [37, 35, 0, 0, 0, 0, 3, 21, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
                    [1, 2, 3, 4, 5, 15]
                ],
                [
                    [[0, 7, 0, 17, 0, 1, 0, 5, 0, 2],
                    [0, 0, 29, 0, 28, 0, 3, 0, 16, 0],
                    [0, 3, 0, 0, 0, 1, 0, 0, 0, 0],
                    [48, 0, 3, 0, 0, 0, 17, 0, 0, 0],
                    [0, 6, 0, 0, 0, 1, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
                    [4, 5, 5, 4, 2, 20]
                ],
                [
                    [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
                    [1, 1, 1, 1, 1, 5]
                ],
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
                [
                    [[0, 86, 61, 189, 0, 18, 12, 33, 66, 39],
                    [0, 0, 2, 0, 0, 1, 0, 0, 0, 0],
                    [15, 187, 0, 0, 18, 23, 0, 0, 0, 0],
                    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
                    [6, 44, 4, 11, 22, 13, 100]
                ],
                [
                    [[0, 0, 0, 0, 3, 5, 0, 0, 0, 2],
                    [0, 0, 4, 0, 0, 0, 1, 0, 0, 0],
                    [0, 0, 0, 4, 4, 0, 0, 0, 1, 1],
                    [13, 0, 0, 0, 0, 0, 2, 0, 0, 0],
                    [0, 1, 8, 7, 0, 0, 0, 1, 3, 0],
                    [1, 7, 0, 0, 0, 0, 0, 2, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
                    [1, 1, 1, 2, 5]
                ]
            ]      

    

    def test_solution(self):
        for x in self.cases[:1]:
            # print(x)
            got = solution(x[0])
            self.assertEqual( got, x[1])
            # TODO : can only concatenate str (not "list") to str
            # 'Matrix '+ x[0] + ' want:got '+ x[1]+':'+ got) 


if __name__ == '__main__':
    unittest.main()
