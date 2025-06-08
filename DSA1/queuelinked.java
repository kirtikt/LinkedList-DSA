import java.util.Scanner;

public class queuelinked {
    Node rear, front;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void enqueue(int e) {
        Node n = new Node(e);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }

    Integer dequeue() {
        if (front == null) {
            return null;
        }
        int temp = front.data;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    void printQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
        } else {
            Node t = front;
            System.out.print("FRONT -> ");
            while (t != null) {
                System.out.print("|" + t.data + "| -> ");
                t = t.next;
            }
            System.out.println("REAR");
        }
    }

    public static void main(String[] args) {
        queuelinked queue = new queuelinked(); // using your own class
        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\n--- Queue Operations (Using Linked List) ---");
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



