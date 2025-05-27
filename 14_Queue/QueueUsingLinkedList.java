public class QueueUsingLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static class Queue {
        static Node head = null;
        static Node tail = null;
        static int size = 0;

        public static boolean isEmpty() {
            return size == 0;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            Node removedNode = head;
            head = head.next;
            removedNode.next = null; // Clear the next reference
            size--;
            if (head == null) {
                tail = null; // If the queue is now empty, reset tail
            }
            return removedNode.data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Removed: " + queue.remove());

    }
}
