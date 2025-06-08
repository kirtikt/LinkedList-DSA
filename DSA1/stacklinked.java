import java.util.Scanner;

public class stacklinked {
    Node tos;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int push(int e) {
        Node n = new Node(e);
        n.next = tos;
        tos = n;
        return e;
    }

    int pop() {
        if (tos == null) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            int tosData = tos.data;
            tos = tos.next;
            return tosData;
        }
    }

    int peek() {
        if (tos == null) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return tos.data;
        }
    }

    void printStack() {
        if (tos == null) {
            System.out.println("Stack is empty.");
        } else {
            Node t = tos;
            while (t != null) {
                System.out.print("|" + t.data + "| -> ");
                t = t.next;
            }
            System.out.println("NULL");
        }
    }
    

    public static void main(String[] args) {
        stacklinked stack = new stacklinked();
        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\n--- Stack Operations (Using Linked List) ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter data to push: ");
                    data = sc.nextInt();
                    stack.push(data);
                }
                case 2 -> {
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped: " + popped);
                    }
                }
                case 3 -> {
                    int top = stack.peek();
                    if (top != -1) {
                        System.out.println("Top of Stack: " + top);
                    }
                }
                case 4 -> stack.printStack();
                case 5 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
