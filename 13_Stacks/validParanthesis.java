import java.util.Stack;

public class validParanthesis {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false; // Stack is empty but found a closing bracket
                }
                if ((s.peek() == '(' && ch == ')') ||
                        (s.peek() == '{' && ch == '}') ||
                        (s.peek() == '[' && ch == ']')) {
                    s.pop(); // Matching pair found, pop from stack
                } else {
                    return false; // Mismatched brackets
                }
            }
        }
        return s.isEmpty(); // If stack is empty, all brackets were matched
    }

    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println("Is the string valid? " + isValid(str));
    }
}
