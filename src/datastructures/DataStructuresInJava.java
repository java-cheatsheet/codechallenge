package datastructures;
import java.util.*;
import java.io.*;

public class DataStructuresInJava {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printNamePh();
    }

    public static void dsTreeSet() {

        // Create the sorted set
        SortedSet set = new TreeSet();

        // Add elements to the set
        set.add("bxz");
        set.add("abt");
        set.add("anit");

        // Iterating over the elements in the set
        Iterator it = set.iterator();

        while (it.hasNext()) {
            // Get element
            Object element = it.next();
            System.out.println(element.toString());
            }

    }

    public static void dsLinkedList() {
        // Creating object of class linked list
        LinkedList<String> object = new LinkedList<String>();

        // Adding elements to the linked list
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add("F");
        object.add("G");
        System.out.println("Linked list initial: " + object);

        // Removing elements from the linked list
        object.remove("B");
        object.remove(3);
        object.removeFirst();
        object.removeLast();
        System.out.println("Linked list after deletion: " + object);

        // Finding elements in the linked list
        boolean status = object.contains("E");

        if(status)
            System.out.println("List contains the element 'E' ");
        else
            System.out.println("List doesn't contain the element 'E'");

        // Number of elements in the linked list
        int size = object.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list
        Object element = object.get(2);
        System.out.println("Element returned by get() : " + element);
        object.set(2, "Y");
        System.out.println("Linked list after change : " + object);
    }

    public static void basicsList(){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            a.add(i);
            b.add(i);
        }

        a.set(5, 0);
        b.remove(5);
        System.out.println(a); // [0, 1, 2, 3, 4, 0, 6, 7, 8, 9]
        System.out.println(b); // [0, 1, 2, 3, 4, 6, 7, 8, 9]
        System.out.println(a.get(1));
    }

    public static void basicStack(){
        Stack<Integer> stacka = new Stack<>();
        stacka.push(1);
        stacka.push(2);
        System.out.println(stacka.pop()); // 2
        stacka.push(3);
        System.out.println(stacka); // [1, 3]
    }

    public static void basicQueue() {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack); // [1, 2, 3]

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        System.out.println(queue);

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        System.out.println(stack); // [3, 2, 1]
    }

    public static void basicsHashMaps() {
        HashSet<String> set = new HashSet<>();
        set.add("dog");
        set.add("cat");
        set.add("fish");
        System.out.println(set.contains("dog")); // true
        System.out.println(set.contains("horse")); // false

        HashMap<String, String> map = new HashMap<>();
        map.put("Jenny", "867-5309");
        System.out.println(map.get("Jenny")); // 867-5309
    }

    public static void readInputCMD() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

//            int res = minimumSwaps(arr);

//            bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    public static void printNamePh(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<String, Integer> contact = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            contact.put(name, phone);
//            contact.put("anit", 1);
//            contact.put("dipta", 2);
//            contact.put("baby", 3);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if (contact.containsKey(s))
                System.out.println(s +"="+ contact.get(s));
            else System.out.println("Not found");
        }
        in.close();
    }
}

