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

