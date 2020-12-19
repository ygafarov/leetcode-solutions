package problem1252;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] matrix = new int[n][m];
        for (int k = 0; k < indices.length; k++) {
            int row = indices[k][0];
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j]++;
                if (matrix[row][j] % 2 == 1)
                    count++;
                else count--;
            }

            int col = indices[k][1];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col]++;
                if (matrix[i][col] % 2 == 1)
                    count++;
                else count--;
            }
        }
        return count;
    }
}