import java.util.Stack;

public class nextGreater {
    public static int[] bruteForce(int arr[]) {
        int n = arr.length;
        int nextGreater[] = new int[n];
        for (int i = 0; i < n; i++) {
            int next = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    next = arr[j];
                    nextGreater[i] = next; // Store the next greater element
                    break; // Found the next greater element, exit the inner loop
                } else {
                    nextGreater[i] = -1; // If no greater element found, set to -1
                }
            }
        }
        return nextGreater;
    }

    public static int[] optimized(int arr[]) {
        int n = arr.length;
        int nextGreater[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // While stack is not empty and the top element is less than or equal to arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop(); // Pop elements that are not greater
            }
            // If stack is empty, no greater element found
            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()]; // The top element is the next greater element
            }
            stack.push(i); // Push the current element's index onto the stack
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        System.out.println("Brute Force Approach:");
        int[] result = bruteForce(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        System.out.println("Optimized Approach:");
        int[] optimizedResult = optimized(arr);
        for (int i = 0; i < optimizedResult.length; i++) {
            System.out.print(optimizedResult[i] + " ");
        }
    }
}

// Brute Force Approach
// Tc : O(n^2) for brute force, O(n) for optimized
// Sc : O(1) for brute force, O(n) for optimized (due to stack usage)

// Optimized Approach
// The optimized approach uses a stack to keep track of the indices of the
// elements
// in the array. It iterates through the array from right to left, ensuring that
// for each element, it finds the next greater element efficiently by popping
// elements
// Tc : O(n)
// Sc : O(n) (due to stack usage)