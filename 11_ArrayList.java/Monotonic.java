/* 
Question 1: Monotonic ArrayList (EASY)
An ArrayList is monotonic if it is either monotone increasing or monotone decreasing.
An ArrayList nums is monotone increasing if for all i <= j, nums.get(i) <= nums.get(j).
An ArrayList nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j).

Task:
Given an integer ArrayList nums, return true if the given list is monotonic, or false otherwise.

Sample Input 1:
nums = [1, 2, 2, 3]
Sample Output 1:
true

Sample Input 2:
nums = [6, 5, 4, 4]
Sample Output 2:
true

Sample Input 3:
nums = [1, 3, 2]
Sample Output 3:
false

Constraints:

1 <= nums.size() <= 10^5

-10^5 <= nums.get(i) <= 10^5 
*/

import java.util.ArrayList;

public class Monotonic {
    public static boolean isMonotonic(ArrayList<Integer> arr) {
        boolean inc = true;
        boolean dec = true;
        int n = arr.size();

        for (int i = 1; i < n; i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                dec = false;
            } else if (arr.get(i) < arr.get(i - 1)) {
                inc = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(4);
        arr.add(5);

        boolean isMonotonic = isMonotonic(arr);
        System.out.println("Is the array monotonic? " + isMonotonic);
    }
}

// Tc O(n) and Sc O(1)