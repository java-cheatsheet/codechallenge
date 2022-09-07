# Problem

We are tracking down our rouge agent and she 
travels from place to place to **avoid being tracked**. 

Each of her travels are based on a list of itineraries 
in an unusual or incorrect order. 

The task is to 
determine the complete **route** she will take. 

You are given and array of routes containing her 
travel itineraries, convert this into a complete, 
**in-order list** of the places she will travel. 

Specifications: findRoutes(routes) parameters: 
routes: array<array<string>> - array of itineraries

return value: **string**: **an order list of distinations**

**the correct path she took**

constraints: all inputs have at least one valid, 
complete route examples: 

input: [[“USA”, “BRA”],[“JPN”, “CAI”], [“BRA”, “UAE”],[“UAE”, “JPN”]] 
Output: “USA, BRA, UAE, JPN, CAI” 

input: [["Chicago", "Winnipeg"], ["Halifax", "Montreal"], 
["Montreal", "Toronto"], ["Toronto", "Chicago"], ["Winnipeg", "Seattle"]] 
Output: “Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle” 

# Solution

## Bruteforce Approach
### Pseudocode
1. Find the starting point
2. Create route

## Refactor
Let's review the input again
[“USA”, “BRA”],[“JPN”, “CAI”], [“BRA”, “UAE”],[“UAE”, “JPN”]

The path is acyclic - there is one start and destination.

[“USA”, “BRA”],
[“JPN”, “CAI”], 
[“BRA”, “UAE”],
[“UAE”, “JPN”]

It looks like a key value pair.
First solutions time complexity is O(n^2).
Can storing the values in a hashmap improve 
time complexity? Or simplify our solution?

Let's store the input in the hashmap.

[“USA” => “BRA”],
[“JPN” => “CAI”],
[“BRA” => “UAE”],
[“UAE” => “JPN”]

The basic solution remains the same.
1. Find starting point
2. Make route

### Find starting point
The starting point is such a key that
would not appear as a value.

We need to find the key such that it
does not appear as the value of other
pairs.

Hashmap has a functionality to check
value exists.

**boolean containsValue(Object value)**	

The probable time complexity of this function
is O(n^2).
https://stackoverflow.com/questions/55679728/how-does-java-util-hashmap-containsvalue-work-what-is-its-time-complexity

This method returns true if some value 
equals to the value exists within the map, 
else return false.

So we iterate through all the pairs until
containsValue returns false.

### Make route
We have the starting point as the key
from one of the pairs.

Route is created such a way that value
of a pair (destination) must be the key
of other (source). 

The final destination does not have another
source.

So to create a route, first we need to 
find the key of another pair which is
the value of the current key.

This is our simple solution to make a
route.

