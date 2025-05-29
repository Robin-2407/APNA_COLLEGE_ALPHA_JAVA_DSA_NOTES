/*
 * 932. Beautiful Array
 * An array nums of length n is beautiful if:
 * nums is a permutation of the integers in the range [1, n].
 * For every 0 <= i < j < n, there is no index k with i < k < j where 2 *
 * nums[k] == nums[i] + nums[j].
 * Given the integer n, return any beautiful array nums of length n. There will
 * be at least one valid answer for the given n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4
 * Output: [2,1,4,3]
 * Example 2:
 * Input: n = 5
 * Output: [3,1,2,5,4]
 * 
 * 
 * Constraints:
 * 1 <= n <= 1000
 */

import java.util.*;

/*
 * public class BeautifulArray {
 * 
 * public static List<Integer> beautifulArray(int n) {
 * List<Integer> nums = new ArrayList<>();
 * for (int i = 1; i <= n; i++)
 * nums.add(i);
 * 
 * List<List<Integer>> permutations = new ArrayList<>();
 * permute(nums, 0, permutations);
 * 
 * for (List<Integer> perm : permutations) {
 * if (isBeautiful(perm))
 * return perm;
 * }
 * 
 * return new ArrayList<>();
 * }
 * 
 * private static void permute(List<Integer> nums, int start,
 * List<List<Integer>> result) {
 * if (start == nums.size()) {
 * result.add(new ArrayList<>(nums));
 * return;
 * }
 * for (int i = start; i < nums.size(); i++) {
 * Collections.swap(nums, i, start);
 * permute(nums, start + 1, result);
 * Collections.swap(nums, i, start);
 * }
 * }
 * 
 * private static boolean isBeautiful(List<Integer> nums) {
 * int n = nums.size();
 * for (int i = 0; i < n; i++) {
 * for (int j = i + 2; j < n; j++) {
 * for (int k = i + 1; k < j; k++) {
 * if (2 * nums.get(k) == nums.get(i) + nums.get(j)) {
 * return false;
 * }
 * }
 * }
 * }
 * return true;
 * }
 * 
 * public static void main(String[] args) {
 * System.out.println(beautifulArray(4)); // Example Output: [2,1,4,3]
 * }
 * }
 * 
 * Brute force solution to generate all permutations and check for the beautiful
 * condition.
 * This is not efficient for larger n, but works for the constraints given (n <=
 * 1000).
 * A more efficient approach would be to use a recursive or mathematical method
 * to generate the beautiful array directly.
 * 
 * 
 * // Tc: O(n! * n^2) for generating permutations and checking each for the
 * condition
 * // Sc: O(n! * n) to store all permutations
 */

import java.util.ArrayList;

public class BeautifulArray {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();

            // Add odd numbers first
            for (int i : ans) {
                if (i * 2 - 1 <= n) {
                    temp.add(i * 2 - 1);
                }
            }

            // Add even numbers next
            for (int i : ans) {
                if (i * 2 <= n) {
                    temp.add(i * 2);
                }
            }

            ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(beautifulArray(4)); // Example Output: [2,1,4,3]
    }
}

// The above code uses a mathematical approach to generate the beautiful array
// directly without generating all permutations. It builds the array iteratively
// by first adding even numbers and then odd numbers, ensuring that the
// beautiful condition is maintained. This is much more efficient than the brute
// force method and works well within the constraints given (n <= 1000).
// Time Complexity: O(n) for the while loop, where n is the size of the
// array being built.
// Space Complexity: O(n) for storing the resulting beautiful array.
// ✅Explanation:

// Start with
// base array:[1]

// On each iteration:

// For each
// x in
// the array:

// Add 2*x-1 if≤n→
// creates odd

// numbers (beautiful part)

// Add 2 * x if ≤ n → creates even

// numbers (also beautiful)

// Repeat until we generate n numbers