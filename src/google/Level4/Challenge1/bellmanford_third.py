class Vertex:
  def __init__(self, name):
    #vertex label
    self.name = name
    #distance from the source vertex
    self.distance = float('inf') 
    #predecing vertex 
    self.prev = None
 
  #string representation of the class
  def __repr__(self):
    return self.name
 
class Edge:
  def __init__(self, _from, _to, _cost):
    #from vertex
    self._from = _from
    #to vertex
    self._to = _to
    #edge weight or cost
    self._cost = _cost
 
class BellmanFord:
  #method implementing the Bellman-Ford algorithm
  def findPath(self, source, edges, v):
    #distance of the source vertex to itself is 0
    source.distance = 0
 
    #relax all the edges V-1 times
    for i in range(v-1):
      for edge in edges:
        if edge._from.distance + edge._cost < edge._to.distance:
          edge._to.distance = edge._from.distance + edge._cost
          #update the preceding vertex of the target vertex
          edge._to.prev = edge._from
 
    #If any more relaxation is possible
    #then, it means graph has a cycle
    for edge in edges:
        if edge._from.distance + edge._cost < edge._to.distance:
          print("Graph has a negative cycle")
          return False
 
    return True
 
  '''
  function to trace path from destination to 
  the source vertex using the preceding nodes
  '''
  def trace_path(self, source, destination):
    vertex = destination
    path = []
 
    #iterate until we reach the source vertex
    while(vertex is not source):
      #append vertex to the front of the list
      path.insert(0, vertex)
      #update the iteration variable
      vertex = vertex.prev
    
    #also append the source vertex
    path.insert(0, source)
 
    #return the path
    return path
 
if __name__ == '__main__':
  #vertices of the graph
  vertices = [Vertex('A'), Vertex('B'), Vertex('C'), Vertex('D'), Vertex('E')]
  #edges of the graph
  edges = [Edge(vertices[0], vertices[1], 10), 
           Edge(vertices[1], vertices[2], -15),
           Edge(vertices[0], vertices[2], 5),
        #    Edge(vertices[2], vertices[3], 20),
           Edge(vertices[3], vertices[4], 5)
        #    Edge(vertices[0], vertices[4], 30)
        ]
 
  #driver code
  bellmanFord = BellmanFord()
  
  #output the path only when the graph has no cycle
  if bellmanFord.findPath(vertices[0], edges, len(vertices)):
    print("Distance: ",vertices[4].distance)
    print("Path: ", bellmanFord.trace_path(vertices[0], vertices[4]))