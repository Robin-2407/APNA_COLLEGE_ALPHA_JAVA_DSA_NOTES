import java.util.ArrayList;

public class SwapNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);

        int index1 = 1;
        int index2 = 3;

        System.out.println("Before swapping: " + List);

        int temp = List.get(index1);
        List.set(index1, List.get(index2));
        List.set(index2, temp);

        System.out.println("After swapping: " + List);
    }
}
