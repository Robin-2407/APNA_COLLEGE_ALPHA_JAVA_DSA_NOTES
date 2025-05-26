public class MergeSort {

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

    public static void printList(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.data).append(" -> ");
            node = node.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: if the list is empty or has one node
        }

        // Split the list into two halves
        Node mid = getMiddle(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null; // Split the list

        // Recursively sort both halves
        Node newLeft = mergeSort(left);
        Node newRight = mergeSort(right);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }

    public static Node getMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
        }

        // If odd length, return slow as middle
        // If even length, return prev as middle
        return slow;
    }

    public static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        Node mergedHead;
        if (left.data <= right.data) {
            mergedHead = left;
            left = left.next;
        } else {
            mergedHead = right;
            right = right.next;
        }

        Node current = mergedHead;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return mergedHead;
    }

    public static void main(String[] args) {
        head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        tail = head.next.next.next.next;

        System.out.println("Original List: ");
        printList(head);
        Node sortedList = mergeSort(head);
        System.out.println("Sorted List: ");
        printList(sortedList);
    }
}