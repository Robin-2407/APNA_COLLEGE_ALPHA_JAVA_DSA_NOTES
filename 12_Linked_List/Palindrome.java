public class Palindrome {
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

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // Empty list or single element is a palindrome
        }

        Node mid = findMid(head);
        Node prev = null;
        Node curr = mid;
        Node next;

        // Reverse the second half of the list
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node firstHalf = head;
        Node secondHalf = prev; // This is the reversed second half

        // Compare the two halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false; // Not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true; // Is a palindrome
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        tail = head.next.next.next.next;
        size = 5;
        System.out.println("Is palindrome: " + isPalindrome(head));
    }

}

// Tc O(n)
// Sc O(1) - no extra space used for the palindrome check
// This code checks if a linked list is a palindrome by reversing the second
// half of the list and comparing it with the first half.
// It uses a two-pointer technique to find the middle of the list, reverses the
// second half, and then compares the two halves.
// slow and fast pointers are used to find the middle of the list.
