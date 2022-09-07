package hackerrank.DataStructure.Tree;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * Java Program to implement a binary search tree. A binary search tree is a
 * sorted binary tree, where value of a node is greater than or equal to its
 * left the child and less than or equal to its right child.
 *
 * @author WINDOWS 8
 *
 */
public class BinarySearchTree {

 private static class Node {
  private int data;
  private Node left, right;

  public Node(int value) {
   data = value;
   left = right = null;
  }
 }

 private static Node root;

 public BinarySearchTree() {
  root = null;
 }

 public static Node getRoot() {
  return root;
 }

 /**
  * Java function to check if binary tree is empty or not
  * Time Complexity of this solution is constant O(1) for
  * best, average and worst case.
  *
  * @return true if binary search tree is empty
  */
 public static boolean isEmpty() {
  return null == root;
 }


 /**
  * Java function to return number of nodes in this binary search tree.
  * Time complexity of this method is O(n)
  * @return size of this binary search tree
  */
 public static int size(Node root) {
  Node current = root;
  int size = 0;
  Stack<Node> stack = new Stack<Node>();
  while (!stack.isEmpty() || current != null) {
   if (current != null) {
    stack.push(current);
    current = current.left;
   } else {
    size++;
    current = stack.pop();
    current = current.right;
   }
  }
  return size;
 }


 /**
  * Java function to clear the binary search tree.
  * Time complexity of this method is O(1)
  */
 public void clear() {
  root = null;
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

// public static int height(Node root) {
//  if (root == null) return -1;
//  return 1 + Math.max(height(root.left), height(root.right));
// }

 public static void main(String[] args) {
//  Scanner scan = new Scanner(System.in);
//  int t = scan.nextInt();
  Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
  Random rd = new Random();
  for (int i = 0; i < 6; i ++){
//   int data = scan.nextInt();
    // creating Random object
    root = insert(root, rd.nextInt(20));
  }

//  scan.close();
//  int height = height(root);
  System.out.println(size(root));
 }

}