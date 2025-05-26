import java.util.Stack;

import javax.print.DocFlavor.INPUT_STREAM;

public class StockSpan {
    public static void stockSpan(int stocks[], int span[]) {
        // create a stack to store indices of stocks
        Stack<Integer> stack = new Stack<>();

        // Add the first stock's index to the stack
        span[0] = 1;
        stack.push(0);

        // iterate through each stock price
        for (int i = 1; i < stocks.length; i++) {
            // Pop elements from the stack while the current stock price is greater than
            // the stock price at the index stored at the top of the stack
            while (!stack.isEmpty() && stocks[i] >= stocks[stack.peek()]) {
                stack.pop();
            }

            // If the stack is empty, it means all previous stocks are less than or equal to
            // the current stock price, so span is i + 1
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Otherwise, span is the difference between current index and index at the top
                // of the stack
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }

            // Push the current index onto the stack
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        System.out.print("Stock Span: ");
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();

    }
}
