import java.util.ArrayList;

public class Maximum {
    public static int findMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(7);

        int max = findMax(list);
        System.out.println("The maximum value in the list is: " + max);
    }
}

// Tc O(n) and Sc O(1)
