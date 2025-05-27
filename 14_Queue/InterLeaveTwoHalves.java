import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveTwoHalves {
    public static void interLeave(Queue<Integer> queue) {
        if (queue.isEmpty() || queue.size() == 1) {
            return; // No interleaving needed for empty or single element queue
        }
        if (queue.size() % 2 != 0) {
            System.out.println("Queue size is odd, interleaving not possible.");
            return; // Interleaving not possible for odd-sized queue
        }

        int size = queue.size();

        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(queue.remove()); // Remove first half elements
        }

        // Interleave the two halves
        while (!firstHalf.isEmpty()) {
            queue.add(firstHalf.remove());
            queue.add(queue.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        System.out.println("Original Queue: " + queue);
        interLeave(queue);
        System.out.println("Interleaved Queue: " + queue);
    }
}

// Tc : O(n)
// Sc : O(n) for the first half queue