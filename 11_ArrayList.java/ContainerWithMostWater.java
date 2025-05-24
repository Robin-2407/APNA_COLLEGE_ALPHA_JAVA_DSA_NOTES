import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int bruteforce(ArrayList<Integer> heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                int width = j - i;
                int height = Math.min(heights.get(i), heights.get(j));
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int optimized(ArrayList<Integer> heights) {
        int maxAraea = 0;
        int left = 0;
        int right = heights.size() - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights.get(left), heights.get(right));
            int area = width * height;
            maxAraea = Math.max(maxAraea, area);
            if (heights.get(left) < heights.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxAraea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        int maxArea = bruteforce(heights);
        System.out.println("Maximum area of water that can be contained: " + maxArea);

        int optimizedMaxArea = optimized(heights);
        System.out.println("Maximum area of water that can be contained (optimized): " + optimizedMaxArea);
    }
}

// Brute force approach
// Tc O(n^2) and Sc O(1)

// Optimized approach
// Tc O(n) and Sc O(1)
// The optimized approach uses two pointers to find the maximum area of water
// that can be contained between two heights.