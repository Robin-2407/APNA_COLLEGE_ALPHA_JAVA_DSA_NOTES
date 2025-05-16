
public class MaxSubarraySum {
    public static void subarraySumBruteForce(int arr[]) {
        int sum;
        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                ms = Math.max(sum, ms);
            }
        }
        System.out.println("Max Sum is " + ms);
    }

    public static void subarraySumPrefixSum(int arr[]) {
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            int sum = 0;
            for (int j = i; j < prefix.length; j++) {
                sum = prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
                System.out.println("Sum of subarray from " + i + " to " + j + " is " + sum);
                ms = Math.max(sum, ms);
            }
        }
        System.out.println("Max Sum is " + ms);
    }

    public static void subarraySumKadnesAlgorithm(int arr[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
            // System.out.println("Sum of subarray from 0 to " + i + " is " + cs);
        }
        System.out.println("Max Sum is " + ms);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        // subarraySumBruteForce(arr);
        // subarraySumPrefixSum(arr);
        subarraySumKadnesAlgorithm(arr);
    }
}
