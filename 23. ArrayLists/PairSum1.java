import java.util.ArrayList;

public class PairSum1 {
    public static void bruteForce(ArrayList<Integer> List, int target) {
        for (int i = 0; i < List.size(); i++) {
            for (int j = i + 1; j < List.size(); j++) {
                if (List.get(i) + List.get(j) == target) {
                    System.out.println("Pair found: " + List.get(i) + ", " + List.get(j));
                }
            }
        }
    }

    public static void optimized(ArrayList<Integer> List, int target) {
        int left = 0;
        int right = List.size() - 1;

        while (left < right) {
            int sum = List.get(left) + List.get(right);
            if (sum == target) {
                System.out.println("Pair found: " + List.get(left) + ", " + List.get(right));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);
        List.add(6);
        List.add(7);

        int target = 8;

        bruteForce(List, target);
        optimized(List, target);
    }
}
