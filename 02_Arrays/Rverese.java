
public class Rverese {
    public static void reverse(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println("Original array:");
        printArray(arr);
        reverse(arr);
        System.out.println("Reversed array:");
        printArray(arr);
    }
}
