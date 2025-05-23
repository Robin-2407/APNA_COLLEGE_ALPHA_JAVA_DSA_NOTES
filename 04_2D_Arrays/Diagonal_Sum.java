
public class Diagonal_Sum {
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                } else if (i + j == n - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int Optimized(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i]; // Primary diagonal
            sum += matrix[i][n - i - 1]; // Secondary diagonal
        }
        // If n is odd, subtract the middle element as it was added twice
        if (n % 2 == 1) {
            sum -= matrix[n / 2][n / 2];
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int sum = diagonalSum(matrix);
        System.out.println("Diagonal Sum: " + sum);
        int optimizedSum = Optimized(matrix);
        System.out.println("Optimized Diagonal Sum: " + optimizedSum);
    }
}

// Brute Force Approach
// Tc: O(n^2)
// Sc: O(1)

// Optimized Approach
// Tc: O(n)
// Sc: O(1)