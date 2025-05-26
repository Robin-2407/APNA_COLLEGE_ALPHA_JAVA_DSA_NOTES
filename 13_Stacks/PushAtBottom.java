import java.util.Stack;

public class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop(); // Pop the top element
        pushAtBottom(stack, data); // Recursively call to push at bottom
        stack.push(top); // Push the popped element back
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack before pushing at bottom: " + stack);
        pushAtBottom(stack, 4);
        System.out.println("Stack after pushing at bottom: " + stack);
    }
}
