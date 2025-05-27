import java.util.Stack;

public class QueueUsingTwoStacks {

    // Method 1 using two stacks to implement a queue
    // static class Queue {
    // static Stack<Integer> s1 = new Stack<>();
    // static Stack<Integer> s2 = new Stack<>();

    // public static boolean isEmpty() {
    // return s1.isEmpty() && s2.isEmpty();
    // }

    // public static void add(int data) {
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }
    // s1.push(data);
    // while (!s2.isEmpty()) {
    // s1.push(s2.pop());
    // }
    // }

    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }

    // return s1.pop();
    // }

    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }

    // return s1.peek();
    // }
    // }

    // Method 2 using two stacks to implement a queue
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        public static void add(int data) {
            s1.push(data);
        }

        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            int removedElement = s1.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return removedElement;
        }

        public static void peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            int peekedElement = s1.peek();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            System.out.println("Peek: " + peekedElement);
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue after adding elements: " + queue.s1);
        System.out.println("Removed element: " + queue.remove());

        System.out.println("Queue after removing an element: " + queue.s1);
        queue.peek();

        queue.add(40);
        queue.add(50);
        System.out.println("Queue after adding more elements: " + queue.s1);
    }
}

// method 1
// Tc O(n) for add, O(1) for remove, O(1) for peek

// method 2
// Tc O(1) for add, O(n) for remove, O(n) for peek