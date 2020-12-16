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