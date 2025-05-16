/*
Question:

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is:
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]

For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Examples:

Example 1:
Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
Output: 4

Example 2:
Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
- 1 <= nums.length <= 5000
- -10^4 <= nums[i] <= 10^4
- All values of nums are unique.
- nums is an ascending array that is possibly rotated.
- -10^4 <= target <= 10^4

*/
public class Question_2 {
    public static int bruteForce(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int search(int nums[], int target) {
        // int pivot = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        // if (nums[i] > nums[i + 1]) {
        // pivot = i;
        // break;
        // }
        // }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int pivot = low;

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realMid = (mid + pivot) % nums.length;
            if (nums[realMid] == target) {
                return realMid;
            }
            if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(bruteForce(nums, target));
        System.out.println(search(nums, target));
    }
}

// Brute Force Approach
// Time Complexity: O(n)
// Space Complexity: O(1)
// The brute force approach checks every element in the array to see if it is
// equal
// to the target. This is not efficient for large arrays.

// Optimal Approach
// Time Complexity: O(log n)
// Space Complexity: O(1)
// The optimal approach uses binary search to find the pivot point in the
// rotated array,
// and then performs a modified binary search to find the target.
