import java.util.*;

public class DequeBasics {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println("Deque after additions: " + deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removals: " + deque);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("Deque after more additions: " + deque);
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());
        System.out.println("Size of deque: " + deque.size());
        System.out.println("Is deque empty? " + deque.isEmpty());
        // Iterating through the deque
        System.out.print("Elements in deque: ");
        for (Integer element : deque) {
            System.out.print(element + " ");
        }
    }
}
