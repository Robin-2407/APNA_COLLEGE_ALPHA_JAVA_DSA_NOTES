import java.util.ArrayList;

public class ActivitySelection {

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };

        int maxAct = 0;
        ArrayList<Integer> selectedActivities = new ArrayList<>();

        maxAct = 1;
        selectedActivities.add(0);

        for (int i = 1; i < finish.length; i++) {
            if (start[i] >= finish[selectedActivities.get(maxAct - 1)]) {
                selectedActivities.add(i);
                maxAct++;
            }
        }

        System.out.println("Maximum number of activities: " + maxAct);
        System.out.print("Selected activities: ");
        for (int i = 0; i < selectedActivities.size(); i++) {
            System.out.print(selectedActivities.get(i) + " ");
        }
        System.out.println();

    }
}