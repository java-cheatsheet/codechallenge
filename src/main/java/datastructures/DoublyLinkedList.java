package datastructures;

class DoublyLinkedList {
    //A node class for doubly linked list
    class Node{
        int item;
        Node previous;
        Node next;

        public Node(int item) {
            this.item = item;
        }
    }
    //Initially, heade and tail is set to null
    Node head, tail = null;

    //add a node to the list
    public void addNode(int item) {
        //Create a new node
        Node newNode = new Node(item);

        //if list is empty, head and tail points to newNode
        if(head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        }
        else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
    }

    //print all the nodes of doubly linked list
    public void printNodes() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Print each node and then go to next.
            System.out.print(current.item + " ");
            current = current.next;
        }
    }
}

class CircularDoublyLinkedList {

    // Doubly linked list node definition
    static class Node{
        int data;
        Node next;
        Node prev;
    }

    static Node head=null;

    // Function to insert node in the list
    static void addNode(int value) {
        // List is empty so create a single node furst
        if (head == null) {
            Node new_node = new Node();
            new_node.data = value;
            new_node.next = new_node.prev = new_node;
            head = new_node;
            return;
        }

        // find last node in the list if list is not empty
        Node last = (head).prev;    //previous of head is the last node

        // create a new node
        Node new_node = new Node();
        new_node.data = value;

        // next of new_node will point to head since list is circular
        new_node.next = head;

        // similarly previous of head will be new_node
        (head).prev = new_node;

        // change new_node=>prev to last
        new_node.prev = last;

        // Make new node next of old last
        last.next = new_node;
    }

    static void printNodes()   {
        Node temp = head;
        //traverse in forward direction starting from head to print the list
        while (temp.next != head)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d ", temp.data);

        //traverse in backward direction starting from last node
        System.out.print("\nCircular doubly linked list travesed backward: \n");
        Node last = head.prev;
        temp = last;
        while (temp.prev != last)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.prev;
        }
        System.out.printf("%d ", temp.data);
    }


}

class Main{
    public static void main(String[] args) {
//        dllImpl();
        cdllImpl();
    }

    public static void dllImpl() {
        //create a DoublyLinkedList object
        DoublyLinkedList dl_List = new DoublyLinkedList();
        //Add nodes to the list
        dl_List.addNode(10);
        dl_List.addNode(20);
        dl_List.addNode(30);
        dl_List.addNode(40);
        dl_List.addNode(50);

        //print the nodes of DoublyLinkedList
        dl_List.printNodes();
    }

    public static void cdllImpl()
    {
        CircularDoublyLinkedList cdl_List = new CircularDoublyLinkedList();

        // add nodes to the list
        CircularDoublyLinkedList.addNode(40);
        CircularDoublyLinkedList.addNode(50);
        CircularDoublyLinkedList.addNode(60);
        CircularDoublyLinkedList.addNode(70);
        CircularDoublyLinkedList.addNode(80);

        //print the list
        System.out.print("Circular doubly linked list: ");
        CircularDoublyLinkedList.printNodes();
    }
}
