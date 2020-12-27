import unittest
import copy
import itertools  


# Second Solution
def convert_to_path(perm):
    perm = list(perm)
    perm = [0] + perm + [-1]
    path = list()
    for i in range(1, len(perm)):
        path.append((perm[i - 1], perm[i]))
    return path

def solution(time, time_limit):
    rows = len(time)
    bunnies = rows - 2

    for k in range(rows):
        for i in range(rows):
            for j in range(rows):
                if time[i][j] > time[i][k] + time[k][j]:
                    time[i][j] = time[i][k] + time[k][j]

    for r in range(rows):
        if time[r][r] < 0:
            return [i for i in range(bunnies)]

    for i in reversed(range(bunnies + 1)):
        for perm in itertools.permutations(range(1, bunnies + 1), i):
            total_time = 0
            path = convert_to_path(perm)
            for start, end in path:
                total_time += time[start][end]

            if total_time <= time_limit:
                return sorted(list(i - 1 for i in perm))

    return None


### First Solution
def solutionA(times, time_limit):
    n = len(times)
    
    # if n <=2 :
    #     return []
    
    nc, d = BellmanFord(times, time_limit)

    # print([x for x in range(len(times)-2)])

    if nc:
        return [x for x in range(len(times)-2)]
        # If there is a negative cycle return [0,1,2,3,4]
    else:
        # BFS for paths that collect max bunnies.
        stack = [[0,[0],time_limit,[[i] for i in range(n)]]]
        vertices = set([i for i in range(n)])
        maxBunnies = set()
        maxNumberBunnies = 0
        while stack:
            [u,path,timeleft, voidvertices] = stack.pop()

            for v in vertices - set(voidvertices[u]):
                timeuv = d[u][v]
                timeub = d[v][n-1]
                timevu = d[v][u]
                nextVoidVertices = copy.deepcopy(voidvertices)
                if timeuv+timevu == 0:
                    nextVoidVertices[u].append(v)
                    nextVoidVertices[v].append(u)
                if timeleft-timeuv-timeub >= 0:
                    nextPath = path+[v]
                    nextTimeLeft=timeleft-timeuv
                    stack.append([v,nextPath,nextTimeLeft,nextVoidVertices])
                    if v == n-1: 
                        setNextPath = set(nextPath)
                        lengthNextPath = len(setNextPath)
                        if lengthNextPath == n: # We got all bunnies
                            return [x for x in range(len(times)-2)]
                        if maxNumberBunnies < lengthNextPath or (maxNumberBunnies == lengthNextPath and sum(maxBunnies) > sum(setNextPath)):
                            maxBunnies = setNextPath
                            maxNumberBunnies = lengthNextPath
        return sorted([x-1 for x in (maxBunnies - set([0,n-1]))])

def BellmanFord(times, time_limit):
    """
    Bellman-Ford algorithm using all vertices as source.
    We pass in the time_limit to check, when there is a negative cycle,
    if it it reachable from the start.
    """
    # Initialization
    n = len(times)
    d = [n*[float("inf")] for _ in range(n)]
    for s in range(n):
        d[s][s] = 0
        # Relaxation
        for i in range(n-1):
            updated = False
            for u in range(n):
                for v in range(n):
                    distReach = d[s][u] + times[u][v]
                    if d[s][v] > d[s][u] + times[u][v]:
                        updated = True
                        d[s][v] = distReach
            # An optimization. It doesn't change the worst case, but well ...
            if not updated:
                break 
        # Negative cycle detection
        for u in range(n):
            for v in range(n):
                if d[s][v] > d[s][u] + times[u][v] and d[0][u] < time_limit:
                    return True, d # Negative cycle
    return False, d # no negative cycles



#### Unit Test ####

class TestSolution(unittest.TestCase):

    cases = [
        [
            [[0, 1, 1, 1, 1],
            [1, 0, 1, 1, 1],
            [1, 1, 0, 1, 1],
            [1, 1, 1, 0, 1],
            [1, 1, 1, 1, 0]],
            [3],
            [[0,1]]
        ],

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
            [
                [0, 1, 1, 1, 1, 1, 1],
                [1, 0, 1, 1, 1, 1, 1],
                [1, 1, 0, 1, 1, 1, 1],
                [1, 1, 1, 0, 1, 1, 1],
                [1, 1, 1, 1, 0, 1, 1],
                [1, 1, 1, 1, 1, 0, 1],
                [1, 1, 1, 1, 1, 1, 0]
            ],[3],[[0,1]]
        ],

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
        [
            [
                [0, 3, 1, 8, 1],
                [2, 0, 9, 4, 2],
                [-5, 1, 0, 3, -2],
                [3, 2, 1, 0, 1],
                [1, 3, 2, 0, 0]
            ], [10], [[0,1,2]]
        ]
    ]
    
    
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

        for x in self.cases[:]:
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

