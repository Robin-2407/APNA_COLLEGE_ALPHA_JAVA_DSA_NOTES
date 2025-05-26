import java.util.ArrayList;

public class StackUsingArrayList {
    public static class Stack {
        static ArrayList<Integer> stack = new ArrayList<>();

        public static boolean isEmpty() {
            return stack.size() == 0;
        }

        public static void push(int data) {
            stack.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // or throw an exception
            }
            int top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // or throw an exception
            }
            return stack.get(stack.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
