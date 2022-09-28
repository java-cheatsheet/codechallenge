package datastructures;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}

class DeleteDuplicateLinkedList
{

    public static Node removeDuplicates(Node head) {
//         Write your code here
//
//         Constraints
//         The data elements of the linked list
//         argument will always be in non-decreasing order.
//
//        Algorithm
//        Traverse.
//        Check if next node is equal


        Node prev = head;

        while (prev.next != null)
        {
            if (prev.data == prev.next.data)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        // Remove node from Linked List


        // Free memory
        System.gc();
        return head;
    }

    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }

    public static void main(String[] args)
    {
//        Scanner sc=new Scanner(System.in);
        Node head=null;
//        int T=sc.nextInt();
//        while(T-->0){
//            int ele=sc.nextInt();
//            head=insert(head,ele);
//        }
        int[] nodes = new int[]{1, 2, 2, 3};
//        int[] nodes = new int[]{2, 2};
        for ( int i = 0; i < nodes.length; i++ ) {
            head = insert(head, nodes[i]);
        }

        head=removeDuplicates(head);

        display(head);

    }
}