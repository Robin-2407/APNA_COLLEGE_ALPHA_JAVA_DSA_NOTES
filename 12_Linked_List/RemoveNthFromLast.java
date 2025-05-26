public class RemoveNthFromLast {
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

    public static void removeNode(int n) {

        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }

        if (n <= 0 || n > size) {
            System.out.println("Invalid value of n");
            return;
        }
        if (n == size) {
            head = head.next; // Remove the first node
            return;
        }

        int targetIndex = size - n;
        Node prevNode = head;
        currNode = head;
        for (int i = 0; i < targetIndex - 1; i++) {
            currNode = currNode.next;
        }
        if (currNode.next == null) {
            System.out.println("No node to remove at the specified position.");
            return;
        }
        prevNode = currNode;
        currNode = currNode.next;
        currNode.next = currNode.next.next; // Remove the nth node from the end

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2; // Remove the 2nd node from the end
        removeNode(n);
        printList(head);
    }
}

// Tc O(n)
// Sc O(1)
// Wrong code, need to fix the logic for removing the nth node from the end
// The logic for removing the nth node from the end is incorrect.