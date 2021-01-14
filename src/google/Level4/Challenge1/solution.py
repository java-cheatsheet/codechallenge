'''

Solution sources:
- https://github.com/n3a9/google-foobar/blob/master/Level%204/running_with_bunnies/solution.py
- https://github.com/franklinvp/foobar/blob/master/foobar2020/solutionProblem4.py
'''


import itertools
import copy

def solution(time, timeLimit):
    rows = len(time)
    bunnies = rows - 2
    
    if negativeCycleExists(time, rows):
        # All bunnies can be rescued
        return [i for i in range(bunnies)]

    
    print(time)

    return carryBunnies(time, timeLimit, bunnies)
    
    # Testing other solution if it works? 
    # It works!
    # return bfs(time, rows, timeLimit)


def negativeCycleExists(time, rows):
    '''Returns true if negtive cycle exists.
    
    Uses Bellman-Ford algorithm.

    :param time: Adjacency matrix of time taken to move from one bunny to other.
    :param rows: Number of rows of the adjacency matrix
    '''

    for k in range(rows):
        for i in range(rows):
            for j in range(rows):
                
                if time[i][j] > time[i][k] + time[k][j]:
                    time[i][j] = time[i][k] + time[k][j]

            # Skip early if negative cycle is detected
            if time[i][i] < 0:
               return True
    
def makePath(bunniesList):
    '''Returns a list of list as path from 0 to -1 in the same order in the parameter.

    i.e. [1,3,2] returns [[0,1],[1,3],[3,2][2,-1]]

    :param bunniesList: Unique list of integers representing bunnies.
    '''
    bunniesList = [0] + bunniesList + [-1]

    path = list()
    for i in range(1, len(bunniesList)):
        path.append((bunniesList[i - 1], bunniesList[i]))

    return path


def carryBunnies(time, timeLimit, bunnies):
    '''Returns a list of bunnies that can be rescued.

    This is a bruteforce implmentation.
    BFS/DFS or other algorithms needs be implementation for further optimization.

    :param time: Adjacency matrix of time taken to move from one bunny to other.
    :param timeLimit: Time limit to carry each bunny.
    :param bunnies Total number of bunnies. 
    '''
    for i in reversed(range(bunnies + 1)):
        
        for bunniesList in itertools.permutations(range(1, bunnies + 1), i):
            totalTime = 0
        
            path = makePath(list(bunniesList))

            for start, end in path:
                totalTime += time[start][end]

            if totalTime <= timeLimit:
                return sorted(list(i - 1 for i in bunniesList))

    return []


def bfs(d, n, time_limit):
    '''
    BFS for paths that collect max bunnies.

    This solution is a bit complicated and needs to be reviewed.
    
    # Finding
    Even though Bellman-Ford used one more step, that is basically
    done to check for negative cycle, passing the same adjacency matrix
    in this solution works. 

    Further research needs to be done and work on the original solution
    as described in the README.md.
    
    '''
    stack = [[0,[0],time_limit,[[i] for i in range(n)]]]
    vertices = set([i for i in range(n)])
    maxBunnies = set()
    maxNumberBunnies = 0

    while stack:
        [u,path,timeleft, voidvertices] = stack.pop()
        
        print(vertices)
        print(voidvertices)
        print(set(voidvertices[u]))
        print(vertices - set(voidvertices[u]))

        for v in vertices - set(voidvertices[u]):
            timeuv = d[u][v]
            timeub = d[v][n-1]
            timevu = d[v][u]
            nextVoidVertices = copy.deepcopy(voidvertices)
            
            print(nextVoidVertices)

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
                        return [x for x in n-2]

                    if maxNumberBunnies < lengthNextPath or (maxNumberBunnies == lengthNextPath and sum(maxBunnies) > sum(setNextPath)):
                        maxBunnies = setNextPath
                        maxNumberBunnies = lengthNextPath
    
    return sorted([x-1 for x in (maxBunnies - set([0,n-1]))])
