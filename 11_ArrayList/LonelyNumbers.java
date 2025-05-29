
/*
Question 2: Lonely Numbers in ArrayList (MEDIUM)
You are given an integer ArrayList nums. A number x is lonely when:
It appears only once, and No adjacent numbers (i.e., x + 1 or x - 1) appear in the ArrayList.

Task:
Return all lonely numbers in nums. You may return the answer in any order.

Sample Input 1:
nums = [10, 6, 5, 8]
Sample Output 1:
[10, 8]
Explanation:
10 is a lonely number since it appears exactly once and neither 9 nor 11 appears in nums.
8 is a lonely number since it appears exactly once and neither 7 nor 9 appears in nums.

Sample Input 2:
nums = [1, 3, 5, 3]
Sample Output 2:
[1, 5]

Explanation:
1 is a lonely number since it appears exactly once and neither 0 nor 2 appears in nums.
5 is a lonely number since it appears exactly once and neither 4 nor 6 appears in nums.
3 is not a lonely number since it appears twice.
Hence, the lonely numbers in nums are [1, 5].
Note that [5, 1] may also be returned.

Constraints:
1 <= nums.size() <= 10^5
0 <= nums.get(i) <= 10^6

*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LonelyNumbers {
    public static ArrayList<Integer> bruteForce(ArrayList<Integer> nums) {
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            boolean hasAdjacent = false;
            int current = nums.get(i);
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums.get(j) == current)
                    count++;
                if (nums.get(j) == current - 1 || nums.get(j) == current + 1) {
                    hasAdjacent = true;
                }

            }
            if (count == 1 && !hasAdjacent) {
                lonelyNumbers.add(current);
            }

        }
        return lonelyNumbers;
    }

    public static ArrayList<Integer> optimized(ArrayList<Integer> nums) {
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();
        int n = nums.size();

        Collections.sort(nums);

        for (int i = 0; i < n; i++) {
            boolean isUnique = true;
            boolean hasAdjacent = false;

            if (i > 0 && nums.get(i) == nums.get(i - 1)) {
                isUnique = false;
            }
            if (i < n - 1 && nums.get(i) == nums.get(i + 1)) {
                isUnique = false;
            }

            if (i > 0 && nums.get(i) == nums.get(i - 1) + 1) {
                hasAdjacent = true;
            }
            if (i < n - 1 && nums.get(i) == nums.get(i + 1) - 1) {
                hasAdjacent = true;
            }
            if (isUnique && !hasAdjacent) {
                lonelyNumbers.add(nums.get(i));
            }
        }
        return lonelyNumbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);

        ArrayList<Integer> result = bruteForce(nums);
        System.out.println(result); // Output: [10, 8]

        System.out.println("Optimized Approach:");
        ArrayList<Integer> optimizedResult = optimized(nums);
        System.out.println(optimizedResult); // Output: [10, 8]
    }

}

// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(n) for the result array
// The brute force approach is not efficient for large inputs, as it has a time
// complexity of O(n^2).

// Optimized Approach
// Time Complexity: O(n log n) for sorting + O(n) for the loop
// Space Complexity: O(n) for the result array
