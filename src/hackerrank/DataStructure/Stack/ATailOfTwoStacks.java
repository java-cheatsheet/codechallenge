package hackerrank.DataStructure;

import java.util.Scanner;
import java.util.Stack;


/**
 * Problem:
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/
 *
 * Implement two stacks to provide features of queue.
 *
 */
public class ATailOfTwoStacks {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyQueueExpensive<Integer> queue = new MyQueueExpensive<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();

    }

}


class MyQueue<Integer> {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(Integer value) {
        stack1.push(value);
    }

    public String peek() {
        prepOld();
        return stack2.peek().toString();
    }

    public void dequeue() {
        prepOld();
        stack2.pop();
    }

    public void prepOld(){
        if (stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

}


/**
 * Does not pass the hackerrank submission.
 *
 * @param <Integer>
 */
class MyQueueExpensive<Integer>
{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(Integer x) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

     public void dequeue() {
        if ( !s1.isEmpty() )
            s1.pop();
    }

    public String peek() {
        if ( !s1.isEmpty() ) return s1.peek().toString();
        else return "";
    }

}
