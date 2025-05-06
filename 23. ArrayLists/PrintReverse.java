import java.util.ArrayList;

public class PrintReverse {
    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);

        for (int i = List.size() - 1; i >= 0; i--) {
            System.out.print(List.get(i) + " ");
        }
        System.out.println();

    }
}
