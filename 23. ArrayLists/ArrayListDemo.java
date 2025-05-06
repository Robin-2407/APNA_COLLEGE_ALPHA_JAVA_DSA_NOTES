import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create a new ArrayList
        ArrayList<String> colors = new ArrayList<>();

        // Add elements
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");

        // Print the ArrayList
        System.out.println("Colors: " + colors);

        // Add element at specific index
        colors.add(1, "Yellow");
        System.out.println("After adding Yellow: " + colors);

        // Remove element
        colors.remove("Blue");
        System.out.println("After removing Blue: " + colors);

        // Get element
        String firstColor = colors.get(0);
        System.out.println("First color: " + firstColor);

        // Size of ArrayList
        System.out.println("Number of colors: " + colors.size());
    }
}
