import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    // public static class Stack {
    // static Queue<Integer> q1 = new LinkedList<>();
    // static Queue<Integer> q2 = new LinkedList<>();

    // public static boolean isEmpty() {
    // return q1.isEmpty() && q2.isEmpty();
    // }

    // public static void push(int data) {
    // if (!q1.isEmpty()) {
    // q1.add(data);
    // } else {
    // q2.add(data);
    // }
    // }

    // public static int pop() {
    // if (isEmpty()) {
    // System.out.println("Stack is Empty");
    // return -1;
    // }
    // if (!q1.isEmpty()) {
    // while (q1.size() > 1) {
    // q2.add(q1.remove());
    // }
    // return q1.remove();
    // } else {
    // while (q2.size() > 1) {
    // q1.add(q2.remove());
    // }
    // return q2.remove();
    // }
    // }

    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("Stack is Empty");
    // return -1;
    // }
    // if (!q1.isEmpty()) {
    // while (q1.size() > 1) {
    // q2.add(q1.remove());
    // }
    // int top = q1.peek();
    // q2.add(q1.remove());
    // return top;
    // } else {
    // while (q2.size() > 1) {
    // q1.add(q2.remove());
    // }
    // int top = q2.peek();
    // q1.add(q2.remove());
    // return top;
    // }
    // }
    // }

    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            // push in O(n)
            // pop o(1)
            // peek o(1)
            q1.add(data);

        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        System.out.println(stack.peek()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // Stack is Empty
    }
}
