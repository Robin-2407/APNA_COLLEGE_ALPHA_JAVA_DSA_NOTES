import java.util.ArrayList;

public class PairSumII {
    public static void PairSumIIBruteForce(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i) + arr.get(j) == target) {
                    System.out.println("Pair found: " + arr.get(i) + ", " + arr.get(j));
                    return;
                }
            }
        }
        System.out.println("No pair found");
    }

    public static void PairSumIIOptimized(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int bp = -1;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int left = (bp + 1) % n;
        int right = bp;

        while (left != right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == target) {
                System.out.println("Pair found: " + arr.get(left) + ", " + arr.get(right));
                return;
            } else if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (right - 1 + n) % n;
            }

        }
        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        int target = 17;
        System.out.println("Brute Force Approach:");
        PairSumIIBruteForce(arr, target);

        System.out.println("Optimized Approach:");
        PairSumIIOptimized(arr, target);
    }
}

// Brute force approach
// Tc O(n^2) and Sc O(1)

// Optimized approach
// Tc O(n) and Sc O(1)