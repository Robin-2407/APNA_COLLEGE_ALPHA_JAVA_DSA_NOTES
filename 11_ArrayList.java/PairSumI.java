import java.util.ArrayList;

public class PairSumI {
    public static void PairSumIBruteForce(ArrayList<Integer> arr, int target) {
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

    public static void PairSumIOptimized(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == target) {
                System.out.println("Pair found: " + arr.get(left) + ", " + arr.get(right));
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        int target = 7;
        System.out.println("Brute Force Approach:");
        PairSumIBruteForce(arr, target);

        System.out.println("Optimized Approach:");
        PairSumIOptimized(arr, target);
    }
}

// Brute force approach
// Tc O(n^2) and Sc O(1)

// Optimized approach
// Tc O(n) and Sc O(1)
// The optimized approach uses two pointers to find the pair with the given sum.