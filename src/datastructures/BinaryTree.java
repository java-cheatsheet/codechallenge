package datastructures;

import java.util.*;

class BinaryTreeNode{
    BinaryTreeNode left,right;
    int data;
    BinaryTreeNode(int data){
        this.data=data;
        left=right=null;
    }
}
class BinaryTree{

    public static int getHeight(BinaryTreeNode root){

        if (root==null)
            return -1;

        int l=getHeight(root.left);
        int r=getHeight(root.right);

        return Math.max(l,r)+1;
    }

    public static int findHeightOfBinaryTreeIterative(BinaryTreeNode root) {

        BinaryTreeNode temp;
        int height = 0;
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
        queue.add(root);
        BinaryTreeNode dummy = new BinaryTreeNode(Integer.MIN_VALUE);
        queue.add(dummy);

        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp.data == Integer.MIN_VALUE) {
                height++; // Increment height
                /* Insert special node queue if queue is not empty
                 * since all nodes of that level has been covered*/

                if (!queue.isEmpty())
                    queue.add(dummy);
            }

            BinaryTreeNode lc = temp.left;
            BinaryTreeNode rc = temp.right;

            if (lc != null) {
                queue.add(lc);
            }
            if (rc != null) {
                queue.add(rc);
            }

        }
        return --height;
    }

    public static BinaryTreeNode insert(BinaryTreeNode root,int data){
        if(root==null){
            return new BinaryTreeNode(data);

        } else{
            BinaryTreeNode cur;

            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            } else {
                cur=insert(root.right,data);
                root.right=cur;
            }

            return root;
        }
    }

    public static int min(BinaryTreeNode root) {
        if(null == root) {
            System.out.println("Tree is empty");
            return -1;
        }
        //we found the min value
        if(root.left == null) {
            return root.data;
        }
        return min(root.left);
    }

    public static int max(BinaryTreeNode root) {
        if(null == root) {
            System.out.println("Tree is empty");
            return -1;
        }
        //we found the max value
        if(root.right == null) {
            return root.data;
        }
        return max(root.right);
    }

    public static void main(String args[]){
//        Scanner sc=new Scanner(System.in);
//        int T=sc.nextInt();
        int[] nodes = {3, 5, 2, 1, 4, 6, 7};
        BinaryTreeNode root=null;

        for (int node: nodes) {
            root=insert(root, node);
        }

        System.out.println("Height" + findHeightOfBinaryTreeIterative(root));
        System.out.println("Min " + min(root));
        System.out.println("Max " + max(root));
    }
}
