public class reverseLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void printList(Node node) {
        Node currNode = node;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");

    }

    public static void reverse(Node node) {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to current node
            curr = next; // Move to the next node
        }
        head = prev; // Update head to the new first node
        if (tail != null) {
            tail.next = null; // Ensure the new tail's next is null
        }
    }

    public static void main(String[] args) {
        reverseLinkedList ll = new reverseLinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.tail = ll.head.next.next.next; // Last node is 4

        ll.size = 4; // Size of the linked list
        System.out.println("Original Linked List:");
        printList(head);

        reverse(head);
        System.out.println("Reversed Linked List:");
        printList(head);

        System.out.println("Head: " + head.data);
        System.out.println("Tail: " + tail.data);
    }
}
