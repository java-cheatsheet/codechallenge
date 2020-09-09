package datastructures;

import java.util.Scanner;

/**
 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right)
 * (b) Preorder (Root, Left, Right)
 * (c) Postorder (Left, Right, Root)
 *
 * Breadth First or Level Order Traversal : 1 2 3 4 5
 *
 * https://en.wikipedia.org/wiki/Depth-first_search
 * https://en.wikipedia.org/wiki/Breadth-first_search
 *
 * @param <T>
 */
class BinaryTreeHackerRank<T extends Comparable<T>> {
    /** A reference to the BinaryTreeHackerRank's left subtree. **/
    BinaryTreeHackerRank<T> left;
    /** A reference to the BinaryTreeHackerRank's right subtree. **/
    BinaryTreeHackerRank<T> right;
    /** The BinaryTreeHackerRank's contents. **/
    T data;

    /** Construct a BinaryTreeHackerRank object.
     @param data The BinaryTreeHackerRank's contents.
     **/
    public BinaryTreeHackerRank(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /** Insert new values into the tree.
     @param value The data value for the BinaryTreeHackerRank to insert.
     **/
    public void insert(T value) {
        // value <= data
        if(value.compareTo(data) <= 0) {
            if(left == null) {
                // Insert at empty subtree
                left = new BinaryTreeHackerRank<T>(value);
            }
            else {
                // Continue searching for empty subtree
                left.insert(value);
            }
        }
        else { // value > data
            if(right == null) {
                // Insert at empty subtree
                right = new BinaryTreeHackerRank<T>(value);
            }
            else {
                // Continue searching for empty subtree
                right.insert(value);
            }
        }
    }

    /** Determines if the tree contains a specific value.
     @param value The value to search the tree for.
     @return True if tree contains value; otherwise, false.
     **/
    public boolean contains(T value) {
        if(value.compareTo(data) == 0) {
            // Value found
            return true;
        }
        else if(value.compareTo(data) < 0) {
            return (left == null)
                    ? false // Not found; there are no more BinaryTreeHackerRanks in left subtree to check
                    : left.contains(value); // Continue searching left subtree
        }
        else { // data.compareTo(value) > 0
            return (right == null)
                    ? false // Not found; there are no more BinaryTreeHackerRanks in right subrtree to check
                    : right.contains(value); // Continue searching right subtree
        }
    }



    /** Print InOrder traversal of tree **/
    public void printInOrder() {
        if(left != null) {
            left.printInOrder();
        }

        System.out.print(data + " ");

        if(right != null) {
            right.printInOrder();
        }
    }

    public static void main(String[] args) {
        validTestCaseExample1();
    }

    public static void testGetDataFromCLI() {
        Scanner scanner = new Scanner(System.in);

        BinaryTreeHackerRank<Integer> root = new BinaryTreeHackerRank<Integer>(scanner.nextInt());
        while(scanner.hasNextInt()) {
            int value = scanner.nextInt();
            root.insert(value);
        }
        scanner.close();

        root.printInOrder();

    }

    static void validTestCaseExample1() {
        int[] nodes = { 4, 2, 3, 1, 7, 6, 5 };
        int n1 = 1;
        int n2 = 7;

        BinaryTreeHackerRank<Integer> root = new BinaryTreeHackerRank<>(nodes[0]);
        for( int i = 1; i < nodes.length; i++ ) {
            root.insert(nodes[i]);
        }

        root.printInOrder();
    }
}