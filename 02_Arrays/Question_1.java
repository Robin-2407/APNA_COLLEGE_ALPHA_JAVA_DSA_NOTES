/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Examples:

Example 1:
Input: nums = [1, 2, 3, 1]
Output: true

Example 2:
Input: nums = [1, 2, 3, 4]
Output: false

Example 3:
Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true


Constraints:
1 <= nums.length <= 10⁵
-10⁹ <= nums[i] <= 10⁹ 
*/

import java.util.HashSet;

public class Question_1 {
    public static boolean bruteForce(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean optimal(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 11 };
        System.out.println(bruteForce(nums));
        System.out.println(optimal(nums));
    }
}

// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(1)
// The brute force approach checks every pair of elements in the array to see if
// they are equal.

// Optimal Approach
// Time Complexity: O(n)
// Space Complexity: O(n)
// The optimal approach uses a HashSet to store the elements of the array as we