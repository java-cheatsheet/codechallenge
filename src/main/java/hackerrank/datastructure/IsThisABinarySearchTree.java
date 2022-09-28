package hackerrank.datastructure;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 *
 * For the purposes of this challenge,
 * we define a binary search tree to
 * be a binary tree with the following
 * properties:
 *
 * The data value of every node in a
 * node's left subtree is less than the
 * data value of that node.
 *
 * The data value of every node in a
 * node's right subtree is greater
 * than the data value of that node.
 *
 * The data value of every node is distinct.
 *
 * Solution:
 * The main problem was to write an
 * algorithm to check whether the
 * given tree is a binary tree or not
 * but there was another hidden
 * problem. The validation checked
 * if there was a class named
 * Solution exists in the provided
 * solution or not.
 *
 * When the function was run it
 * error out class Solution was not found.
 * So after analysing the issue running
 * multiple checks, that an internal
 * class implementation was required for
 * that.
 *
 * The solution sometimes passes and
 * sometimes does not. I believe there
 * is a problem with this provided
 * main caller code implementation of
 * the problem.
 */

public class IsThisABinarySearchTree {

    public static Node insert( Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 4, 2, 3, 1, 7, 6, 2};
        int n1 = 1;
        int n2 = 7;
        Node root = null;
        for( int node: nodes ) {
            root = insert(root, node);
        }
        boolean expected = false;
        IsThisABinarySearchTree objBTS = new IsThisABinarySearchTree();

        boolean result = objBTS.checkBST(root);

        assert ( result == expected );
    }

    boolean checkBST(Node root) {
        Solution s = new Solution();
        return s.checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

/**
 * Hidden stub code will pass a root argument to the function below.
 * Complete the function to solve the challenge. Hint: you may want
 * to write one or more helper functions.
 * The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
 */


    class Solution {
        boolean checkBST(Node node, int min, int max) {
            return (node == null) ||
                    (min < node.data && node.data < max &&
                            checkBST(node.left, min, node.data) &&
                            checkBST(node.right, node.data, max));
        }
    }


}
