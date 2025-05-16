
public class Selection_Sort {
    public static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        int n = arr.length;
        System.out.println("Original array");
        printArray(arr);
        selectionSort(arr, n);
        System.out.println("Sorted array");
        printArray(arr);
    }
}

// Tc = O(n^2)
// Sc = O(1)
// This code implements the Selection Sort algorithm in Java.