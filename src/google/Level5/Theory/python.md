# Python 

## Tuples vs Lists

Tuple | List
--|--
Tuple has static characteristics | The list has dynamic characteristics
Tuple has less functionality | Lists have more functionality than a tuple
Tuple is immutable | Lists are mutable
Tuple consume less memory than a list | Lists consume more memory
Tuples are enclosed with a round bracket() | List are commonly enclosed with the square bracket[]
Syntax: `my_tuple=(1,2,3,4,5,5)` | Syntax: `my_list=[1,2,3,4,5,5]`

Once tuple created, it cannot change its value as a tuple is immutable but we can change by converting the tuple into a list and converting the list back to a tuple.

## Set
Set is an unordered collection of unique items and it is unindexed. It is created by placing all items inside the curly braces.
```python
>>> my_sets = {"Apple", "Orange", "Banana", "Banana"}
>>> print(my_sets) 
{'Banana', 'Orange', 'Apple'} 
```
Here repeated "Banana" are removed.

## Dictionary
Key-Value pair.
```python
>>> my_dictionary = {'y':2, 'u':1, 'm':1, 'y':2}
```

## Counter
Counter is a container that keeps the count of each element present in the container. 

It is a subclass of the dictionary class that returns
back the dictionary which will have the count of each element of the data structure passed to the Counter.

```python
>>> from collections import Counter
>>> list = ['rose','tulips','sunflowers','tulips','rose']
['rose', 'tulips', 'sunflowers', 'tulips', 'rose']
>>> my_count =  Counter(list)
>>> print(my_count)
Counter({'rose': 2, 'tulips': 2, 'sunflowers': 1})
```
A list is passed to the Counter which is converted 
to a hashtable object with key of the element and values of the number of those elements.

When a tuple is given to the counter, it will be converted to a hashtable object. The element will be keys and the values will be the count of the elements.

Similarly, when the dictionary (key-value pairs) is given to the counter, it will be converted to a hashtable objects. The elements will become keys and the values will be the count of the elements.

```python
my_dictionary = {'y':2, 'u':1, 'm':1, 'y':2}
>>> print(my_dictionary)
{'y': 2, 'u': 1, 'm': 1}
>>> my_count =  Counter(my_dictionary)
>>> print(my_count)
Counter({'y': 2, 'u': 1, 'm': 1})
```

It will also convert a string into a hashtable with key of character and values as their count.
```python
>>> my_count = Counter("StringCounter")
>>> print(my_count)
Counter({'t': 2, 'r': 2, 'n': 2, 'S': 1, 'i': 1, 'g': 1, 'C': 1, 'o': 1, 'u': 1, 'e': 1})
```
Like other data structures, we can update and delete and do other operation with the Counter.


# Iterables, Generators and Yield
When we create a list, you can read its items one by one. Reading its items one by one is called iteration:
```python
>>> mylist = [1, 2, 3]
>>> for i in mylist:
...    print(i)
1
2
3
```

mylist is an iterable. When we use `a list comprehension`, we create a list, and so an iterable:

```python
>>> mylist = [x*x for x in range(3)]
>>> for i in mylist:
...    print(i)
0
1
4
```

How can we know if a Collection of Data is Iterable or Not? We can use the dir function and pass an object inside it to check.
`print(dir({}))`

```python
data  = {'color':'white','car':'audi','mobile':'apple'}

print(data.values())

for item indata.values():
    print(item)

for item in data.items():
    print(item)

print(data.keys())
for item indata.keys():
    print(item)

for key, value indata.items():
    print(key, value)
```

Everything we use `for... in...` on is an iterable; lists, strings, files...

These iterables are handy because we can read them as much as you want, but we store all the values in memory and this is not always what we want when we have a lot of values.

For that we have generators. Generators are iterators. A kind of iterable we can only iterate over once which do not store all the values in memory, they generate the values on the fly.

```python
>>> mygenerator = (x*x for x in range(3))
>>> for i in mygenerator:
...    print(i)
0
1
4
```
It is just the same except we used `()` instead of `[]`. BUT, we cannot perform for `i` in mygenerator a second time since generators can only be used once: they calculate 0, then forget about it and calculate 1, and end calculating 4, one by one.

### Yield

yield is a keyword that is used like return, except the function will return a generator.

```python
>>> def create_generator():
...    mylist = range(3)
...    for i in mylist:
...        yield i*i
...
>>> mygenerator = create_generator() # create a generator
>>> print(mygenerator) # mygenerator is an object!
<generator object create_generator at 0xb7555c34>
>>> for i in mygenerator:
...     print(i)
0
1
4
```

Here it's a useless example, but it's handy when we know your function will return a huge set of values that you will only need to read once.

# Yield
## Yield Vs. Return
Before you understand the difference between yield and return in Python, it’s very important to understand the differences between a normal function that uses a return statement and a generator function that uses a yield statement.

A normal function directly stores and returns the value. However, generator functions return generator objects which contain all the values to be returned and they store them locally, thus reducing a lot of memory usage. 

Also, when you call a normal function, the execution stops as soon as it gets to the return statement. Hence, after starting, you can’t stop the execution of a normal function. However, in the case of generator functions, as soon as it reaches the first yield statement, it stops the execution and sends the value to the generator function. When the caller iterates over this value, then the next yield statement is processed, and the cycle continues. 


Yield|Return
--|--
When the caller calls the generator function, it packs all the return values from yield into a generator object and returned. Also, the code execution starts only when the caller iterates over the object. | It returns only a single value to the caller, and the code execution stops as soon as it reaches the return statement.
When a caller calls the generator function, the first yield is executed, and the function stops. It then returns the generator object to the caller where the value is stored. When the caller has accessed or iterated over this value, then the next yield statement is executed and the cycle repeats. | When the caller calls a normal function, the execution begins and ends as soon as it reaches a return statement. It then returns the value to the caller.
You can use multiple yield statements in a generator function. | Only one return statement in a normal function can be used.
There is no memory allocation when you use yield keywords. | For all the returned values, memory is allocated.
Extremely memory-efficient, especially dealing with large data sets. | Should be used only with small data sets.
For large data sets, execution time is faster when the yield keyword is used. | More execution time since extra processing has to be done if the data size is large.

Example of return function:
```python
from random import randint
 
def get_random_ints(count, begin, end):
    print("get_random_ints start")
    list_numbers = []
    for x in range(0, count):
        list_numbers.append(randint(begin, end))
    print("get_random_ints end")
    return list_numbers
 
 
print(type(get_random_ints))
nums = get_random_ints(10, 0, 100)
print(nums)

Output:
<class 'function'>
get_random_ints start
get_random_ints end
[4, 84, 27, 95, 76, 82, 73, 97, 19, 90]
```

Example with `yield`
```python
def get_random_ints(count, begin, end):
    print("get_random_ints start")
    for x in range(0, count):
        yield randint(begin, end)
    print("get_random_ints end")
 
 
nums_generator = get_random_ints(10, 0, 100)
print(type(nums_generator))
for i in nums_generator:
    print(i)

# Output:
<class 'generator'>
get_random_ints start
70
15
86
8
79
36
37
79
40
78
get_random_ints end
```
Notice that the type of nums_generator is generator.
The first print statement is executed only once when the first element is retrieved from the generator.
Once, all the items are yielded from the generator function, the remaining code in the generator function is executed. That’s why the second print statement is getting printed only once and at the end of the for loop.



## Why And When Should You Use Yield?
When you use a yield keyword inside a generator function, it returns a generator object instead of values. In fact, it stores all the returned values inside this generator object in a local state. If you have used the return statement, which returned an array of values, this would have consumed a lot of memory. Hence, yield should always be preferred over the return in such cases. 

Moreover, the execution of the generator function starts only when the caller iterates over the generator object. Hence, it increases the overall efficiency of the program along with decreasing memory consumption. Some situations where you should use yield are: 
- When the size of returned data is quite large, instead of storing them into a list, you can use yield.
- If you want faster execution or computation over large datasets, yield is a better option.
- If you want to reduce memory consumption, you can use yield.
- It can be used to produce an infinite stream of data. You can set the size of a list to infinite, as it might cause a memory limit error.
- If you want to make continuous calls to a function that contains a yield statement, it starts from the last defined yield statement, and hence, you can save a lot of time.

### Example - Reading File

Simple return.

```python
import resource
import sys
 
def read_file(file_name):
    text_file = open(file_name, 'r')
    line_list = text_file.readlines()
    text_file.close()
    return line_list
 
file_lines = read_file(sys.argv[1])
 
print(type(file_lines))
 
print(len(file_lines))
 
for line in file_lines:
    print(line)
 
print('Peak Memory Usage =', resource.getrusage(resource.RUSAGE_SELF).ru_maxrss)
print('User Mode Time =', resource.getrusage(resource.RUSAGE_SELF).ru_utime)
print('System Mode Time =', resource.getrusage(resource.RUSAGE_SELF).ru_stime)
```

Yield implementation.
```python
import resource
import sys
 
def read_file_yield(file_name):
    text_file = open(file_name, 'r')
    while True:
        line_data = text_file.readline()
        if not line_data:
            text_file.close()
            break
        yield line_data
 
file_data = read_file_yield(sys.argv[1])
print(type(file_data))
 
for l in file_data:
    print(l)
 
print('Peak Memory Usage =', resource.getrusage(resource.RUSAGE_SELF).ru_maxrss)
print('User Mode Time =', resource.getrusage(resource.RUSAGE_SELF).ru_utime)
print('System Mode Time =', resource.getrusage(resource.RUSAGE_SELF).ru_stime)
```

File Size|Return Statement|Generator Function
--|--|--
4 KB | Memory: 5.3 MB, Time: 0.023s | Memory: 5.42 MB, Time: 0.027s
324 KB | Memory: 9.98 MB, Time: 0.028s | Memory: 5.37 MB, Time: 0.32s
26 MB | Memory: 392.8 MB, Time: 27.03s | Memory: 5.52 MB, Time: 29.61s
263 MB | Memory: 3.65 GB, Time: 273.56s | Memory: 5.55 MB, Time: 292.99s

The memory usage is directly proportional to the file size with the return statement. It’s almost constant with the generator function.

The example here is to show the benefits of using yield keyword when the function is producing large amount of data. The Python file already has a built-in function `readline()` for reading file data line by line, which is memory efficient, fast and simple to use.

## Send Value
We can also send values to the generator function using the send() function.

When send() function is called to start the generator, it must be called with None as the argument, because there is no yield expression that could receive the value. Otherwise, we will get error: `TypeError: can’t send non-None value to a just-started generator`.

```python
def processor():
    while True:
        value = yield
        print(f'Processing {value}')
 
 
data_processor = processor()
 
print(type(data_processor))
 
data_processor.send(None)
 
for x in range(1, 5):
    data_processor.send(x)
```

The “yield from expression” is used to create a sub-iterator from given expression. All the values produced by the sub-iterator is passed directly to the caller program.

The actual benefit of “yield from” is visible when we have to send data to the generator function.

```
def printer():
    while True:
        data = yield
        print("Processing", data)
 
 
def printer_wrapper(gen):
    yield from gen
 
 
pr = printer_wrapper(printer())
 
# Below code to avoid TypeError: can't send non-None value to a just-started generator
pr.send(None)
 
for x in range(1, 5):
    pr.send(x)


# Output:
Processing 1
Processing 2
Processing 3
Processing 4

```

# Resource
- [ ] https://stackoverflow.com/questions/231767/what-does-the-yield-keyword-do
- [ ]  https://www.simplilearn.com/tutorials/python-tutorial/yield-in-python
- [ ]  https://www.askpython.com/python/python-yield-examples
