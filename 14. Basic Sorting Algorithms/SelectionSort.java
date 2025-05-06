public class SelectionSort {
    public static void selectionsort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {

        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        int n = arr.length;
        selectionSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr);

    }
}
