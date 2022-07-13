

package hackerrank.DataStructure.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    static Queue<Integer> qN = new LinkedList<>();

    public static void levelOrder(Node root) {
        System.out.println(levelOrderQ(root));
    }

//     Level-Order Traversal (Breadth First Search)
    public static String levelOrderQ(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return "";
        }

        LinkedList<Node> nodeQueue = new LinkedList<>();
        LinkedList<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        levelQueue.offer(1);//start from 1

        while(!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            int level = levelQueue.poll();

            List<Integer> l=null;

            if(result.size()<level){
                l = new ArrayList<>();
                result.add(l);
            }else{
                l = result.get(level-1);
            }

            l.add(node.data);

            if(node.left!=null){
                nodeQueue.offer(node.left);
                levelQueue.offer(level+1);
            }

            if(node.right!=null){
                nodeQueue.offer(node.right);
                levelQueue.offer(level+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size()   ; j++) {
                sb.append( result.get(i).get(j) + " ");
            }
        }

        return sb.toString().trim();
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void printPostorder(Node node, StringBuilder s) {


        if (node == null) return;

        // first recur on both subtrees
        printPostorder(node.left, s);
        printPostorder(node.right, s);

        // then deal with the node
        System.out.printf("%d ",node.data);
//        s.append(node.data + " ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}

class LevelOrderTravelsalTest {
    @Test
    void SampleTest0() {
        int[] nodes = new int[]{1, 2, 5, 3, 6, 4};
        String expectedNodesStr = "1 2 5 3 6 4";
//        System.out.println(Arrays.stream(nodes).collect(Collectors.joining(" ")));
//        Arrays.stream(nodes).forEach(System.out::print);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nodes).forEach(s -> sb.append(s + " "));//(s -> System.out.print( s + " "));
        Node root = null;

        for ( int i = 0; i < nodes.length; i++ ) {
            root = Solution.insert(root, nodes[i]);
        }

        Assertions.assertEquals(sb.toString().trim(), Solution.levelOrderQ(root));
    }

    @Test
    void SampleTest0Recursive() {
        int[] nodes = new int[]{1, 2, 5, 3, 6, 4};
        String expectedNodesStr = "1 2 5 3 6 4";
//        System.out.println(Arrays.stream(nodes).collect(Collectors.joining(" ")));
//        Arrays.stream(nodes).forEach(System.out::print);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nodes).forEach(s -> sb.append(s + " "));//(s -> System.out.print( s + " "));
        Node root = null;

        for ( int i = 0; i < nodes.length; i++ ) {
            root = Solution.insert(root, nodes[i]);
        }

        StringBuilder s = new StringBuilder("");
        Solution.printPostorder(root, s);
        Assertions.assertEquals(sb.toString().trim(), s.reverse().toString().trim());
    }

    @Test
    void SumArrayOfIntegers() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(20);

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }



        int[] nodes = new int[]{1, 2, 5, 3, 6, 4};
        String expectedNodesStr = "1 2 5 3 6 4";
//        System.out.println(Arrays.stream(nodes).collect(Collectors.joining(" ")));
//        Arrays.stream(nodes).forEach(System.out::print);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nodes).forEach(s -> sb.append(s + " "));//(s -> System.out.print( s + " "));
        Node root = null;

        for ( int i = 0; i < nodes.length; i++ ) {
            root = Solution.insert(root, nodes[i]);
        }

        StringBuilder s = new StringBuilder("");
        Solution.printPostorder(root, s);
        Assertions.assertEquals(sb.toString().trim(), s.reverse().toString().trim());
    }

    @Test
    void FizzBuzz() {
        for (int i = 1; i <= 10 ; i++) {

            if ( i%3 ==0 && i%5 ==0 ) {
                System.out.println("FizzBuzz");
            } else if ( i%3 ==0 && i%5 != 0 ) {
                System.out.println("Fizz");
            } else if ( i%3 !=0 && i%5 == 0 ) {
                System.out.println("Buzz");
            } else if ( i%3 !=0 && i%5 !=0 ) {
                System.out.println(i);
            }
        }

    }
    @Test
    void MaxPack() {
        // index begins at 1
        // To combine p[i] < p[i+1]
        // return the  max package, which must be the value at the front of the array.

        // Check if p[i]<p[i+1],
        // true p[i+1] = p[i]+p[i+1]
        // remove p[i]

        // Check p[i+1] > p[i]

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(20);
        numbers.add(13);
        numbers.add(8);
        numbers.add(9);

//        for (int i = 0; i < numbers.size() && numbers.get(i) < numbers.get(i+1); i++) {
//
//            if ( numbers.get(i) < numbers.get(i+1) ) {
//                numbers.set(i+1, numbers.get(i)+numbers.get(i+1));
//                numbers.remove(i);
//            }
//
//        }

        // use stack
        // push 20
        // get next number
        // check if it is greater than 20
        // if true sum the two numbers
        // pop the number
        // push the '
//
//        numbers.add(20); push
//        numbers.add(13); push
//        numbers.add(8); push
//        numbers.add(9); pop 8, sum two
//        peek 13th position and check if it is lower than sum,
//        17 > 13, pop 13, sum them
//        peek position before thirteen and check if it is lower than sum
//        30 > 20, pop 20 sum
//        Loop should be either the stack is empty of the length of the list
        Stack<Long> stk= new Stack<>();
//        boolean result = stk.empty();
        stk.push(numbers.get(0).longValue());

        for (int i = 1; i < numbers.size() && stk.isEmpty(); i++) {

            if ( numbers.get(i-1) < numbers.get(i) ) {
                Long x = (Long) stk.pop()+ numbers.get(i-1);
                stk.push(x);
            }
        }
    }
}

/**
 * NOTE:
 *
 * https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 * Solution from:
 *
 * Recursive http://cslibrary.stanford.edu/110/BinaryTrees.html
 * The printed solution is reverted.
 *
 * Iterative solution with LinkedList
 * https://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java
 *
 * Recursive implementation is straight forward.
 * Printing the output was an issue because of
 * recursion.
 *
 *
 * Research on the implemented data structures.
 * https://www.geeksforgeeks.org/java-util-linkedlist-poll-pollfirst-polllast-examples-java
 * https://docs.oracle.com/javase/8/docs/api/index.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * https://www.javatpoint.com/java-list
 * https://www.geeksforgeeks.org/arraylist-in-java
 *
 * https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html

 When a deque is used as a queue, FIFO (First-In-First-Out)
 behavior results.

 Deques can also be used as LIFO (Last-In-First-Out)
 stacks. This interface should be used in preference
 to the legacy Stack class. When a deque is used as
 a stack, elements are pushed and popped from the
 beginning of the deque.

 Unlike the List interface, this interface does not
 provide support for indexed access to elements.
 Resizable-array implementation of the Deque interface.

 Array deques have no capacity restrictions;
 they grow as necessary to support usage.
 They are not thread-safe; in the absence of
 external synchronization, they do not support
 concurrent access by multiple threads. Null
 elements are prohibited. This class is likely
 to be faster than Stack when used as a stack,
 and faster than LinkedList when used as a queue.

 Most ArrayDeque operations run in amortized
 constant time. Exceptions include remove,
 removeFirstOccurrence, removeLastOccurrence,
 contains, iterator.remove(), and the bulk
 operations, all of which run in linear time.

 * https://www.geeksforgeeks.org/linked-list-in-java
 * https://www.geeksforgeeks.org/arraylist-in-java
 *
 * https://www.javatpoint.com/difference-between-arraylist-and-linkedlist

 When the rate of addition or removal rate is more than the read scenarios, then go for the LinkedList. On the other hand, when the frequency of the read scenarios is more than the addition or removal rate, then ArrayList takes precedence over LinkedList.
 Since the elements of an ArrayList are stored more compact as compared to a LinkedList; therefore, the ArrayList is more cache-friendly as compared to the LinkedList. Thus, chances for the cache miss are less in an ArrayList as compared to a LinkedList. Generally, it is considered that a LinkedList is poor in cache-locality.
 Memory overhead in the LinkedList is more as compared to the ArrayList. It is because, in a LinkedList, we have two extra links (next and previous) as it is required to store the address of the previous and the next nodes, and these links consume extra space. Such links are not present in an ArrayList.

 * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
 public class LinkedList<E>
 extends AbstractSequentialList<E>
 implements List<E>, Deque<E>, Cloneable, Serializable

 * https://www.quora.com/What-is-the-difference-between-a-priority-queue-and-a-queue
 *

 In a priority queue, an element with high priority is served before an element with low priority. 'If two elements have the same priority, they are served according to their order in the queue' i think this will answer your question

 When you insert into the queue, the elements can be inserted in any order, but the removal happens according to the priority/ value assigned to it. So, usually a function pointer determines how the priority/value is assigned, and thus what comes out first. So, elements with the highest priority come out first. The confusion usually comes when you have a function pointer that assigns a minimum value the highest priority.

 * https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples
 * https://stackabuse.com/java-how-to-print-an-array-in-one-line
 *

 Iterative solution works fine. Tried recursive
 solution as well but the provided solution fails
 for the given test case it does not traverse
 postOrder or Level Order Breadth First Search
 correctly.

 Expected :1 2 5 3 6 4
 Actual   :1 2 5 6 3 4

 At some point it traverses right node first
 as seen in the output, i.e. 6 is printed
 first.
 */