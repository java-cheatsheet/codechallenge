package hackerrank.DataStructure;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
 *
 */
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    SinglyLinkedListNode(int data){ this.data = data; }
}


public class InsertNodeInLinkedList {

    public static void main(String args[]) {

        int[] nodes = { 4, 2, 3, 1, 7, 6 };
        int n1 = 1;
        int n2 = 7;

        SinglyLinkedListNode root = new SinglyLinkedListNode(1);
        //root.data = 1;

        SinglyLinkedListNode root2 = new SinglyLinkedListNode(3);
        //root2.data = 3;
        root.next = root2;

        SinglyLinkedListNode pCurrOld = root;
        while(true)  {
            System.out.println(pCurrOld.data);
            pCurrOld =  pCurrOld.next;

            if ( pCurrOld.next == null ){
                System.out.println(pCurrOld.data);
                break;
            }
        }

        int count = 0;
        int position = 1;
        int newVal = 2;

        SinglyLinkedListNode curr = root;
        while( true ) {
            if( count == position - 1 ) {
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(newVal);
                SinglyLinkedListNode oldNext = curr.next;
                curr.next = newNode;
                newNode.next = oldNext;

            } else
                curr = curr.next;

            if ( curr.next == null ) break;

            count++;
        }

        SinglyLinkedListNode pCurr = root;
        while(true)  {
            System.out.println(pCurr.data);
            pCurr =  pCurr.next;

            if ( pCurr.next == null ){
                System.out.println(pCurr.data);
                break;
            }
        }

//        int expected = 4;
//        TreeNode result = bst.lca(root, n1, n2);
//        assert (result.data == expected) : "Result:" + result +" | Expected:" + expected;
    }



//    static SinglyLinkedListNode insertNodeAtPosition() {
//        int[] nodes = { 4, 2, 3, 1, 7, 6, 2 };
//        int n1 = 1;
//        int n2 = 7;
//        SinglyLinkedListNode[] SGL;
//        front.data = nodes[0];

//       for ( int i = 0; i < nodes.length ; i++ ) {
//           SGL[i] = SinglyLinkedListNode;
//           SGL[i].data = nodes[i];
//           SGL[i - 1].next = SGL[i];
//       }
//
//       System.out.print(SGL);
//
//       return SGL[0];
//    }

}
