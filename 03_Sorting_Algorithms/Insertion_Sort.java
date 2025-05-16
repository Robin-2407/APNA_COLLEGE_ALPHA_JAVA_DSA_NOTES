public class Insertion_Sort {
    public static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; ++i) {
            int curr = arr[i];
            int prev = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        int n = arr.length;
        System.out.println("Original array");
        printArray(arr);
        insertionSort(arr, n);
        System.out.println("Sorted array");
        printArray(arr);
    }
}

// Time Complexity: O(n^2) in the worst case
// Space Complexity: O(1) as it is an in-place sorting algorithm