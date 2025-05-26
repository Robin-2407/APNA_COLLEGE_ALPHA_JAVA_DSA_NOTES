public class Basics {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addMiddle(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index >= size) {
            addLast(data);
            return;
        }
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        Node currNode = head;
        int i = 0;
        while (i < index - 1) {
            currNode = currNode.next;
            i++;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null; // If the list becomes empty, update tail
        }

    }

    public void removeLast() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head == tail) {
            head = tail = null; // If there's only one element
            size--;
            return;
        }
        Node currNode = head;
        while (currNode.next != tail) {
            currNode = currNode.next;
        }
        currNode.next = null;
        tail = currNode;
        size--;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("Size of LinkedList: " + size);
    }

    public static void main(String[] args) {
        Basics ll = new Basics();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);

        ll.printList(head);
        ll.addMiddle(1, 4);
        ll.printList(head);
        ll.addMiddle(0, 5);
        ll.printList(head);
        ll.addMiddle(5, 6);

        ll.printList(head);
        ll.removeFirst();
        ll.printList(head);
        ll.removeLast();
        ll.printList(head);
    }

}
