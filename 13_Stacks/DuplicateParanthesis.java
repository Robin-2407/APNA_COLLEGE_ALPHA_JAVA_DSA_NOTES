import java.util.Stack;

public class DuplicateParanthesis {
    public static boolean hasDuplicateParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop(); // Pop elements until we find the matching '('
                    count++; // Count the number of elements inside the parentheses
                }
                if (count < 1) {
                    return true; // If no elements were found, it's a duplicate parentheses
                } else {
                    stack.pop(); // Pop the matching '('
                }
            } else {
                stack.push(ch); // Push other characters onto the stack
            }
        }
        return false; // If we finish processing the string without finding duplicates
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        String str1 = "((a+b)+(c+d))";
        System.out.println("Does the string have duplicate parentheses? " + hasDuplicateParentheses(str));
        System.out.println("Does the string have duplicate parentheses? " + hasDuplicateParentheses(str1));
    }
}
