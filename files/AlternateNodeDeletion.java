package dsa;

import java.util.*;

public class AlternateNodeDeletion {

    // Node class for singly linked list
    static class Node {
        int data;  // value of the node
        Node next; // reference to the next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Function to delete alternate nodes starting from the second node
     * Example: For 1 -> 2 -> 3 -> 4 -> 5, it will become 1 -> 3 -> 5
     */
    public static Node deleteAlternateNodes(Node head) {
        if (head == null) return null;

        Node current = head;
        // Traverse list and skip every alternate node
        while (current != null && current.next != null) {
            current.next = current.next.next; // unlink the next node
            current = current.next; // move to next available node
        }
        return head;
    }

    /**
     * Function to print the linked list in reverse order
     * This uses a Stack to reverse the order of printing
     */
    public static void printReverse(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node current = head;
        // Push all elements into stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        // Pop elements to print in reverse
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Asking for number of nodes
        System.out.print("Enter the number of nodes in the linked list: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("List is empty.");
            sc.close();
            return;
        }

        // Asking for first node value
        System.out.print("Enter value for node 1: ");
        Node head = new Node(sc.nextInt());
        Node tail = head;

        // Asking for remaining node values
        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value for node " + i + ": ");
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        // Delete alternate nodes starting from the second
        head = deleteAlternateNodes(head);

        // Output result in reverse order
        System.out.print("Linked list after deleting alternate nodes (in reverse order): ");
        printReverse(head);

        sc.close();
    }
}

/*
-------------------------
Example Input and Output:
-------------------------

Enter the number of nodes in the linked list: 5
Enter value for node 1: 1
Enter value for node 2: 2
Enter value for node 3: 3
Enter value for node 4: 4
Enter value for node 5: 5
Linked list after deleting alternate nodes (in reverse order): 5 3 1

Explanation:
Original List: 1 -> 2 -> 3 -> 4 -> 5
After deleting alternate nodes: 1 -> 3 -> 5
Reverse order printing: 5 3 1
*/
