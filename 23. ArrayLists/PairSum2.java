import java.util.ArrayList;

public class PairSum2 {
    public static boolean pairsum2(ArrayList<Integer> List, int target) {
        int bp = -1;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i) > List.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int left = (bp + 1) % List.size();
        int right = bp;

        while (left != right) {
            int sum = List.get(left) + List.get(right);
            if (sum == target) {
                System.out.println("Pair found: " + List.get(left) + ", " + List.get(right));
                return true;
            } else if (sum < target) {
                left = (left + 1) % List.size();
            } else {
                right = (right - 1 + List.size()) % List.size();
            }
        }
        System.out.println("No pair found");
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<>();
        List.add(11);
        List.add(15);
        List.add(6);
        List.add(8);
        List.add(9);
        List.add(10);
        int target = 16;

        pairsum2(List, target);

    }
}
