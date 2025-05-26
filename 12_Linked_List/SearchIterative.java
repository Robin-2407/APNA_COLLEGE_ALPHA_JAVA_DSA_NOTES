public class SearchIterative {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static int search(int key) {
        Node currNode = head;
        int index = 0;

        while (currNode != null) {
            if (currNode.data == key) {
                return index; // Return the index if the key is found
            }
            currNode = currNode.next;
            index++;
        }
        return -1; // Return -1 if the key is not found
    }

    public static void main(String[] args) {
        SearchIterative ll = new SearchIterative();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.tail = ll.head.next.next.next; // Last node is 4

        ll.size = 4; // Size of the linked list
        int keyToSearch = 3;
        int index = ll.search(keyToSearch);
        if (index != -1) {
            System.out.println("Element " + keyToSearch + " found at index: " + index);
        } else {
            System.out.println("Element " + keyToSearch + " not found in the linked list.");
        }
    }
}
