import java.util.Stack;

public class MaxAreaHistogram {
    public static void maxArea(int[] heights) {
        int maxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = n; // No smaller element to the right
            } else {
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear(); // Clear the stack for the next pass

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = -1; // No smaller element to the left
            } else {
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1; // Calculate width
            int area = heights[i] * width; // Calculate area
            maxArea = Math.max(maxArea, area); // Update max area
        }
        System.out.println("Maximum Area in Histogram: " + maxArea);
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Calculating Maximum Area in Histogram:");
        maxArea(heights);
    }
}

// Tc : O(n)
// Sc : O(n) for storing next smaller elements
