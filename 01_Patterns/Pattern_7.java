/*
 INVERTED HALF-PYRAMID with Numbers pattern
 
 1 2 3 4 5
 1 2 3 4
 1 2 3
 1 2
 1
 
 */

public class Pattern_7 {
    public static void halfPyramidnum(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        halfPyramidnum(5);
    }
}