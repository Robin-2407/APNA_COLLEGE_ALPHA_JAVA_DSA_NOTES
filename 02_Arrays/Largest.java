public class Largest {
    public static void largest(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Largest element: " + max);
    }

    public static void smallest(int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Smallest element: " + min);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 9, 5, 12, 6, 7, 8 };
        largest(arr);
        smallest(arr);
    }
}
