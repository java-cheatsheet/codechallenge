# Problem

Fuel Injection Perfection
=========================

Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection system for her LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the LAMBCHOP - and maybe sneak in a bit of sabotage while you're at it - so you took the job gladly. 

Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of the LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk into the fuel intake. You need to figure out the most efficient way to sort and shift the pellets down to a single pellet at a time. 

The fuel control mechanisms have three operations: 
1) Add one fuel pellet
2) Remove one fuel pellet
3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a quantum antimatter pellet is cut in half, the safety controls will only allow this to happen if there is an even number of pellets)

Write a function called solution(n) which takes a positive integer as a string and **returns the minimum number of operations needed to transform the number of pellets to 1**. The fuel intake control panel can only display a number up to 309 digits long, so there won't ever be more pellets than you can express in that many digits.

For example:
solution(4) returns 2: 4 -> 2 -> 1
solution(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1

# Solution
### Analysis

Cases:

1.  4>2>1 : 2


2.  15>16>8>4>2>1 : 5
    15>14>7>6>3>2>1: 6
This is the odd case where we need to increase first.

3.  1 : 1
4.  0 : 1

5.  11>12>6>3>2>1 : 5
    11>10>5>4>2>1 : 5

6.  7>6>3>2>1 : 4
    7>8>4>2>1 : 4 

7.  25>24>12>6>3>2>1 : 6
    25>26>13>12>6>3>2>1 : 7

8.  157>158>79>80>40>20>10>5>4>2>1 : 10
    157>156>78>39>40>20>10>5>4>2>1 : 10
    157>156>78>39>38>19>18>9>8>4>2>1:11

9.  45>44>22>11>10>5>4>2>1 : 8 Decreasing
    45>46>23>24>12>6>3>2>1 : 8 Increasing
    45>46>23>22>11>12>6>3>2>1 : 9 Inc,Decresing

10. 35>34>17>16>8>4>2>1 : 7
    35>36>18>9>10>5>4>2>1 : 8 Inc
    35>36>18>9>8>4>2>1 : 7

11. 10>5>4>2>1 : 4
    10>5>6>3>2>1 : 5

12. 70>35>34>17>16>8>4>2>1 : 8
    70>35>36>18>9>8>4>2>1  : 8

13. 11>10>5>4>2>1
    11>12>6>3>2>1

14. 113>112>56>26>13>12>6>3>2>1 : 9 Dec
    113>114>72>36>18>9>10>5>6>3>2>1 : 11 Inc
    113>114>72>36>18>9>8>4>2>1 : 9 Inc, Dec

15. 89>90>45>44>22>11>10>5>4>2>1 : 10

16. 41>40>20>10>5>4>3>2>1 : 8
    41>42>21>22>11>10>5>4>3>2>1: 11
If the number is close to multiple of 10, make it a multiple of 10.


#### First Submission
```java
    public static int solution(String s) {
        int n = Integer.valueOf(s);
        int count = 0;

        while (n > 1) {
            count++;

            if (n % 2 == 0)
                n /= 2;
            else if (n % 4 == 1)
                n -= 1;
            else
                n += 1;
        }

        return count;
    }
```
`Result`
Test 1 passed!
Test 2 passed!
Test 3 failed  [Hidden]
Test 4 failed  [Hidden]
Test 5 passed! [Hidden]
Test 6 failed  [Hidden]
Test 7 failed  [Hidden]
Test 8 failed  [Hidden]
Test 9 failed  [Hidden]
Test 10 failed  [Hidden]


#### Second Attempt
I probably did not check for negative values as in the lower limit of input is not mentioned.

Some optimizations could be done and found some resources below:

```python
def solution(n):
    current_number = int(n)
    operations_so_far = 0

    if current_number == 0:
        return 1
    if current_number < 0:
        current_number = current_number * -1
        operations_so_far = 2

    while current_number != 1:
        if current_number & 1:
            if current_number & 2 and current_number != 3:
                current_number = current_number + 1
            else:
                current_number = current_number - 1
        else:
            current_number = current_number // 2

        operations_so_far = operations_so_far + 1

    return operations_so_far
```
This solution passes all the tests.

Optimation for Java solution : https://codereview.stackexchange.com/questions/167478/foobar-fuel-injection-perfection-efficiency

For counting the steps the Python solution provies the solution.

17. -4
Convert the number into positive -1*-4  = 4
Count the steps as normal
Add two more steps as it take two steps from -1 to reach to 1 ( 0,1 ).
    4>2>1 : 2
Total steps 4


Found another python solution that works
```python

def solution(n):
    n=int(n)
    steps=0

    while(n!=1):
        if(n%2==0):
            n=n/2
        elif((n==3) or (n%4==1)):
            n-=1
        else:
            n+=1
        steps=steps+1

    return steps
```


Converted the solution to Java, and ran commenting negative test case value, which fails. That means the Google test cases does not contain negative test cases.


The converted solution fails
```java
public static int solution(String s) {
        int n = Integer.valueOf(s);

        if ( n == 0 )
            return 1;

        if ( n == 1 )
            return 0;

        int count = 0;

        if ( n < 0 ) {
            n *= -1;
            count += 2;
        }

        while (n > 1) {
            count++;

            if(n%2==0)
                n=n/2;
            else if((n==3) || (n%4==1))
                n-=1;
            else
                n+=1;
        }
        return count;
    }
}
```

Java solution fails because of the datatype. Trying out with BigInteger.
There was a case to get n%4 which needed to be done in binary operation.
https://www.geeksforgeeks.org/find-the-remainder-when-n-is-divided-by-4-using-bitwise-and-operator


#### Third Attempt
https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html#compareTo-java.math.BigInteger

After using BigInteger datatype the solution passes tests.
```java
public static int solution(String s) {
        BigInteger n = new BigInteger(s);
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        BigInteger four = new BigInteger("4");

        int count = 0;

        while (n.compareTo(one) == 1) {
            count++;

            if( n.and(one).equals(zero) )
                n = n.divide(two);
            else if ( n.equals(three) || n.mod(four).equals(one))
                n = n.subtract(one);
            else
                n = n.add(one);
        }

        return count;
    }
```

Some more improvement:
```
public static int solution(String s) {
        BigInteger n = new BigInteger(s);
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        BigInteger four = new BigInteger("4");
        int count = 0;

        while (n.compareTo(one) == 1) {
            count++;

            if( n.and(one).byteValueExact() == 0 )
                n = n.divide(two);
            else if ( n.equals(three) || n.mod(four).byteValueExact() == 1)
                n = n.subtract(one);
            else
                n = n.add(one);
        }

        return count;
    }
```

```
public static int solution(String s) {
        BigInteger n = new BigInteger(s);
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger four = new BigInteger("4");
        int count = 0;

        while (n.compareTo(one) == 1) {
            count++;

            if( n.and(one).byteValue() == 0 )
                n = n.divide(two);
            else if ( n.byteValue() == 3 || n.mod(four).byteValue() == 1)
                n = n.subtract(one);
            else
                n = n.add(one);
        }

        return count;
    }
```

The problem I would like to solve is if there is better way to do things binary operations wise.
At the moment the choice to make is either use `n.byteValue()` to compare with the integer or use the function n.equals(BigInteger).

https://stackoverflow.com/questions/43955698/most-run-time-efficient-way-to-compare-two-very-large-numbers-bigger-than-long

Asked StackOverflow community for code review:
https://codereview.stackexchange.com/questions/253498/how-can-we-optimizing-java-biginteger-operations

I believe that there could be a separate fn for smaller data size.

### Fourth Attempt - Optimization
- [] How efficient is BigInteger when the input size is int or long? Should there be separate mechanism to handle these primitives? Or How efficient BigInteger handling them?  Does BigInteger converts when the number becomes smaller which fits in int and long?

- [] Find possible alternate solution completely based on bit manipulation.


https://stackoverflow.com/questions/7000082/efficient-biginteger-in-java
https://stackoverflow.com/questions/29127511/how-to-optimize-the-code-that-uses-biginteger-operations-for-execution-time

https://contributors.scala-lang.org/t/optimizing-bigint-for-small-integers/3412/8
"I’m not considering reimplementing BigInteger. As per OpenJDK code, it is already based on Array[Int], and some operations are candidates for intrinsics."
"The JVM BigInteger type is not exactly performant compared to other languages. I have no idea why it is not optimized further (see http://www.wilfred.me.uk/blog/2014/10/20/the-fastest-bigint-in-the-west/ 21 )"


https://www.ibm.com/support/pages/apar/IV69419
Fixed. Performance issue can be sometimes be observed when java.math.BigInteger class run in bytecode instrumentation mode(for example, when java agent is used).

http://www.cs.yorku.ca/tech/other/java/docs/api/java.math.BigInteger.html
https://www.baeldung.com/java-bigdecimal-biginteger


https://www.codementor.io/@arpitbhayani/how-python-implements-super-long-integers-12icwon5vk

https://codeforces.com/blog/entry/17235 | https://github.com/bwakell/Huldra
Calculate 1337! using BigInteger: 
```
    BigInteger fac = BigInteger.ONE;
    for(int i = 1; i<=1337; i++) fac = fac.multiply(BigInteger.valueOf(i)); 
```

"
BigInteger is immutable it must allocate a new array for the results, convert the int to a BigInteger object, perform the multiplication (using a general algorithm), create a new object and return it. The overhead is massive and unnecessary. 
BigInteger is not suitable for many small operations. Is it suitable for operations using larger operands? As it turns out, no it's not.

The following time measurements are a results of some benchmarks run on my shitty 1.65GHz Dual Core computer.
    Parsing: Converting two strings of length 500000 representing numbers in base 10 to the internal representation.
    Add: Adding a 100000 decimal digit number to another equally sized number, 100000 times. (MidBig-size cumulative benchmark.)
    Sub: Same as the addition experiment, but with subtractions.
    MidMul: Multiplying a 300 decimal digit number to a growing product, initially a 300 decimal digit number. (Mid-size cumulative benchmark.)
    TinyMul: The naive straightforward way to calculate 50000! (Small-size cumulative benchmark.)
    BigMul: Multiplication of two 500000 decimal digit numbers. (Big-size benchmark.)
    MidDiv: Dividing a 400000 decimal digit number by a 4000 decimal digit number a 1000 times. (Mid-size cumulative benchmark.)
    BigDiv: Dividing a 400000 decimal digit number by a 200000 decimal digit number. (Big-size benchmark.)
    toString: Converting the internal representation (having in decimal 213237 digits) to a decimal number string.

Test        BigInteger    
----------------------
Parsing     31.602s       
Add         6.394s        
Sub         5.618s        
MidMul      2.676s        
TinyMul     10.683s       
BigMul      12.332s       
MidDiv      9.936s        
BigDiv      3.647s        
toString    16.912s       

"

https://stackoverflow.com/questions/51058385/see-if-number-is-smaller-than-232/51058796


https://nullbeans.com/what-is-a-biginteger-and-how-to-use-it-in-java
BigIntegers are Immutable
Notice that each time you perform an arithmetic operation, a new BigInteger instance is produced. This is because already instantiated instances of BigIntegers are immutable. In other words, once you have created an instance, you cannot change the value of that instance. One can only assume that this was done by the Java creators because it was simpler to implement and less error prone, However, this also comes at the cost of memory as for each new instance, a new place in the JVM memory is reserved.


https://www.baeldung.com/java-binary-numbers
https://riptutorial.com/java/example/12139/binary-logic-operations-on-biginteger
https://stackoverflow.com/questions/30703166/finding-the-appropriate-java-datatype

https://www.geeksforgeeks.org/java-tricks-competitive-programming-java-8/
    n = n >> 1;   // Divide n by 2

https://codereview.stackexchange.com/questions/56512/why-are-these-functions-slower-than-bigintegers-included-methods


### Fifth Attempt - Optimization Continued
- [ ] Get the power of two

Note that (2 ^ 32) ^ Integer.MAX_VALUE is implementation-dependent. Theoretically BigInteger has no max value

https://stackoverflow.com/questions/31748028/long-vs-biginteger?noredirect=1&lq=1
https://stackoverflow.com/questions/55752927/how-to-convert-an-unsigned-long-to-biginteger#55752928
https://stackoverflow.com/questions/739532/logarithm-of-a-bigdecimal
https://en.wikipedia.org/wiki/Power_of_two

> Final Solution
```java
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static int solution(String s) {
        BigInteger n = new BigInteger(s);

        if ( isPrimitive(n) ) {
            return longOps(0, n.longValue());
        }

        return bigIntOps(n);
    }

    public static int bigIntOps(BigInteger n) {
        BigInteger one = BigInteger.ONE;
        BigInteger four = new BigInteger("4");
        int count = 0;

        while (n.compareTo(one) > 0) {
            count++;

            // If number is divisible by 2
            if (n.and(one).byteValue() == 0) {
                n = n.shiftRight(1); // Binary Division

                if ( isPrimitive(n) )
                    return longOps(count, n.longValue());

            } else if (n.byteValue() == 3 || n.mod(four).byteValue() == 1)
                n = n.subtract(one);

            else
                n = n.add(one);
        }

        return count;
    }

    public static int longOps(int count, long n) {

        while (n > 1) {
            count++;

            // If number is divisible by 2
            if ( (n & 1) == 0 )

                // Check if the number is power of two
                if ((n&(n-1)) == 0)
                    // Return the power of two + counts
                    return (int)Math.ceil(Math.log(n)/Math.log(2)) + count - 1;
                else
                    n = n >> 1;// Binary Division

            else if ( n == 3 || n%4 == 1 )
                n--;
            else
                n++;
        }

        return count;
    }

    public static boolean isPrimitive(BigInteger n) {
        return n.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) < 0;
    }
}
```
From the research, BigInteger operations are memory intensive and hence slow. Hence, the processing was divided into BingInteger processing and Long processiing.

A check was made at first to see if the number is Long, and the processing was divided based on the number.
Check was also made in the BigInteger processing to check if the remainder was a Long, and if true, further processing was done for Long processing.

I found a sweet math solution to find the 2 power of number:
`Math.ceil(Math.log(x)/Math.log(2))`

This solution provided a single statement to find the number of steps.

Unfortunately BigInteger does not provide Math.log() functionality so this could not be implemented which could have been a great solution.