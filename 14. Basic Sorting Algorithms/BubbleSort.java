public class BubbleSort {
    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int swap = 0; // Flag to check if any swapping happened
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = 1; // Set flag to true if swapping happened
                }

            }
            // If no two elements were swapped in the inner loop, then break
            if (swap == 0) {
                break; // Array is already sorted
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
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
