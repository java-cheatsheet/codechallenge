package datastructures;
import java.util.*;
import java.io.*;

public class DataStructuresInJava {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        printNamePh();
//        basicQueue();
//        priorityQueueImpl();
//        maxPriorityQueue();
        arrayDequeExample();
    }

    public static void dsTreeSet() {

        // Create the sorted set
        SortedSet set = new TreeSet();

        // Add elements to the set
        set.add("bxz");
        set.add("abt");
        set.add("anit");

        // Iterating over the elements in the set
        Iterator it = set.iterator();

        while (it.hasNext()) {
            // Get element
            Object element = it.next();
            System.out.println(element.toString());
            }

    }

    public static void dsLinkedList() {
        // Creating object of class linked list
        LinkedList<String> object = new LinkedList<String>();

        // Adding elements to the linked list
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add("F");
        object.add("G");
        System.out.println("Linked list initial: " + object);

        // Removing elements from the linked list
        object.remove("B");
        object.remove(3);
        object.removeFirst();
        object.removeLast();
        System.out.println("Linked list after deletion: " + object);

        // Finding elements in the linked list
        boolean status = object.contains("E");

        if(status)
            System.out.println("List contains the element 'E' ");
        else
            System.out.println("List doesn't contain the element 'E'");

        // Number of elements in the linked list
        int size = object.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list
        Object element = object.get(2);
        System.out.println("Element returned by get() : " + element);
        object.set(2, "Y");
        System.out.println("Linked list after change : " + object);
    }

    public static void basicsList(){

        int[] unsorted = {1,4,7,8,3,2,9};
        List<Integer> list = List.of(3, 2, 1);

//        Convert list to int[]
        int[] intArr = list.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(intArr));


        List<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        arrayList.get(0);
        arrayList.add(0, 12);

        System.out.println(arrayList);
//        list is unchanged
        System.out.println(list);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            a.add(i);
            b.add(i);
        }

        a.set(5, 0);
        b.remove(5);
        System.out.println(a); // [0, 1, 2, 3, 4, 0, 6, 7, 8, 9]
        System.out.println(b); // [0, 1, 2, 3, 4, 6, 7, 8, 9]
        System.out.println(a.get(1));


    }

    public static void basicStack(){
        Stack<Integer> stacka = new Stack<>();
        stacka.push(1);
        stacka.push(2);
        System.out.println(stacka.pop().toString()); // 2
        stacka.push(3);
        System.out.println(stacka); // [1, 3]
    }

    public static void basicQueue() {
        System.out.println(1);

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack); // [1, 2, 3]

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        System.out.println(queue);

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        System.out.println(stack); // [3, 2, 1]
    }

    public static void basicsHashMaps() {
        HashSet<String> set = new HashSet<>();
        set.add("dog");
        set.add("cat");
        set.add("fish");
        System.out.println(set.contains("dog")); // true
        System.out.println(set.contains("horse")); // false

        HashMap<String, String> map = new HashMap<>();
        map.put("Jenny", "867-5309");
        System.out.println(map.get("Jenny")); // 867-5309
    }

    public static void readInputCMD() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

//            int res = minimumSwaps(arr);

//            bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    public static void printNamePh(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<String, Integer> contact = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            contact.put(name, phone);
//            contact.put("anit", 1);
//            contact.put("dipta", 2);
//            contact.put("baby", 3);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if (contact.containsKey(s))
                System.out.println(s +"="+ contact.get(s));
            else System.out.println("Not found");
        }
        in.close();
    }

    public static void priorityQueueImpl() {
        /**
         In Priority Queue, the front of the queue has the least elements as per the natural ordering and the rear is pointed to the greatest element in the queue.
         Thus when an element is removed from the priority queue, then it will be the least element.
         Similarly, for an alphabetical priority queue, ASCII values will be considered and the queue elements will be ordered as per the ASCII values.
         The head or front of the queue contains the least element as per the natural ordering.
         Priority Queue implementation is not thread-safe. Thus if we desire synchronized access, we should use the PriorityBlockingQueue.
         The PriorityQueue class inherits Java Queue Interface and is a part of the java.util package.

         The time complexity of Priority Queue for insertion(enqueue) and deletion (dequeue) methods, is O(log(n)).
         Priority Queue has linear time complexity for remove as well as contains methods.
         The methods that retrieve elements of the Priority Queue have constant time complexity.

         */
        PriorityQueue<String> cities_queue = new PriorityQueue<String>();
        //initialize the PriorityQueue with values
        cities_queue.add("Sydney");
        cities_queue.add("Venice");
        cities_queue.add("New York");
        cities_queue.add("California");
        cities_queue.add("Melbourne");
        //print the head of the PriorityQueue
        System.out.println("PriorityQueue Head:" + cities_queue.element());
        //Define the iterator for PriorityQueue and print its elements
        System.out.println();

//        System.out.println("\nPriorityQueue contents:");
//        Iterator iter = cities_queue.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next() + " ");
//        }

        System.out.println(cities_queue);
    }

    public static void maxPriorityQueue() {
//        declare a PriorityQueue object with custom comparator to generate max PQ
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer lhs, Integer rhs) {
                    if (lhs < rhs) return +1;
                    if (lhs.equals(rhs)) return 0;
                    return -1;
                }
            });
            //add element to the PriorityQueue
            pq.add(8);
            pq.add(6);
            pq.add(4);
            pq.add(2);
            pq.add(12);
            pq.add(10);
            //display the max PriorityQueue
            System.out.println("The max Priority Queue contents:");
            Integer val = null;
            while( (val = pq.poll()) != null) {
                System.out.print(val + " ");
            }

        // A custom comparator that compares two Strings by their length.
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        // Create a Priority Queue with a custom Comparator
        PriorityQueue<String> colorsPriorityQueue = new PriorityQueue<>(customComparator);

        // Add items to a Priority Queue
        colorsPriorityQueue.add("Red");
        colorsPriorityQueue.add("Green");
        colorsPriorityQueue.add("Blue");
        colorsPriorityQueue.add("Cyan");
        colorsPriorityQueue.add("Magenta");
        colorsPriorityQueue.add("Yellow");

// Printing all elements
        System.out.println("\nThe PriorityQueue elements with custom Comparator:");
        Iterator iter1 = colorsPriorityQueue.iterator();
        while (iter1.hasNext())
            System.out.print(iter1.next() + " ");
    }

    public static void arrayDequeExample()
    {
        /**
         ArrayDeque class which is implemented in the
         collection framework provides us with a way
         to apply resizable-array. This is a special
         kind of array that grows and allows users to
         add or remove an element from both sides of
         the queue. Array deques have no capacity
         restrictions and they grow as necessary to
         support usage.

         They are not thread-safe which means that
         in the absence of external synchronization,
         ArrayDeque does not support concurrent access
         by multiple threads.

         ArrayDeque class is likely to be faster
         than Stack when used as a stack.

         ArrayDeque class is likely to be faster
         than LinkedList when used as a queue.

         ArrayDeque is not thread-safe. But the
         BlockingDeque interface in the
         java.util.concurrent class represents
         the deque. This deque is thread-safe.

         The ArrayDeque interface that implements
         the deque interface is memory efficient
         as it need not keep a track of the previous
         or next nodes. Also, it is a resizable
         implementation. Thus deque is faster than
         the stack.
         */
        Deque<String> deque = new LinkedList<String>();
        // add elements to the queue using various methods
        deque.add("One");           //add ()
        deque.addFirst("Two");      //addFirst ()
        deque.addLast("Three");     //addLast ()
        deque.push("Four");         //push ()
        deque.offer("Five");        //offer ()
        deque.offerFirst("Six");    //offerFirst ()
        deque.offerLast("Seven");   //offerLast ()
        System.out.println("Initial Deque: " + deque);

        // Iterate using standard iterator
        System.out.println("\n\nDeque contents using Standard Iterator:");
        Iterator iterator = deque.iterator();
        while (iterator.hasNext())
            System.out.print(" " + iterator.next());

        // Iterate using Reverse order iterator
        Iterator reverse = deque.descendingIterator();
        System.out.println("\n\nDeque contents using Reverse Iterator:");
        while (reverse.hasNext())
            System.out.print(" " + reverse.next());

        // Peek () method
        System.out.println("\n\nDeque Peek:" + deque.peek());
        System.out.println("\nDeque,After peek:" + deque);

        // Pop () method
        System.out.println("\nDeque Pop:" + deque.pop());
        System.out.println("\nDeque,After pop:" + deque);

        // contains () method
        System.out.println("\nDeque Contains Three: " +  deque.contains("Three"));

        deque.removeFirst();        //removeFirst ()
        deque.removeLast();         //removeLast ()
        System.out.println("\nDeque, after removing "  + "first and last elements: " + deque);
    }
}

/**
 * Queue array implementation.
 */
class ArrayQueue {
    private static int front, rear, capacity;
    private static int[] queue;

    ArrayQueue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // insert an element into the queue
    static void queueEnqueue(int item)  {
        // check if the queue is full
        if (capacity == rear) {
            System.out.print("\nQueue is full\n");
            return;
        }

        // insert element at the rear
        else {
            queue[rear] = item;
            rear++;
        }
    }

    //remove an element from the queue
    static void queueDequeue()  {
        // check if queue is empty
        if (front == rear) {
            System.out.print("\nQueue is empty\n");
            return;
        }

        // shift elements to the right by one place uptil rear
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }


            // set queue[rear] to 0
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
    }

    // print queue elements
    static void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.print("Queue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d = ", queue[i]);
        }
    }

    // print front of queue
    static void queueFront()
    {
        if (front == rear) {
            System.out.print("Queue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element of the queue: %d", queue[front]);
    }
    public static void main(String[] args) {
        // Create a queue of capacity 4
        ArrayQueue q = new ArrayQueue(4);

        System.out.println("Initial Queue:");
        // print Queue elements
        queueDisplay();

        // inserting elements in the queue
        queueEnqueue(10);
        queueEnqueue(30);
        queueEnqueue(50);
        queueEnqueue(70);

        // print Queue elements
        System.out.println("Queue after Enqueue Operation:");
        queueDisplay();

        // print front of the queue
        queueFront();

        // insert element in the queue
        queueEnqueue(90);

        // print Queue elements
        queueDisplay();

        queueDequeue();
        queueDequeue();
        System.out.print("\nQueue after two dequeue operations:");

        // print Queue elements
        queueDisplay();

        // print front of the queue
        queueFront();
    }


}

class LinkedListQueue
{
    private Node front, rear;
    private int queueSize; // queue size

    //linked list node
    private class Node {
        int data;
        Node next;
    }

    //default constructor - initially front & rear are null; size=0; queue is empty
    public LinkedListQueue()
    {
        front = null;
        rear = null;
        queueSize = 0;
    }


    //check if the queue is empty
    public boolean isEmpty()
    {
        return (queueSize == 0);
    }

    //Remove item from the front of the queue.
    public int dequeue()
    {
        int data = front.data;
        front = front.next;
        if (isEmpty())
        {
            rear = null;
        }
        queueSize--;
        System.out.println("Element " + data+ " removed from the queue");
        return data;
    }

    //Add data at the rear of the queue.
    public void enqueue(int data)
    {
        Node oldRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isEmpty())
        {
            front = rear;
        }
        else  {
            oldRear.next = rear;
        }
        queueSize++;
        System.out.println("Element " + data+ " added to the queue");
    }
    //print front and rear of the queue
    public void print_frontRear() {
        System.out.println("Front of the queue:" + front.data
                + " Rear of the queue:" + rear.data);
    }
    public static void main(String[] a){

        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(6);
        queue.enqueue(3);
        queue.print_frontRear();
        queue.enqueue(12);
        queue.enqueue(24);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(9);

        queue.print_frontRear();
    }
}

/**

 The queue data structure is used for synchronization purposes. The queue is also used for disk and CPU scheduling.

 BlockingQueue is an Interface added in Java 1.5 and is a part of the java.util.concurrent package. This interface introduces blocking in case the BlockingQueue is full or empty.

 Thus when a thread accesses the queue and tries to insert (enqueue) elements in a queue that is already full is blocked till another thread creates a space in the queue (maybe by dequeue operation or clearing queue).

 Similarly, in the case of dequeuing, the operation is blocked if the queue is empty until the element becomes available for the dequeue operation.

 The BlockingQueue methods use some form of concurrency control like internal locks and are atomic. The BlockingQueue is a concurrent queue that manages the queue operations concurrently.

 BlockingQueue does not accept null values. An attempt to insert a null value in the queue results in NullPointerException.

 Some of the BlockingQueue implementations provided in Java are LinkedBlockingQueue, PriorityBlockingQueue, ArrayBlockingQueue, and SynchonousQueue. All these implementations are thread-safe.

 BlockingQueues are of two types:
 Bounded Queue

 In the bounded queue, the capacity of the queue is passed to the constructor of the queue.

 The queue declaration is as follows:

 BlockingQueue blockingQueue = new LinkedBlockingDeque (5);
 Unbounded Queue

 In the unbounded queue, we don’t set the capacity of the queue explicitly and it can grow in size. The capacity is set to Integer.MAX_VALUE.

 The declaration of the unbounded queue is as follows:

 BlockingQueue blockingQueue = new LinkedBlockingDeque ();

 The BlockingQueue interface is primarily used for producer-consumer types of problems wherein producer produces the resources and consumer consumes the resources.

 Not all queues are thread-safe but BlockingQueues in Java are thread-safe.

 */