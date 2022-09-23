

```python 
def binary_search(list, item):
    low = 0
    high = len(list)—1

    while low <= high:
        mid = (low + high)
        guess = list[mid]

        if guess == item:
            return mid

        if guess > item:
            high = mid - 1

        else:
            low = mid + 1
    return None

my_list = [1, 3, 5, 7, 9]
print binary_search(my_list, 3)
print binary_search(my_list, -1)e
```

The main takeaways are as follows:
• Algorithm speed isn’t measured in seconds, but in growth of the
number of operations.
• Instead, we talk about how quickly the run time of an algorithm
increases as the size of the input increases.
• Run time of algorithms is expressed in Big O notation.
• Big O establishes a worst-case run time.
• O(log n) is faster than O(n), but it gets a lot faster as the list of items
you’re searching grows.


• Binary search is a lot faster than simple search, O(log n).
• O(log n) is faster than O(n), but it gets a lot faster once the list of
items you’re searching through grows.
• Algorithm speed isn’t measured in seconds.
• Algorithm times are measured in terms of growth of an algorithm.
• Algorithm times are written in Big O notation.


### 2
Array VS Linked List
Linked lists are good for inserts/deletes, and arrays are good
for random access.

-| Array | List
--|--|--
Reading|O(1)|O(n)
Inserstion|O(n)|O(1)
Delietion|O(n)|O(1)


Hybrid data structure: an array of linked lists.

```python
def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0
    for i in range(1, len(arr)):
    
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
    return smallest_index

def selectionSort(arr):
    newArr = []
    for i in range(len(arr)):
        smallest = findSmallest(arr)
        newArr.append(arr.pop(smallest))
    return newArr

print selectionSort([5, 3, 6, 2, 10])
```

• Your computer’s memory is like a giant set of drawers.
• When you want to store multiple elements, use an array or a list.
• With an array, all your elements are stored right next to each other.
• With a list, elements are strewn all over, and one element stores
the address of the next one.
• Arrays allow fast reads.
• Linked lists allow fast inserts and deletes.
• All elements in the array should be the same type (all ints,
all doubles, and so on).


### Ch 3 Recursion
Which approach seems easier to you? 

```python
# The first approach uses a while loop. While the pile isn’t empty, grab a box and look through it:
def look_for_key(main_box):
    
    pile = main_box.make_a_pile_to_look_through()
    
    while pile is not empty:
        box = pile.grab_a_box()
        for item in box:
            
            if item.is_a_box():
                pile.append(item)
            
            elif item.is_a_key():
            print “found the key!”

# The second way uses recursion. Recursion is where a function calls itself.

def look_for_key(box):
    for item in box:
        
        if item.is_a_box():
            look_for_key(item)
        elif item.is_a_key():
            print “found the key!”
```

A quote by Leigh Caldwell on Stack Overflow: 
“Loops may achieve a performance gain for your 
program. Recursion may achieve a performance 
gain for your programmer. Choose which is more
important in your situation!”.

When you write a recursive function, you have to tell it when to stop
recursing. That’s why every recursive function has two parts: the base
case, and the recursive case. The recursive case is when the function calls
itself. The base case is when the function doesn’t call itself again so it
doesn’t go into an infinite loop.

```python
def countdown(i):
    print i

    if i <= 0: # Base case
        return
    else:
        countdown(i-1) # Recursive case
```

#### Call Stack
When we call a function from another function, 
the calling function is paused in a partially 
completed state. All the values of the variables 
for that function are still stored in memory.

This stack, used to save the variables for multiple 
functions, is called the call stack.


• Recursion is when a function calls itself.
• Recursion keeps track of the state.
• Every recursive function has two cases: the base case
and the recursive case.
• A stack has two operations: push and pop.
• All function calls go onto the call stack.
• The call stack can get very large, which takes up a lot of memory.


### Ch 4 Divide and Conquer
Divide and Conquer (D&C), a well-known recursive technique 
for solving problems.

Binary search uses divide-and-conquer.
Quicksort uses divide-and-conquer.

How D&C works:
1. Figure out a simple case as the base case.
2. Figure out how to reduce your problem and get to the base case.


When you’re writing a recursive function involving an array, the base case is
often an empty array or an array with one element. If you’re stuck, try that first.

```python
def quicksort(array):

    if len(array) < 2: # Base case: arrays with 0 or 1 element are already “sorted.”
        return array
    else: # Recursive case
        pivot = array[0]
        
        less = [i for i in array[1:] if i <= pivot] # Sub-array of all the elements less than the pivot
        
        greater = [i for i in array[1:] if i > pivot] # Sub-array of all the elements greater than the pivot
        
        return quicksort(less) + [pivot] + quicksort(greater)

print quicksort([10, 5, 2, 3])
```

Quicksort is unique because its speed depends on the pivot you choose.
The average runtime of quicksort is O(n log n)!


### Ch 5 Hash Tables

Python has hash
tables; they’re called dictionaries. You can make a new hash table using
the dict function:
>>> book = dict()


Put a hash function and an array together,
and you get a data structure called a hash table. A hash table is the first
data structure you’ll learn that has some extra logic behind it. Arrays
and lists map straight to memory, but hash tables are smarter. They use
a hash function to intelligently figure out where to store elements.
Hash tables are probably the most useful complex data structure
you’ll learn. 
They’re also known as hash maps, maps, dictionaries, and
associative arrays. And hash tables are fast! You can get an item from an
array instantly. And hash tables use an array to store the data, so they’re
equally fast.

A hash table maps keys to values.
Hash tables have no ordering, so it doesn’t matter what order you add
key/value pairs in.

Hashes are good for
• Modeling relationships from one thing to another thing
• Filtering out duplicates
• Caching/memorizing data instead of making your server do work

Hash tables have really fast search, insert, and delete.
The best case O(1), worst case O(n).


### Ch 6 Graph, BFS

The shortest path doesn’t have to be about physical distance. 
It can be about minimizing something.

Breadth-first search allows you to find the shortest distance between two things.

The algorithm to solve a shortest-path problem is called breadth-first search.
Breadth-first search not only finds a path from A to B, it also finds the shortest path.
You need to search people/things in the order that they’re added in the graph. There’s a data
structure for this: it’s called a queue.
You can’t access random elements in the queue. Instead, there are two only operations, enqueue and dequeue.
The queue is called a FIFO data structure: First In, First Out. 
In contrast, a stack is a LIFO data structure: Last In, First Out.

```python
def search(name):
    search_queue = deque()
    search_queue += graph[name]
    searched = []

    while search_queue:
        person = search_queue.popleft()

        if not person in searched:
    
            if person_is_seller(person):
                print person + “ is a mango seller!”
                return True
            else:
                search_queue += graph[person]
                searched.append(person)

    return False

search(“you”)
```

Runtime of BFS O(V+E) (V for number of vertices, E for number of edges).


If task A depends on task B, task A shows up later in the list. 
This is called a topological sort,
and it’s a way to make an ordered list out of a graph. Suppose you’re
planning a wedding and have a large graph full of tasks to do—and
you’re not sure where to start. You could topologically sort the graph
and get a list of tasks to do, in order.

A tree is a special type of graph, where no edges
ever point back.

Undirected graphs don’t have arrows, and the relationship goes both
ways. Whereas, a directed graph has arrows, and the relationship follows the
direction of the arrow.


### Ch 7 Weighted Graph, Dijkstra’s Algorithm

A graph with weights is called a weighted graph. 
A graph without weights is called an unweighted graph.


To calculate the shortest path in an unweighted
graph, use breadth-first search. 
To calculate the shortest path in a weighted graph, 
use Dijkstra’s algorithm.
Dijkstra’s algorithm only works with directed acyclic 
graphs (DAGs).

Key idea - Look at the cheapest node on your graph.

You can’t use Dijkstra’s algorithm if you have negative-weight edges. 
Negative-weight edges break the algorithm.

```python
def find_lowest_cost_node(costs):
    lowest_cost = float(“inf”)
    lowest_cost_node = None
    
    for node in costs:
        cost = costs[node]

        if cost < lowest_cost and node not in processed:
            lowest_cost = cost
            lowest_cost_node = node

    return lowest_cost_node


graph = {}
graph[“you”] = [“alice”, “bob”, “claire”]
graph[“start”] = {}
graph[“start”][“a”] = 6
graph[“start”][“b”] = 2
graph[“a”] = {}
graph[“a”][“fin”] = 1
graph[“b”] = {}
graph[“b”][“a”] = 3
graph[“b”][“fin”] = 5
graph[“fin”] = {}

infinity = float(“inf”)
costs = {}
costs[“a”] = 6
costs[“b”] = 2
costs[“fin”] = infinity

parents = {}
parents[“a”] = “start”
parents[“b”] = “start”
parents[“fin”] = None

processed = []

node = find_lowest_cost_node(costs)
while node is not None:
    cost = costs[node]
    neighbors = graph[node]
    
    for n in neighbors.keys():
        new_cost = cost + neighbors[n]
        
        if costs[n] > new_cost:
            costs[n] = new_cost
            parents[n] = node

        processed.append(node)
        node = find_lowest_cost_node(costs)

```

• Breadth-first search is used to calculate the shortest path for
an unweighted graph.
• Dijkstra’s algorithm is used to calculate the shortest path for
a weighted graph.
• Dijkstra’s algorithm works when all the weights are positive.
• If you have negative weights, use the Bellman-Ford algorithm.


### Ch 8 NP-complete Problems, Greedy Algorithm or Approximation Algorithm
• You learn how to tackle the impossible:
problems that have no fast algorithmic solution
(NP-complete problems).
• You learn how to identify such problems when you
see them, so you don’t waste time trying to find a
fast algorithm for them.
• You learn about approximation algorithms, which
you can use to find an approximate solution to an
NP-complete problem quickly.
• You learn about the greedy strategy, a very simple
problem-solving strategy.

The beauty of greedy algorithms: they’re easy! 
A greedy algorithm is simple: at each step, pick the optimal move.
In technical terms: at each step you pick the locally optimal
solution, and in the end you’re left with the globally optimal solution.


The classroom scheduling problem
The knapsack problem
The set-covering problem


NP-completeness: The traveling salesperson and the set-covering
problems are two examples of some problems which famously hard 
to solve. 

If you want to find the shortest path that connects several points,
that’s the traveling-salesperson problem, which is NP-complete.


NP-complete problems show up everywhere! It’s nice to know if the
problem you’re trying to solve is NP-complete. At that point, you can
stop trying to solve it perfectly, and solve it using an approximation
algorithm instead. But it’s hard to tell if a problem you’re working on is
NP-complete. Usually there’s a very small difference between a problem
that’s easy to solve and an NP-complete problem.

There is no easy way to determine a problem is NP-Complete or not.
Here are few ways that might help:

• Your algorithm runs quickly with a handful of items but really slows
down with more items.
• “All combinations of X” usually point to an NP-complete problem.
• Do you have to calculate “every possible version” of X because you
can’t break it down into smaller sub-problems? Might be
NP-complete.
• If your problem involves a sequence (such as a sequence of cities, like
traveling salesperson), and it’s hard to solve, it might be NP-complete.
• If your problem involves a set (like a set of radio stations) and it’s hard
to solve, it might be NP-complete.
• Can you restate your problem as the set-covering problem or the
traveling-salesperson problem? Then your problem is definitely
NP-complete.


• Greedy algorithms optimize locally, hoping to end up with a global
optimum.
• NP-complete problems have no known fast solution.
• If you have an NP-complete problem, your best bet is to use an
approximation algorithm.
• Greedy algorithms are easy to write and fast to run, so they make
good approximation algorithms.


### Ch 9 - Dynamic Programming

`Trying to maximize something?`

A technique to solve a hard problem by
breaking it up into subproblems and
solving those subproblems first.

Dynamic programming only works when each
subproblem is discrete—when it doesn’t 
depend on other subproblems.

Dynamic programming is useful when you’re
trying to optimize something given a constraint.

Every dynamic-programming solution involves a grid.

The values in the cells are usually what you’re trying to optimize.

For the knapsack problem, the values were the value of the goods.

Each cell is a subproblem, so think about how you can divide
your problem into subproblems. That will help you figure out what
the axes are.

There’s no single formula for calculating a dynamic-programming
solution.

#### The Knapsack Problem:
Maximize the value of the goods you stole, 
constrained by the size of the knapsack.

The simplest algorithm is this: you try every possible set of goods and
find the set that gives you the most value.
This works, but it’s really slow. With every
item you add, the number of sets you have to calculate doubles! This
algorithm takes O(2^n) time, which is very, very slow.

Kanpsack problem is a combination problem.

Every dynamic-programming algorithm starts with a grid.

The rows of the grid are the items, and the columns are knapsack
weights.

Remember, you’re trying to maximize the value of the knapsack.

Rows represent items.
Colums represent capacities.
The order of the rows doesn’t matter.
For Knapsack problem, we fill the grid row-wise.
The gird can be filled column-wise.


With the dynamic-programming solution, you 
either take the item or not. There’s no way 
for it to figure out that you should take 
half an item.

For this type of problem use Greedy algorithm.
First, take as much as you can of the most 
valuable item. When that runs out, take as
much as you can of the next most valuable 
item, and so on.


#### Optimizing Travel Itinerary Problem
Maximize the number of places that can be visited, 
constrained by time.


#### Longest Common Substring Problem
One thing to note: for this problem, the final solution may not be in
the last cell! For the knapsack problem, this last cell always had the
final solution. But for the longest common substring, the solution is the
largest number in the grid—and it may not be the last cell.

```python pseudocode
if word_a[i] == word_b[j]:              # The letters match.
    cell[i][j] = cell[i-1][j-1] + 1
else:                                   #The letters don’t match.
    cell[i][j] = 0
```

#### Longest Common Subsequence Problem

```python pseudocode
if word_a[i] == word_b[j]:              # The letters match.
    cell[i][j] = cell[i-1][j-1] + 1
else:                                   # The letters don’t match.
    cell[i][j] = max(cell[i-1][j], cell[i][j-1])
```


### Ch 10 K-Nearest Neighbors Algorithm
• KNN is used for classification and regression and involves looking
at the k-nearest neighbors.
• Classification = categorization into a group.
• Regression = predicting a response (like a number).
• Feature extraction means converting an item (like a fruit or a user)
into a list of numbers that can be compared.
• Picking good features is an important part of a successful KNN
algorithm.



### Ch 11

#### Trees
Let’s go back to the binary search example.
When a user logs in to Facebook, Facebook
has to look through a big array to see if the
username exists. We said the fastest way to
search through this array is to run binary
search. But there’s a problem: every time a new
user signs up, you insert their username into
the array. Then you have to re-sort the array,
because binary search only works with sorted
arrays. Wouldn’t it be nice if you could insert
the username into the right slot in the array 
right away, so you don’t have to sort the array 
afterward? That’s the idea behind the binary search
tree data structure.

Searching for an element in a binary search tree takes O(log n) time on average
and O(n) time in the worst case. Searching a sorted array takes O(log n)
time in the worst case, so you might think a sorted array is better. But a
binary search tree is a lot faster for insertions and deletions on average.

There are special binary search trees 
that balance themselves. One example 
is the red-black tree. 

So when are binary search trees used? 
B-trees, a special type of binary
tree, are commonly used to store data 
in databases.

If you’re interested in databases or 
more-advanced data structures, check 
these out:

• B-trees
• Red-black trees
• Heaps
• Splay trees

#### Inverted indexes
Commonly used to build search engines.

#### The Fourier transform
The Fourier transform is one of those rare algorithms: brilliant,
elegant, and with a million use cases. The best analogy for the Fourier
transform comes from Better Explained (a great website that explains
math simply): given a smoothie, the Fourier transform will tell you the
ingredients in the smoothie. 1 Or, to put it another way, given a song, the
transform can separate it into individual frequencies.

Music isn’t the only type of digital signal. The JPG format is another
compressed format, and it works the same way. People use the Fourier
transform to try to predict upcoming earthquakes and analyze DNA.

You can use it to build an app like Shazam, which guesses what song is
playing. The Fourier transform has a lot of uses. Chances are high that
you’ll run into it!

#### Parallel algorithms
If you’re interested in the theoretical side 
of performance and scalability, parallel algorithms
might be for you!

#### MapReduce
There’s a special type of parallel algorithm that is becoming increasingly
popular: the distributed algorithm. It’s fine to run a parallel algorithm
on your laptop if you need two to four cores, but what if you need
hundreds of cores? Then you can write your algorithm to run across
multiple machines. The MapReduce algorithm is a popular distributed
algorithm. You can use it through the popular open source tool
Apache Hadoop.

Why are distributed algorithms useful?
Suppose you have a table with billions or trillions of rows, and you
want to run a complicated SQL query on it. You can’t run it on MySQL,
because it struggles after a few billion rows. Use MapReduce through
Hadoop!

Distributed algorithms are great when you have a lot of work to do
and want to speed up the time required to do it. MapReduce in
particular is built up from two simple ideas: the map function and the
reduce function.

The map function is simple: it takes an array and applies the same
function to each item in the array. For example, here we’re doubling
every item in the array:
>>> arr1 = [1, 2, 3, 4, 5]
>>> arr2 = map(lambda x: 2 * x, arr1)
[2, 4, 6, 8, 10]

The reduce function confuses people sometimes. The idea is that you
“reduce” a whole list of items down to one item. With map , you go from
one array to another.
With reduce , you transform an array to a single item.
Here’s an example:
>>> arr1 = [1, 2, 3, 4, 5]
>>> reduce(lambda x,y: x+y, arr1)
15

#### Bloom Filters
Altough hash table would give accurate answers
in constant time O(1), it occupies huge storage
space when the data is large. For example, index
of pages visited by Google.

Bloom filters are probabilistic data structures. 
They give you an answer that could be wrong but is probably
correct. Instead of a hash, you can ask your bloom filter if you’ve
crawled this URL before. A hash table would give you an accurate
answer. A bloom filter will give you an answer that’s probably correct:
• False positives are possible. Google might say, “You’ve already crawled
this site,” even though you haven’t.
• False negatives aren’t possible. If the bloom filter says, “You haven’t
crawled this site,” then you definitely haven’t crawled this site.
Bloom filters are great because they take up very little space

#### HyperLogLog
Along the same lines is another algorithm called HyperLogLog.
Suppose Google wants to count the number of unique searches
performed by its users. Or suppose Amazon wants to count the number
of unique items that users looked at today. Answering these questions
takes a lot of space! With Google, you’d have to keep a log of all the
unique searches. When a user searches for something, you have to see
whether it’s already in the log. If not, you have to add it to the log. Even
for a single day, this log would be massive!
HyperLogLog approximates the number of unique elements in a set.
Just like bloom filters, it won’t give you an exact answer, but it comes
very close and uses only a fraction of the memory a task like this would
otherwise take.

If you have a lot of data and are satisfied with approximate answers,
check out `probabilistic algorithms`!

#### The SHA algorithms
SHA is a hash function. It generates a hash, 
which is just a short string. The hash function 
for hash tables went from string to array index, 
whereas SHA goes from string to string.

You can use SHA to tell whether two files are the same. This is useful
when you have very large files. Suppose you have a 4 GB file. You want
to check whether your friend has the same large file. You don’t have to
try to email them your large file. Instead, you can both calculate the
SHA hash and compare it.

SHA is also useful when you want to compare strings without revealing
what the original string was.
SHA is used very commonly to hash passwords like this. It’s a one-way
hash. You can get the hash of a string. But you can’t get the original 
string from the hash.

SHA is actually a family of algorithms: SHA-0, SHA-1, SHA-2, and
SHA-3. The gold standard for password-hashing functions is currently
bcrypt.

SHA generes completely different hash even for a character change,
called locality-sensitive hash function.

If you make a small change to a string, Simhash generates a hash 
that’s only a little different. This allows you to compare hashes 
and see how similar two strings are, which is pretty useful!
• Google uses Simhash to detect duplicates while crawling the web.
• A teacher could use Simhash to see whether a student was copying an
essay from the web.
• Scribd allows users to upload documents or books to share with
others. But Scribd doesn’t want users uploading copyrighted content!
The site could use Simhash to check whether an upload is similar to a
Harry Potter book and, if so, reject it automatically.

Simhash is useful when you want to check for similar items.

#### Diffie-Hellman key exchange
Diffie-Hellman has two keys: a public key and a private key. The public
key is exactly that: public. You can post it on your website, email it
to friends, or do anything you want with it. You don’t have to hide it.
When someone wants to send you a message, they encrypt it using
the public key. An encrypted message can only be decrypted using the
private key. As long as you’re the only person with the private key, only
you will be able to decrypt this message!
The Diffie-Hellman algorithm is still used in practice, along with its
successor, RSA. If you’re interested in cryptography, Diffie-Hellman is a
good place to start: it’s elegant and not too hard to follow.


#### Linear programming
Linear programming is used to maximize something given some
constraints.
All the graph algorithms can be done through linear programming
instead.
Linear programming is a much more general framework, and graph
problems are a subset of that
Linear programming uses the Simplex algorithm. It’s a complex
algorithm.

https://en.wikipedia.org/wiki/Simplex_algorithm
