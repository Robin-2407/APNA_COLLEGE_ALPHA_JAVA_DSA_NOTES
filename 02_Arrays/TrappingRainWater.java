import java.util.HexFormat;

public class TrappingRainWater {
    public static int BruteForce(int height[]) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;

        // Tc = O(n)
        // Sc = O(n)
        // Space complexity can be reduced to O(1) by using two pointers
        // approach instead of using two arrays.
    }

    public static int Optimized(int height[]) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n - 1;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;

        // Tc = O(n)
        // Sc = O(1)
        // Space complexity is reduced to O(1) by using two pointers
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("Trapped Water is " + BruteForce(height));
        System.out.println("Trappeed Water is " + Optimized(height));
    }
}