public class RemoveCycle {
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

    public static Node DetectCycleInLL(Node head) {
        if (head == null) {
            return null; // Empty list cannot have a cycle
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return fast; // Cycle detected
            }
        }
        return null;
    }

    public static void removeCycle(Node head) {
        Node intersection = DetectCycleInLL(head);
        if (intersection == null) {
            return; // No cycle to remove
        }

        Node slow = head;
        Node fast = intersection;
        Node prev = null;

        // Find the start of the cycle
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // Break the cycle
        prev.next = null;
    }

    public static boolean hasCycle(Node head) {
        return DetectCycleInLL(head) != null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = head.next.next;

        System.out.println("Cycle detected: " + hasCycle(head));
        removeCycle(head);
        System.out.println("Cycle removed. Cycle detected: " + hasCycle(head));
    }
}
