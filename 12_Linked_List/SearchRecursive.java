public class SearchRecursive {
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

    public int search(Node node, int key, int index) {
        if (node == null) {
            return -1; // If the list is empty, return -1
        }
        if (node.data == key) {
            return index; // If the current node's data matches the key, return the index
        }
        return search(node.next, key, index + 1); // Recur for the next node
    }

    public static void main(String[] args) {
        SearchRecursive ll = new SearchRecursive();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.tail = ll.head.next.next.next; // Last node is 4

        ll.size = 4; // Size of the linked list
        int keyToSearch = 13;
        int index = ll.search(head, keyToSearch, 0);
        if (index != -1) {
            System.out.println("Element " + keyToSearch + " found at index: " + index);
        } else {
            System.out.println("Element " + keyToSearch + " not found in the linked list.");
        }
    }
}

// Tc O(n) - where n is the number of nodes in the linked list.
// Sc O(n) - due to recursion stack space.