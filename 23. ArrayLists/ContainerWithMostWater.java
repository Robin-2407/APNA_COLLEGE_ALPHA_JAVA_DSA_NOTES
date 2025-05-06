import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int bruteForce(ArrayList<Integer> List) {
        int maxArea = 0;
        for (int i = 0; i < List.size(); i++) {
            for (int j = i + 1; j < List.size(); j++) {
                int height = Math.min(List.get(i), List.get(j));
                int width = j - i;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int optimized(ArrayList<Integer> List) {
        int maxArea = 0;
        int left = 0;
        int right = List.size() - 1;

        while (left < right) {
            int height = Math.min(List.get(left), List.get(right));
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (List.get(left) < List.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(8);
        List.add(6);
        List.add(2);
        List.add(5);
        List.add(4);
        List.add(8);
        List.add(3);
        List.add(7);

        System.out.println(bruteForce(List));
        System.out.println(optimized(List));
    }
}
