import java.util.Stack;

public class ReverseAStack {
    public static void printStack(Stack<Integer> stack) {
        for (Integer item : stack) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item); // If the stack is empty, push the item
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively call to insert the item at the bottom
        insertAtBottom(stack, item);

        // Push the popped element back onto the stack
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // Base case: if the stack is empty, do nothing
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively reverse the remaining stack
        reverseStack(stack);

        // Insert the popped element at the bottom of the reversed stack
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: ");
        printStack(stack);

        // Reverse the stack

        System.out.println("Reversed Stack: ");
        reverseStack(stack);
        printStack(stack);

    }
}
