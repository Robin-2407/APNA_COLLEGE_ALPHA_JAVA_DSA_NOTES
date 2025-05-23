import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SwapTwoNumbers {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        if (idx1 < 0 || idx2 < 0 || idx1 >= list.size() || idx2 >= list.size()) {
            System.out.println("Invalid indices");
            return;
        }
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(1);

        int idx1 = 2;
        int idx2 = 4;
        System.out.println("Before swapping: " + list);
        swap(list, idx1, idx2);
        System.out.println("After swapping: " + list);
    }
}

// Tc O(1) and Sc O(1)