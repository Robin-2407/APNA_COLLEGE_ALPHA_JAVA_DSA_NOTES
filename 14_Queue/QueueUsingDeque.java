import java.util.LinkedList;
import java.util.Deque;

public class QueueUsingDeque {
    public static class Queue {
        static Deque<Integer> queue = new LinkedList<>();

        public static boolean isEmpty() {
            return queue.isEmpty();
        }

        public static void add(int data) {
            queue.addLast(data);
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // or throw an exception
            }
            return queue.removeFirst();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // or throw an exception
            }
            return queue.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue.add(10);
        Queue.add(20);
        Queue.add(30);
        System.out.println("Front element is: " + Queue.peek());
        System.out.println("Removed element is: " + Queue.remove());
        System.out.println("Is queue empty? " + Queue.isEmpty());
    }
}
