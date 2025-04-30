
public class PrintSubarray {
    public static void printSubarray(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
                }
                count++;
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 6;
        arr[3] = 8;
        arr[4] = 10;
        printSubarray(arr);
    }

}