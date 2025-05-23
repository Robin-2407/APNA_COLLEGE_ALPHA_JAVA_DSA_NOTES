public class SearchInSortedMatrix {
    public static boolean bruteForce(int matrix[][], int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean optimized(int matrix[][], int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int target = 7;
        boolean result = bruteForce(matrix, target);
        System.out.println(result);

        System.out.println(optimized(matrix, target));
    }
}

// brute Force Approach
// Tc: O(n*m)
// Sc: O(1)

// Optimized Approach
// Tc: O(n+m)
// Sc: O(1)