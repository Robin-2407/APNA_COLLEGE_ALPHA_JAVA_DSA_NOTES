import java.util.ArrayList;

public class Maximum {
    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(21);
        List.add(345);
        List.add(24);
        List.add(50);

        int max = List.get(0);
        for (int i = 1; i < List.size(); i++) {
            if (List.get(i) > max) {
                max = List.get(i);
            }
        }
        System.out.println();
        System.out.println("The maximum value in the list is: " + max);
    }
}
