package hackerrank.datastructure;

import java.util.*;


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


/**
 * Problem:
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/
 *
 * Find the height of the binary tree.
 *
 */
class HeightOfABinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }

        for (int i = 0; i < 5; i ++){
            int data = scan.nextInt();
            root = insert(root, data);
        }

        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}