public class CircularQueueUsingArray {
    public static class CircularQueue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int removedElement = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1; // Queue is now empty
            } else {
                front = (front + 1) % size; // Move front to the next position
            }
            return removedElement;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public static void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear)
                    break;
                i = (i + 1) % size; // Circular increment
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(6);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60); // This should print "Queue is full"

        queue.display(); // Should display: 10 20 30 40 50

        System.out.println("Removed: " + queue.remove()); // Should remove 10
        queue.display(); // Should display: 20 30 40 50

        System.out.println("Peek: " + queue.peek()); // Should display: 20
        queue.add(70); // Should add 70
        queue.display(); // Should display: 20 30 40 50 70
    }
}

// Tc and Sc:
// Time Complexity: O(1) for add, remove, peek operations
// Space Complexity: O(n) for storing the elements in the array
// Note: The display method runs in O(n) time to print all elements
// This implementation uses a circular array to efficiently manage the queue
// operations.
// The circular nature allows the queue to wrap around, making better use of the
// array space.