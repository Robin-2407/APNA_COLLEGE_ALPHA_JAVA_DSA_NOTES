import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {

        Integer costVer[] = { 2, 1, 3, 1, 4 }; // Cost of vertical cuts
        Integer costHor[] = { 4, 1, 2 }; // Cost of horizontal cuts

        int n = costHor.length; // Number of horizontal cuts
        int m = costVer.length; // Number of vertical cuts

        // Sort the costs in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int totalCost = 0;
        int horizontalCuts = 0; // Start with one piece horizontally
        int verticalCuts = 0; // Start with one piece vertically
        int h = 0; // Index for horizontal cuts
        int v = 0; // Index for vertical cuts

        // Process the cuts
        while (h < n && v < m) {
            if (costHor[h] >= costVer[v]) {
                // Take the horizontal cut
                totalCost += costHor[h] * (verticalCuts + 1);
                horizontalCuts++;
                h++;
            } else {
                // Take the vertical cut
                totalCost += costVer[v] * (horizontalCuts + 1);
                verticalCuts++;
                v++;
            }
        }
        // Process remaining horizontal cuts
        while (h < n) {
            totalCost += costHor[h] * (verticalCuts + 1);
            horizontalCuts++;
            h++;
        }
        // Process remaining vertical cuts
        while (v < m) {
            totalCost += costVer[v] * (horizontalCuts + 1);
            verticalCuts++;
            v++;
        }
        System.out.println("Minimum cost to cut the chocolate: " + totalCost);
        System.out.println("Total horizontal cuts: " + horizontalCuts);
        System.out.println("Total vertical cuts: " + verticalCuts);
        System.out.println("Total cost: " + totalCost);
        System.out.println("Total pieces of chocolate: " + (horizontalCuts + 1) * (verticalCuts + 1));

    }
}
