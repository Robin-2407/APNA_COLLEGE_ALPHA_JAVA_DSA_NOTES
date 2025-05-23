public class Spiral_Matrix {
    public static void spiralMatrix(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    System.out.print(matrix[endRow][i] + " ");
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                startCol++;
            }

        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        spiralMatrix(matrix);
    }
}

// Tc = O(n*m) where n is the number of rows and m is the number of columns
// Sc = O(1) as we are not using any extra space
// The time complexity is O(n*m) because we are visiting each element of the
// matrix once.
