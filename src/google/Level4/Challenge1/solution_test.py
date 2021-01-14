'''Running With Bunnies Test

Test Case Source: https://github.com/FoxHub/Google-FooBar/blob/master/Level-4/foobar_4-2_running_with_bunnies.py

https://developer.ibm.com/recipes/tutorials/testing-and-code-coverage-with-python/
file:///home/anit/work/java/codechallenge/src/google/Level4/Challenge1/htmlcov
https://github.com/williamfiset/Algorithms/issues/18


'''

#!/usr/bin/env python
# -*- coding: utf-8 -*-


import unittest


# from first_solution import solution 
# from bellmanford_second import solution
from solution import solution

class TestSolution(unittest.TestCase):

    cases = [
                [

                    [[0, 2, 2, 2, -1],
                    [9, 0, 2, 2, -1],
                    [9, 3, 0, 2, -1],
                    [9, 3, 2, 0, -1],
                    [9, 3, 2, 2, 0]],
                    [1],
                    [[1,2]]
                ],

                [
                    [[0, 1, 1, 1, 1],
                    [1, 0, 1, 1, 1],
                    [1, 1, 0, 1, 1],
                    [1, 1, 1, 0, 1],
                    [1, 1, 1, 1, 0]],
                    [3],
                    [[0,1]]
                ],

        # [
        #     [
        #         [0, 1, 1, 1, 1, 1, 1],
        #         [1, 0, 1, 1, 1, 1, 1],
        #         [1, 1, 0, 1, 1, 1, 1],
        #         [1, 1, 1, 0, 1, 1, 1],
        #         [1, 1, 1, 1, 0, 1, 1],
        #         [1, 1, 1, 1, 1, 0, 1],
        #         [1, 1, 1, 1, 1, 1, 0]
        #     ],[3],[[0,1]]
        # ],

        # [
        #     [
        #         [0, 2, 2, 2, -1],
        #         [9, 0, 2, 2, 0],
        #         [9, 3, 0, 2, 0],
        #         [9, 3, 2, 0, 0],
        #         [9, 0, 0, 2, 0],
        #         [-1, 3, 2, 2, 0]
        #     ], [9], [[0,1,2,3]]
        # ],

        # Matrix with Negative cycle
        # [
        #     [
        #         [0, 3, 1, 8, 1],
        #         [2, 0, 9, 4, 2],
        #         [-5, 1, 0, 3, -2],
        #         [3, 2, 1, 0, 1],
        #         [1, 3, 2, 0, 0]
        #     ], [10], [[0,1,2]]
        # ],
        
        # Removed neg cycle by adding 10 to check how the solution behaves.
        # [
        #     [
        #         [0, 13, 11, 18, 11],
        #         [12, 0, 19, 14, 12],
        #         [5, 11, 0, 13, 8],
        #         [13, 12, 11, 0, 11],
        #         [11, 13, 12, 10, 0]
        #     ], [0], [[0,1,2]]
        # ]

        # [    [
        #         [0, 2, 2, 2, -1],
        #         [9, 0, 2, 2, 0],
        #         [9, 3, 0, 2, 0],
        #         [9, 3, 2, 0, 0],
        #         [1, 3, 2, 2, 0]
        #     ],[1],[[0, 1, 2]]
        # ],

        # [
        #     [[1, 3, 3, 3, 0],
        #     [10, 1, 3, 3, 0],
        #     [10, 4, 1, 3, 0],
        #     [10, 4, 3, 1, 0],
        #     [9, 3, 2, 2, 0]],[4],[[1,2]]
        # ]

    ]
    
    def atest_removeNegAdj(self):
        '''Remove negative number
        This exercise is to check by removing the negative number.
        '''
        # Check if negative numbers exists in the adjacency matrix. Ammend it!
        adjacencyMatrix=[
            [0, 2, 2, 2, -1],
            [9, 0, 2, 2, -1],
            [9, 3, 0, 2, -1],
            [9, 3, 2, 0, -1],
            [9, 3, 2, 2, 0]
        ] 

        for k in range(adjacencyMatrix):
            print(k)

    def test_solution(self):
        ### Permutations example
        # a = "GeEK"
        # # no length entered so default length 
        # # taken as 4(the length of string GeEK) 
        # p = itertools.permutations(a)  
        # # Print the obtained permutations  
        # for j in list(p):  
        #     print(j)  
        # print([x for x in range(5)])
        
        ### Reversed example
        # alph = ["a", "b", "c", "d"]
        # ralph = reversed(alph)
        # for x in ralph:
        #     print(x) 

        for x in self.cases[:1]:
            got = solution( x[0], x[1][0] )
            self.assertEqual( got, x[2][0] )
            

if __name__ == '__main__':
    unittest.main()
    


# if __name__ == '__main__':
    # case1 = [[0, 1, 1, 1, 1],
    #          [1, 0, 1, 1, 1],
    #          [1, 1, 0, 1, 1],
    #          [1, 1, 1, 0, 1],
    #          [1, 1, 1, 1, 0]]
    # print("\n\nCase 1: Provided test case 1.\nTime limit: 3")
    # for row in case1:
    #     print('', row)
    # print("\n  Expected: [0, 1]\nCalculated:", str(answer(case1, 3)))

    # print("\n\nCase 2: Provided test case 2.\nTime limit: 1")
    # case2 = [[0, 2, 2, 2, -1],
    #          [9, 0, 2, 2, -1],
    #          [9, 3, 0, 2, -1],
    #          [9, 3, 2, 0, -1],
    #          [9, 3, 2, 2, 0]]
    # for row in case2:
    #     print('', row)
    # print("\n  Expected: [1, 2]\nCalculated:", str(answer(case2, 1)))

    # print("\n\nCase 3: Infinite negative cycle.\nTime limit: -500")
    # case3 = [[0, 2, 2, 2, -1],
    #          [9, 0, 2, 2, 0],
    #          [9, 3, 0, 2, 0],
    #          [9, 3, 2, 0, 0],
    #          [-1, 3, 2, 2, 0]]
    # for row in case3:
    #     print('', row)
    # print("\n  Expected: [0, 1, 2]\nCalculated:", str(answer(case3, -500)))

    # print("\n\nCase 4: Max bunnies. None rescuable.\nTime limit: 1")
    # case4 = [[1, 1, 1, 1, 1, 1, 1],
    #          [1, 1, 1, 1, 1, 1, 1],
    #          [1, 1, 1, 1, 1, 1, 1],
    #          [1, 1, 1, 1, 1, 1, 1],
    #          [1, 1, 1, 1, 1, 1, 1],
    #          [1, 1, 1, 1, 1, 1, 1],
    #          [1, 1, 1, 1, 1, 1, 1]]
    # for row in case4:
    #     print('', row)
    # print("\n  Expected: []\nCalculated:", str(answer(case4, 1)))

    # print("\n\nCase 5: One bunny.\nTime limit: 2")
    # case5 = [[1, 1, 1],
    #          [1, 1, 1],
    #          [1, 1, 1]]
    # for row in case5:
    #     print('', row)
    # print("\n  Expected: [0]\nCalculated:", str(answer(case5, 2)))

    # print("\n\nCase 6: Multiple revisits.\nTime limit: 10")
    # case6 = [[0, 5, 11, 11, 1],
    #          [10, 0, 1, 5, 1],
    #          [10, 1, 0, 4, 0],
    #          [10, 1, 5, 0, 1],
    #          [10, 10, 10, 10, 0]]
    # for row in case6:
    #     print('', row)
    # print("\n  Expected: [0, 1]\nCalculated:", str(answer(case6, 10)))

    # print("\n\nCase 7: Multiple Revisits 2.\nTime limit: 5")
    # case7 = [[0, 10, 10, 10, 1],
    #          [0, 0, 10, 10, 10],
    #          [0, 10, 0, 10, 10],
    #          [0, 10, 10, 0, 10],
    #          [1, 1, 1, 1, 0]]
    # for row in case7:
    #     print('', row)
    # print("\n  Expected: [0, 1]\nCalculated:", str(answer(case7, 5)))

    # print("\n\nCase 8: Time travel.\nTime limit: 1")
    # case8 = [[0, 0, 0, 0, 0],
    #         [0, 0, 0, 0, 0],
    #         [0, 0, 0, 0, 0],
    #         [0, 0, 0, 0, 0],
    #         [0, 0, 0, 0, 0]]
    # for row in case8:
    #     print('', row)
    # print("\n  Expected: [0, 1, 2]\nCalculated:", str(answer(case8, 1)))

    # print("\n\nCase 9: No bunnies.\nTime limit: 1")
    # case9 = [[2, 2],
    #          [2, 2]]
    # for row in case9:
    #     print('', row)
    # print("\n  Expected: []\nCalculated:", str(answer(case9, 1)))

    # print("\n\nCase 10: Backwards bunny path.\nTime limit: 6")
    # case10 = [[0, 10, 10, 1, 10],
    #           [10, 0, 10, 10, 1],
    #           [10, 1, 0, 10, 10],
    #           [10, 10, 1, 0, 10],
    #           [1, 10, 10, 10, 0]]
    # for row in case10:
    #     print('', row)
    # print("\n  Expected: [0, 1, 2]\nCalculated:", str(answer(case10, 6)))


