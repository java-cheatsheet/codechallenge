'''Bellman-Ford Algorithm 

Find the shortest path form the single source.

Source:
https://www.techiedelight.com/single-source-shortest-paths-bellman-ford-algorithm

'''

# define infinity as maximum value of the integer
INF = float('inf')

# Recursive Function to print path of given vertex from source vertex
def printPath(parent, vertex):
    if vertex < 0:
        return
 
    printPath(parent, parent[vertex])
    print(vertex, end=' ')
 
 
# Function to run Bellman Ford Algorithm from given source
def bellmanFord(edges, source, N, time):
 
    # distance[] and parent[] stores shortest-path (least cost/path) info
    distance = [time] * N
    parent = [-1] * N
 
    # Initially all vertices except source vertex have a weight of
    # infinity and a no parent
    distance[source] = 0
 
    # Relaxation step (run V -1 times)
    for k in range(N - 1):
 
        # edge from u to v having weight w
        for (u, v, w) in edges:
 
            # if the distance to the destination v can be
            # shortened by taking the edge u-> v
            if distance[u] + w < distance[v]:
 
                # update distance to the new lower value
                distance[v] = distance[u] + w
 
                # set v's parent as u
                parent[v] = u
 
    # run relaxation step once more for N'th time to
    # check for negative-weight cycles
    for (u, v, w) in edges:  # edge from u to v having weight w
 
        # if the distance to the destination u can be
        # shortened by taking the edge u-> v
        if distance[u] + w < distance[v]:
            return True # print("Negative Weight Cycle Found!!")
            
 
    for i in range(N):
        print("Distance of vertex", i, "from the source(" + str(source) + ") is", distance[i], end='.')
        print(" It's path is [ ", end='')
        printPath(parent, i)
        print("]")


# returns a List of graph edges 
def makeEdge(adjMatrix, N):
    edges = []
    for v in range(N):
        for u in range(N):
            if adjMatrix[v][u] and adjMatrix[v][u] != time:
                # edge from source v to dest u having specified weight
                edges.append((v, u, adjMatrix[v][u]))

    return edges 
 
if __name__ == '__main__':
 
    #  of graph edges as per above diagram
    # edges = [
    #     # (x, y, w) -> edge from x to y having weight w
    #     (0, 1, -1), (0, 2, 4), (1, 2, 3), (1, 3, 2),
    #     (1, 4, 2), (3, 2, 5), (3, 1, 1), (4, 3, -3)
    # ]
    
    # adjacentMatrix = [
    #         [0, 2, 2, 2, -1],  # 0 = Start
    #         [9, 0, 2, 2, -1],  # 1 = Bunny 0
    #         [9, 3, 0, 2, -1],  # 2 = Bunny 1
    #         [9, 3, 2, 0, -1],  # 3 = Bunny 2
    #         [9, 3, 2, 2,  0],  # 4 = Bulkhead
    #     ]
    # time = 1 

    '''Analysis

    First Path
    Path    TimeRemaining
    0-4,    2
    4-1,    1
    1-2,    1
    2-4,    2 Now to go to 3, time=2 is required.
    4-3,    0 
    3-4,    X As it needs 1 time to go to 4.
    '''
    # adjacentMatrix = [
    #         [0, 1, 1, 1, 1],
    #         [1, 0, 1, 1, 1],
    #         [1, 1, 0, 1, 1],
    #         [1, 1, 1, 0, 1],
    #         [1, 1, 1, 1, 0]]
    # time = 3 

    adjacentMatrix = [
            [0, 3, 3, 3, 0],
            [10, 0, 3, 3, 0],
            [10, 4, 0, 3, 0],
            [10, 4, 3, 0, 0],
            [9, 3, 2, 2, 0]]
    time = INF


    rows = len(adjacentMatrix)
    edges =  makeEdge(adjacentMatrix, rows)

    # let source be vertex 0
    # We need to find a path from 0
    source = 0

    # # run Bellman Ford Algorithm from given source
    if bellmanFord(edges, source, rows, time):
            print("Negative Weight Cycle Found!!")


# Distance of vertex 0 from the source(0) is 0. It's path is [ 0 ]
# Distance of vertex 1 from the source(0) is 2. It's path is [ 0 1 ]
# Distance of vertex 2 from the source(0) is 1. It's path is [ 0 4 2 ]
# Distance of vertex 3 from the source(0) is 1. It's path is [ 0 4 3 ]
# Distance of vertex 4 from the source(0) is -1. It's path is [ 0 4 ]