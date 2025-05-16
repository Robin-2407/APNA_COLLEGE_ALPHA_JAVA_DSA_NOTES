import java.util.*;
import java.util.Collections;

public class Inbuild_Sort {
    public static void printArray(Integer arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Integer arr[] = { 12, 11, 13, 5, 6 };
        System.out.println("Original array");
        printArray(arr);
        Arrays.sort(arr);
        Arrays.sort(arr, 0, 3); // Sorts the first 3 elements
        // Arrays.sort(arr, 3, 5); // Sorts the last 2 elements
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Sorted array");
        printArray(arr);
    }
}

// Time Complexity: O(n log n) in the worst case
// Space Complexity: O(n) as it uses a temporary array for sorting
