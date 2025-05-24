import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> innerList1 = new ArrayList<>();
        ArrayList<Integer> innerList2 = new ArrayList<>();
        ArrayList<Integer> innerList3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            innerList1.add(i * 1);
            innerList2.add(i * 2);
            innerList3.add(i * 3);
        }

        list.add(innerList1);
        list.add(innerList2);
        list.add(innerList3);
        System.out.println("Multi-dimensional ArrayList:");
        for (ArrayList<Integer> innerList : list) {
            System.out.println(innerList);
        }
    }
}
