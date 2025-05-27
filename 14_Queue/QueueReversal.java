import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty() || q.size() == 1) {
            return; // Base case: if the queue is empty, do nothing
        }
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Original Queue: " + q);
        reverseQueue(q);
        System.out.println("Reversed Queue: " + q);
    }
}
