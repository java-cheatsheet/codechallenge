'''
Source: https://github.com/franklinvp/foobar/blob/master/foobar2020/solutionProblem4.py

'''

#!/usr/bin/env python

# -*- coding: utf-8 -*-

import copy


### First Solution
def solution(times, time_limit):
    n = len(times)
    
    # if n <=2 :
    #     return []
    
    nc, d = BellmanFord(times, time_limit)
   
    # print(d)

    # print([x for x in range(len(times)-2)])

    if nc:
        return [x for x in range(len(times)-2)]
        # If there is a negative cycle return [0,1,2,3,4]
    else:
        bfs( d, n, time_limit )


def bfs(d, n, time_limit):
    # BFS for paths that collect max bunnies.
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


        #     print('Cost', bunny[i]['cost'][j])

        #     if bunny[i]['cost'][j] < minDist and i!=j:
        #         minDist = bunny[i]['cost'][j]
        #         print(bunny[i]['cost'][j]) 


    # bunnies = rows - 2
    # for i in reversed(range(bunnies + 1)):
    #     for perm in itertools.permutations(range(1, bunnies + 1), i):
    #         total_time = 0
    #         path = convert_to_path(perm)

    #         for start, end in path:
    #             total_time += time[start][end]

    #         if total_time <= time_limit:
    #             return sorted(list(i - 1 for i in perm))




if __name__ == '__main__':
    

    # given adjacency representation of matrix
    # adjMatrix = [
    #     [0, INF, -2, INF],
    #     [4, 0, -3, INF],
    #     [INF, INF, 0, 2],
    #     [INF, -1, INF, 0]
    # ]
    
    # adjacencyMatrix = [
    #     [0, 2, 2, 2, 3, 4, -1],  # 0 = Start
    #     [9, 0, 2, 2, 1, 5, -1],  # 1 = Bunny 0
    #     [9, 3, 0, 2, 1, 1, -1],  # 2 = Bunny 1
    #     [9, 3, 2, 0, 3, 2, -1],  # 3 = Bunny 2
    #     [9, 1, 2, 0, 0, 2, -1],  # 3 = Bunny 3
    #     [9, 2, 1, 0, 3, 0, -1],  # 3 = Bunny 4
    #     [9, 3, 2, 4, 3, 9,  0],  # 4 = Bulkhead
    # ]


    # adjacencyMatrix = [
    #     [0, 1, 1, 1, 1],
    #     [1, 0, 1, 1, 1],
    #     [1, 1, 0, 1, 1],
    #     [1, 1, 1, 0, 1],
    #     [1, 1, 1, 1, 0]
    #     ]
    # time = 3

    # # Negative Weight Cycle
    # adjacencyMatrix = [
    #       [0, 3, 1, 8, 0],
    #       [2, 0, 9, 4, 0],
    #       [-5, 0, 0, 0, 1],
    #       [0, 0, 1, 0, 0],
    #       [0, 0, 0, 0, 0]
    # ]
    # time = INF

    adjacencyMatrix = [
            [0, 2, 2, 2, -1],  # 0 = Start
            [9, 0, 2, 2, -1],  # 1 = Bunny 0
            [9, 3, 0, 2, -1],  # 2 = Bunny 1
            [9, 3, 2, 0, -1],  # 3 = Bunny 2
            [9, 3, 2, 2,  0],  # 4 = Bulkhead
        ]
    time = 1
    # print(adjacencyMatrix)
    solution(adjacencyMatrix, time)