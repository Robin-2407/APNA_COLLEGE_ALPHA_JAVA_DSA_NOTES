import java.util.Stack;

public class ReverseAString {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        // Push each character of the string onto the stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        // Pop each character from the stack and append to the StringBuilder
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversed = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
    }
}

// Tc O(n) - where n is the length of the string
// Sc O(n) - where n is the length of the string (due to stack usage)