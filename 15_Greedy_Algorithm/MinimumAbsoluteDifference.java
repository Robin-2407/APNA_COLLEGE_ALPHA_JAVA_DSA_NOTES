import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4 };
        int b[] = { 1, 2, 3, 4 };

        Arrays.sort(a);
        Arrays.sort(b);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int diff = Math.abs(a[i] - b[i]);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        System.out.println("Minimum Absolute Difference: " + minDiff);
    }
}
