public class NumberOf7s {
    public static int count7s(int matrix[][]) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 7) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 2, 4, 6, 7 },
                { 5, 7, 8, 9 },
                { 10, 11, 12, 13 },
                { 14, 15, 16, 17 }
        };
        int count = count7s(matrix);
        System.out.println("Number of 7s: " + count);
    }
}

// Brute Force Approach
// Tc: O(n*m)
// Sc: O(1)
