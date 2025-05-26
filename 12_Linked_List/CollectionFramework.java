import java.util.LinkedList;

public class CollectionFramework {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addLast(5);
        list.addFirst(0);
        System.out.println("Linked List: " + list);
    }
}
