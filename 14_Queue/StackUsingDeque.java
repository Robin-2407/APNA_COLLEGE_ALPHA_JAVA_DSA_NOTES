import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    public static class Stack {
        static Deque<Integer> stack = new LinkedList<>();

        public static boolean isEmpty() {
            return stack.isEmpty();
        }

        public static void push(int data) {
            stack.addLast(data);
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // or throw an exception
            }
            return stack.removeLast();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // or throw an exception
            }
            return stack.getLast();
        }

    }

    public static void main(String[] args) {
        Stack.push(10);
        Stack.push(20);
        Stack.push(30);
        System.out.println("Top element is: " + Stack.peek());
        System.out.println("Popped element is: " + Stack.pop());
        System.out.println("Is stack empty? " + Stack.isEmpty());
    }
}
