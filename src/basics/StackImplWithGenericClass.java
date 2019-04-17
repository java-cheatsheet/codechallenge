package basics;
import java.util.*;

/**
 * https://www.hackerrank.com/topics/stacks
 *
 * @param <E>
 */
class Stack<E> {

    private class Element<E> {
        // The data value of the element
        private E data;
        // The next element in the stack
        private Element<E> next;

        Element(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // The element at the top of the stack
    private Element<E> top;

    /** Create an empty stack **/
    public Stack() {
        this.top = null;
    }

    /** @return true if the stack is empty, false if it is not.
     **/
    public boolean isEmpty() {
        return top == null;
    }

    /**
     Pushes a value onto the top of the stack.
     @param value The data for the stack's new top element.
     **/
    public void push(E value) {
        // Create new top element
        Element<E> newTop = new Element<E>(value);

        // If the stack is not empty
        if(!isEmpty()) {
            // Set old top's next variable to point to new top
            newTop.next = top;
        }

        // Set new top regardless of whether or not stack is empty
        this.top = newTop;
    }

    /**
     Remove the element at the top of the stack.
     @return the data associated with the stack's topmost element being removed.
     @throws EmptyStackException if the stack contains no elements.
     **/
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        Element<E> oldTop = top;
        this.top = top.next;

        return oldTop.data;
    }

    /**
     'View' the element at the top of the stack.
     @return the data associated with the stack's topmost element.
     @throws EmptyStackException if the stack contains no elements.
     **/
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }
}


class StackImplWithGenericClass {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<Integer>();

        try {
            intStack.pop();
        }
        catch(EmptyStackException e) {
            System.out.println("We cannot pop off an empty stack.");
        }

        for(int i = 0; i < 4; i++) {
            intStack.push(i);
            System.out.println("New Top: " + intStack.peek());
        }
        for(int i = 0; i < 4; i++) {
            System.out.println("Popped: " + intStack.pop());
        }

        try {
            intStack.peek();
        }
        catch(EmptyStackException e) {
            System.out.println("We cannot peek at an empty stack.");
        }
    }
}