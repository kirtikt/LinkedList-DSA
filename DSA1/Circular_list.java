import java.util.Scanner;

public class Circular_list {

    Node root, last;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Enqueue - insert at rear
    void enqueue(int data) {
        Node n = new Node(data);
        if (root == null) {
            root = last = n;
            last.next = root;
        } else {
            last.next = n;
            last = n;
            last.next = root;
        }
        System.out.println(data + " enqueued");
    }

    // Dequeue - delete from front
    Integer dequeue() {
        if (root == null) {
            return null;
        } else if (root == last) { // only one node
            int val = root.data;
            root = last = null;
            return val;
        } else {
            int val = root.data;
            root = root.next;
            last.next = root;
            return val;
        }
    }

    void printQueue() {
        if (root == null) {
            System.out.println("Queue is empty");
        } else {
            Node t = root;
            System.out.print("Queue: ");
            do {
                System.out.print(t.data + " ");
                t = t.next;
            } while (t != root);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Circular_list queue = new Circular_list(); // Corrected class name
        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\n--- Queue Operations (Using Circular Linked List) ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Print Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter data to enqueue: ");
                    data = sc.nextInt();
                    queue.enqueue(data);
                }
                case 2 -> {
                    Integer dequeued = queue.dequeue();
                    if (dequeued == null) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        System.out.println("Dequeued: " + dequeued);
                    }
                }
                case 3 -> queue.printQueue();
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
