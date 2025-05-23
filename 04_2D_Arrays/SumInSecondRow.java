public class SumInSecondRow {
    public static int sumInSecondRow(int[][] matrix) {
        int sum = 0;
        int n = 1;
        int m = matrix[0].length;

        for (int j = 0; j < m; j++) {
            sum += matrix[n][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int sum = sumInSecondRow(matrix);
        System.out.println("Sum in second row: " + sum);
    }
}
