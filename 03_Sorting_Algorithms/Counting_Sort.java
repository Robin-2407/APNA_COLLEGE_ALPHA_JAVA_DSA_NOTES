
public class Counting_Sort {
    public static void countingSort(int arr[], int n) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, arr[i]);
        }

        int count[] = new int[maximum + 1];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i <= maximum; i++) {
            while (count[i] > 0) {
                arr[idx++] = i;
                count[i]--;
            }
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 8, 3, 3, 1 };
        int n = arr.length;
        System.out.println("Original array");
        printArray(arr);
        countingSort(arr, n);
        System.out.println("Sorted array");
        printArray(arr);
    }
}

// Time Complexity: O(n + k) where n is the number of elements in the array and
// k is the range of the input
// Space Complexity: O(k) where k is the range of the input
