
public class TrappingRainWater {
    public static int trap(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return waterTrapped;

    }

    public static int secondApproach(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int leftMax = arr[0];
        int rightMax = arr[n - 1];
        int left = 1;
        int right = n - 2;
        int waterTrapped = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                waterTrapped += Math.max(0, leftMax - arr[left]);
                leftMax = Math.max(leftMax, arr[left]);
                left++;
            } else {
                waterTrapped += Math.max(0, rightMax - arr[right]);
                rightMax = Math.max(rightMax, arr[right]);
                right--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trap(arr));
        System.out.println("Water Trapped: " + trap(arr));
        System.out.println("Water Trapped: " + secondApproach(arr));
    }
}
