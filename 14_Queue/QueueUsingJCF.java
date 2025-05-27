import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingJCF {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue after adding elements: " + queue);
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after removing an element: " + queue);

        Queue<Integer> anotherQueue = new ArrayDeque<>();
        anotherQueue.add(40);
        anotherQueue.add(50);
        anotherQueue.add(60);

        System.out.println("Another queue after adding elements: " + anotherQueue);
        System.out.println("Removed element from another queue: " + anotherQueue.remove());
        System.out.println("Another queue after removing an element: " + anotherQueue);
    }
}

// Queue is Interface in Java Collections Framework (JCF)
// That is why we cannot create an object of Queue directly
// we can use LinkedList or ArrayDeque to implement Queue
// The difference between LinkedList and ArrayDeque is that
// LinkedList is a doubly linked list implementation, while ArrayDeque is a
// resizable array implementation.
// Both can be used to implement a queue, but they have different performance
// characteristics.