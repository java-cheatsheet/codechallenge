package hackerrank.datastructure;


class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode(int x) {
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}


public class DoublyLinkedList {

    public static void main(String[] args) {

        int[] nodes = { 4, 2, 3, 1, 7, 6 };
        int n1 = 1;
        int n2 = 7;

        DoublyLinkedListNode head = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(5);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(8);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(11);
        head.next = node1;
        node1.prev = head;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        DoublyLinkedListNode pCurrOld = head;
        while( true)  {
            System.out.println(pCurrOld.data);
            pCurrOld =  pCurrOld.next;

            if ( pCurrOld.next == null ){
                System.out.println(pCurrOld.data);
                break;
            }
        }

        int data = 1;// is fine;
        head = sortedInsertRecurrsive(head, data);

        System.out.println("\n");
        DoublyLinkedListNode pCurr = head;
        while(true)  {
            System.out.println(pCurr.data);
            pCurr =  pCurr.next;

            if ( pCurr.next == null ){
                System.out.println(pCurr.data);
                break;
            }
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode curr = head;

        if ( curr.prev == null && curr.data > data ) {
            DoublyLinkedListNode newFrontNode = new DoublyLinkedListNode(data);
            curr.prev = newFrontNode;
            newFrontNode.next = curr;
        } else {

            while (true) {
                if (data < curr.data) {

                    // if the last node is not null then we need to add the
                    // new node after the current node, i.e. the next node of
                    // current node will be the new node, the prev of the new
                    // node will be the current node, the next node of the new
                    // node will be the next node of the current node and finally
                    // the prev of the next node will be the new node.
                    DoublyLinkedListNode newFrontNode = new DoublyLinkedListNode(data);
                    newFrontNode.prev = curr.prev;
                    newFrontNode.next = curr;
                    curr.prev.next = newFrontNode;
                    curr.prev = newFrontNode;
                    break;
                }

                curr = curr.next;

                // If the inserted value is larger than the last one
                if (curr.next == null && data > curr.data) {
                    DoublyLinkedListNode newLastNode = new DoublyLinkedListNode(data);
                    newLastNode.prev = curr;
                    curr.next = newLastNode;
                    break;
                }

            } //while( curr.next != null );
        }

        while ( curr.prev != null ){
            curr = curr.prev;
        }

        return curr;
    }

    /**
     * Thirdparty solution that passed all the test cases.
     *
     * @param head
     * @param data
     * @return
     */
    static DoublyLinkedListNode sortedInsertRecurrsive(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode n = new DoublyLinkedListNode(data);
        if (head == null) {
            return n;
        }
        else if ( data < head.data) {
            n.next = head;
            head.prev = n;
            return n;
        }
        else {
            DoublyLinkedListNode rest = sortedInsertRecurrsive(head.next, data);
            head.next = rest;
            rest.prev = head;
            return head;
        }

    }

}
