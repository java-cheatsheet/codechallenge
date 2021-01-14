'''Bellman–Ford–Moore algorithm Algorithm 


Source: 
- https://www.techiedelight.com/determine-negative-weight-cycle-graph
- https://www.techiedelight.com/single-source-shortest-paths-bellman-ford-algorithm
- https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/06DynamicProgrammingII.pdf

The purpose of this solution is to find an optimum solution based on Bellman-Ford-Moore.


'''

import itertools  


# define infinity as maximum value of the integer
INF = float('inf')
bunny = set()

# returns a List of graph edges 
def MakeEdge(adjMatrix, N, time):
    edges = []
    for v in range(N):
        for u in range(N):
            
            # print('adjMatrix[v][u]: ' + str(v) +':'+ str(u) +' = '+  str(adjMatrix[v][u]))

            if adjMatrix[v][u] and adjMatrix[v][u] != INF:
                # edge from source v to dest u having specified weight
                edges.append((v, u, adjMatrix[v][u]))

    return edges


# Recursive Function to print path of given vertex from source vertex
def printPath(parent, vertex):

    if vertex < 0:
        return

    printPath(parent, parent[vertex])
    print(vertex, end=' ')


# Function to run Bellman-Ford algorithm from given source
def BellmanFord(edges, source, time, N, last, verticesCost):

    # if source > 0 and source < N-1 :
    #     bunny.add(source) 
    #     # print(bunny)

    # cost stores shortest-path information
    cost = [INF] * N
 
    # Initially all vertices except source vertex have a weight of infinity
    cost[source] = 0
    
    parent = [-1] * N

    # Relaxation step (run V-1 times)
    for i in range(N):
        # consider all edges from u to v having weight w
        for (u, v, w) in edges:
            # if the cost to the destination u can be
            # shortened by taking the edge u -> v
            if cost[u] <= INF and cost[u] + w < cost[v]:

                # print("cost[v] ", cost[v], ' cost[u] ', cost[u], ' + w ', w )

                # update cost to the lower value
                cost[v] = cost[u] + w
                
                # set v's parent as u
                parent[v] = u
                
            # print("cost[v]:v ", cost[v],":", v )
                # print()


    # Run relaxation step once more for N'th time to
    # check for negative-weight cycles
    for (u, v, w) in edges:
        # if the cost to the destination u can be
        # shortened by taking the edge u -> v
        if cost[u] <= INF and cost[u] + w < cost[v]:
            return True

    # print(parent)
    
    # for i in range(N):
    #     print("From ", source, " to ", i , " distance is ", cost[i], end='.')
    #     print(" It's path is [ ", end='')
    #     printPath(parent, i)
    #     print("]")

    verticesCost.append(cost)

    # Find the cheapest distance
    # minCost = INF
    # next = INF
    
    # for i in range(1, N):

    #     if cost[i] < minCost \
    #     and i != source \
    #     and not i in bunny :
    #         next = i
    #         minCost = cost[i]
            
    # if not last:         
    #     if ( minCost < 0 ):
    #         time = time + -1*minCost

    #     elif ( minCost > 0 ):
    #         time = time - minCost

    #     # This is for negative costs involved.
    #     # For the first solution.
    #     if time < 0 and source == N-1 and len(bunny)+1 == N-2: 
    #         return 

    #     # if time < 0 and source == N-1 and len(bunny)+1 == N-2: 
    #     #     return 

    #     # check if this is the last stage and door is yet not open
    #     if time < 0 and source == N-2:
    #         # go back and check if there is a way from the previous source to door.
    #         time = time + minCost
    #         bunny.pop()
    #         last = bunny.pop()

    #         # This was the previous logic but as we already have 
    #         # the shortest path so we can use that data but the data 
    #         # is not stored yet.
    #         # BellmanFord(edges, last, time, N, 1)    
    # else:
    #     next = N-1
    #     time = time + minCost

    # BellmanFord(edges, next, time, N, False)
    
    # else:
    #     # Check if there is a path from the next to bulhead
    #     BellmanFord(edges, next, time, N )
    #     # print source in asecending order
    #     False

    return False


def solution(adjacentMatrix, time):
    rows = len(adjacentMatrix)
    edges =  MakeEdge(adjacentMatrix, rows, time)
    
    # verticeCosts = [(INF for i in range(rows)]*rows
    shortestPaths = []

    # run Bellman-Ford algorithm from each vertex as source
    # and check for any Negative Weight Cycle
    for i in range(rows-1):
        # store cost info for every vertex
        if BellmanFord(edges, i, time, rows, False, shortestPaths):
            print("Negative Weight Cycle Found!!")
            exit()

    print(shortestPaths)
    
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


    adjacencyMatrix = [
        [0, 1, 1, 1, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 0, 1, 1],
        [1, 1, 1, 0, 1],
        [1, 1, 1, 1, 0]
        ]
    time = 3

    # # Negative Weight Cycle
    # adjacencyMatrix = [
    #       [0, 3, 1, 8, 0],
    #       [2, 0, 9, 4, 0],
    #       [-5, 0, 0, 0, 1],
    #       [0, 0, 1, 0, 0],
    #       [0, 0, 0, 0, 0]
    # ]
    # time = INF

    # adjacencyMatrix = [
    #         [0, 2, 2, 2, -1],  # 0 = Start
    #         [9, 0, 2, 2, -1],  # 1 = Bunny 0
    #         [9, 3, 0, 2, -1],  # 2 = Bunny 1
    #         [9, 3, 2, 0, -1],  # 3 = Bunny 2
    #         [9, 3, 2, 2,  0],  # 4 = Bulkhead
    #     ]
    # time = 1
    print(adjacencyMatrix)
    solution(adjacencyMatrix, time)
    
    # edges =  MakeEdge(adjMatrix)

    # # run Bellman-Ford algorithm from each vertex as source
    # # and check for any Negative Weight Cycle
    # for i in range(N):
    #     if BellmanFord(edges, i, time):
    #         print("Negative Weight Cycle Found!!")
    #         break

