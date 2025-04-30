
import java.util.Arrays;

public class MaxSubarraySumPrefixArray {
    public static int prefixArray(int arr[]) {
        int prefixArray[] = new int[arr.length];
        prefixArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + arr[i];
        }
        return prefixArray[prefixArray.length - 1];
    }

    public static int maxSubarraySum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = prefixArray(Arrays.copyOfRange(arr, i, j + 1));
                System.out.println(currSum);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("MaxSum: " + maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        System.out.println(maxSubarraySum(arr));
    }
}
