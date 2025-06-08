import java.util.Scanner;

public class linkedl {
    Node root;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void insertLeft(int data) {
        Node n = new Node(data);
        if (root == null)
            root = n;
        else {
            n.next = root;
            root = n;
        }
    }

    void insertRight(int data) {
        Node n = new Node(data);
        if (root == null)
            root = n;
        else {
            Node t = root;
            while (t.next != null) {
                t = t.next;
            }
            t.next = n;
        }
        System.out.println(data + " inserted");
    }

    void deleteLeft() {
        if (root == null)
            System.out.println("List Empty");
        else {
            Node t = root;
            root = root.next;
            System.out.println(t.data + " deleted");
        }
    }

    void deleteRight() {
        if (root == null)
            System.out.println("List Empty");
        else {
            Node t = root;
            Node t2 = root;

            while (t.next != null) {
                t2 = t;
                t = t.next;
            }

            if (t == root)
                root = null;
            else
                t2.next = null;

            System.out.println(t.data + " deleted");
        }
    }

    void printList() {
        if (root == null)
            System.out.println("List Empty");
        else {
            Node t = root;
            while (t != null) {
                System.out.print("|" + t.data + "| -> ");
                t = t.next;
            }
            System.out.println("NULL");
        }
    }

    boolean searchList(int key) {
        if (root == null) {
            System.out.println("List Empty, cannot search.");
            return false;
        } else {
            Node t = root;
            while (t != null) {
                if (t.data == key) {
                    System.out.println(key + " found in the list.");
                    return true;
                }
                t = t.next;
            }
        }
        System.out.println(key + " not found.");
        return false;
    }

    void deleteElement(int key) {
        if (root == null)
            System.out.println("List Empty, cannot delete.");
        else {
            Node t = root;
            Node t2 = root;
            while (t != null) {
                if (t.data == key)
                    break;
                t2 = t;
                t = t.next;
            }
            if (t == null)
                System.out.println(key + " not found.");
            else {
                if (t == root)
                    root = root.next;
                else if (t.next == null)
                    t2.next = null;
                else
                    t2.next = t.next;
                System.out.println(key + " found and deleted.");
            }
        }
    }

    void insertAfter(int ref, int new_data) {
        if (root == null)
            System.out.println("List Empty cannot search anything");
        else {
            Node t = root;
            while (t != null) {
                if (t.data == ref)
                    break;
                t = t.next;
            }
            if (t == null)
                System.out.println(ref + " not found");
            else {
                Node n = new Node(new_data);
                n.next = t.next;
                t.next = n;
                System.out.println(n.data + " Inserted");
            }
        }
    }

    void sorting() {
        if (root == null)
            System.out.println("List Empty cannot sort");
        else {
            Node i, j;
            int temp;

            for (i = root; i != null; i = i.next) {
                for (j = i.next; j != null; j = j.next) {
                    if (j.data < i.data) {
                        temp = i.data;
                        i.data = j.data;
                        j.data = temp; // FIXED SWAP
                    }
                }
            }
            System.out.println("\nList Sorted");
        }
    }

    public static void main(String[] args) {
        linkedl list = new linkedl();
        Scanner sc = new Scanner(System.in);
        int choice, data, ref;

        while (true) {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Insert at Left");
            System.out.println("2. Insert at Right");
            System.out.println("3. Delete from Left");
            System.out.println("4. Delete from Right");
            System.out.println("5. Print List");
            System.out.println("6. Search in List");
            System.out.println("7. Delete Element by Value");
            System.out.println("8. Insert After Value");
            System.out.println("9. Sort List");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertLeft(data);
                }
                case 2 -> {
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertRight(data);
                }
                case 3 -> list.deleteLeft();
                case 4 -> list.deleteRight();
                case 5 -> list.printList();
                case 6 -> {
                    System.out.print("Enter value to search: ");
                    data = sc.nextInt();
                    list.searchList(data);
                }
                case 7 -> {
                    System.out.print("Enter value to delete: ");
                    data = sc.nextInt();
                    list.deleteElement(data);
                }
                case 8 -> {
                    System.out.print("Enter reference value: ");
                    ref = sc.nextInt();
                    System.out.print("Enter new value to insert: ");
                    data = sc.nextInt();
                    list.insertAfter(ref, data);
                }
                case 9 -> list.sorting(); // FIXED: was previously calling exit
                case 10 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
