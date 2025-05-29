import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int weights[] = { 10, 20, 30 };
        int value[] = { 60, 100, 120 };
        int w = 50;

        double ratio[][] = new double[weights.length][2];
        for (int i = 0; i < weights.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weights[i];
        }

        // Sort in descending order of value/weight ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        double maxValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weights[idx]) {
                // Take the whole item
                capacity -= weights[idx];
                maxValue += value[idx];
            } else {
                // Take the fraction of the item
                maxValue += value[idx] * (capacity / (double) weights[idx]);
                capacity = 0; // Knapsack is full
                break; // Knapsack is full
            }
        }
        System.out.println("Maximum value = " + maxValue);
    }
}

// Tc : O(n log n) for sorting
// Sc : O(n) for storing the ratio