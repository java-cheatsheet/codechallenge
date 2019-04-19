package hackerrank.DataStructure;

import java.util.Stack;

class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { data = x; }
 }

public class LowestCommonAncestor {

    TreeNode root;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node.
        int parentVal = root.data;

        // Value of p
        int pVal = p.data;

        // Value of q;
        int qVal = q.data;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    /* Function to find LCA of n1 and n2. The function assumes that both
       n1 and n2 are present in BST */
    TreeNode lca(TreeNode root, int v1, int v2) {
        if (root == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > v1 && root.data > v2)
            return lca(root.left, v1, v2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.data < v1 && root.data < v2)
            return lca(root.right, v1, v2);

        return root;
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
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

    public static void printInOrder(TreeNode node) {
        if ( node != null ) {
            printInOrder(node.left);
            System.out.print(node.data);
            printInOrder(node.right);
        }
    }

    // Iterative function to perform in-order traversal of the tree
    public static void printInorderIterative(TreeNode root) {
        // create an empty stack
        Stack<TreeNode> stack = new Stack();

        // start from root node (set current node to root node)
        TreeNode curr = root;

        // if current node is null and stack is also empty, we're done
        while (!stack.empty() || curr != null) {
            // if current node is not null, push it to the stack (defer it)
            // and move to its left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // else if current node is null, we pop an element from stack,
                // print it and finally set current node to its right child
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
    }

    static boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBST(TreeNode node, int min, int max) {

        if (node == null ) return true;

        return  min < node.data && node.data < max &&
                checkBST(node.left, min, node.data) &&
                checkBST(node.right, node.data, max);
    }

    /* Driver program to test lca() */
    public static void main(String args[]) {
        validTestCheckBST();
        invalidTestCheckBST();
    }

    static void invalidTestCheckBST() {
        int[] nodes = { 4, 2, 3, 1, 7, 6, 2};
        int n1 = 1;
        int n2 = 7;
        TreeNode root = null;
        for( int node: nodes ) {
            root = insert(root, node);
        }
        boolean expected = false;
        boolean result = checkBST(root);

        assert ( result == expected );
    }

    static void validTestCheckBST() {
        int[] nodes = { 4, 2, 3, 1, 7, 6 };
        int n1 = 1;
        int n2 = 7;
        TreeNode root = null;
        for( int node: nodes ) {
            root = insert(root, node);
        }
        boolean expected = true;
        boolean result = checkBST(root);

        assert ( result == expected );
    }

    static void validTestPrintInOrder() {
        int[] nodes = { 4, 2, 3, 1, 7, 6 };
        int n1 = 1;
        int n2 = 7;

        TreeNode root = null;
        for( int node: nodes ) {
            root = insert(root, node);
        }

        printInOrder(root);
    }

    static void validTestCaseExample1() {
        int[] nodes = { 4, 2, 3, 1, 7, 6 };
        int n1 = 1;
        int n2 = 7;

        TreeNode root = null;
        for( int node: nodes ) {
            root = insert(root, node);
        }

        LowestCommonAncestor bst = new LowestCommonAncestor();
        int expected = 4;
        TreeNode result = bst.lca(root, n1, n2);
        assert (result.data == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static  void testWithTreeCreatedManaually() {
        // Let us construct the BST shown in the above figure
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        int n1 = 10, n2 = 14;
        TreeNode t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }
}