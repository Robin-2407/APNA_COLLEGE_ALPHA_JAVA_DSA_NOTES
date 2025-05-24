
/*
You're given an ArrayList<Integer> nums and an integer key.
Find the number that most frequently follows the key in the list.
That is, for every index i where nums[i] == key, consider nums[i + 1] (if it exists). Return the number that appears most frequently right after the key.

🔍 Example:
Input: nums = [1, 2, 2, 2, 3], key = 2  
Output: 3

Explanation:  
- key=2 is at index 1 → nums[2] = 2  
- key=2 is at index 2 → nums[3] = 2  
- key=2 is at index 3 → nums[4] = 3  
→ The numbers that follow `2` are: [2, 2, 3]  
→ 2 occurs twice, 3 occurs once → **Answer = 2** 
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumbersFollowingKey {
    public static int BruteForce(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int maxCount = 0;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == key && i + 1 < n) {
                int nextNum = nums.get(i + 1);
                int count = 0;

                for (int j = i + 1; j < n; j++) {
                    if (nums.get(j) == nextNum) {
                        count++;
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    result = nextNum;
                }
            }
        }
        return result;
    }

    public static int optimized(ArrayList<Integer> nums, int key) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == key && i + 1 < n) {
                int nextNum = nums.get(i + 1);
                freq.put(nextNum, freq.getOrDefault(nextNum, 0) + 1);
            }
        }

        int maxCount = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);

        System.out.println(BruteForce(nums, 1)); // Output: 100

        System.out.println(optimized(nums, 1)); // Output: 100

    }
}

// BruteForce Approach
// Tc: O(n^2)
// Sc: O(1)

// Optimized Approach
// Tc: O(n)
// Sc: O(n)
// The optimized approach uses a HashMap to store the frequency of numbers that
// follow the key.
// This allows us to count the occurrences in a single pass through the list,
// making it more efficient than the brute force approach.