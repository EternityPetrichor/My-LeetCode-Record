package Hot100.Matrix;

import java.util.Arrays;

public class T59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix1(2)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        int i = 1;
        while (left <= right && top <= bottom){
            for (int j = left; j <= right; j++) {
                matrix[top][j] = i;
                i++;
            }
            for (int j = top+1; j <= bottom; j++) {
                matrix[j][right] = i;
                i++;
            }
            if (left < right && top < bottom){
                for (int j = right-1; j > left; j--) {
                    matrix[bottom][j] = i;
                    i++;
                }
                for (int j = bottom; j > top; j--) {
                    matrix[j][left] = i;
                    i++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return matrix;
    }

    public static int[][] generateMatrix1(int n){
        int[][] matrix = new int[n][n];
        boolean[][] flag = new boolean[n][n];
        int row = 0, col = 0;

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        int number = n * n;

        for (int i = 1; i <= number; i++) {
            matrix[row][col] = i;
            flag[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow<0 || nextRow>=n || nextCol<0 || nextCol>=n || flag[nextRow][nextCol])
                directionIndex = ++directionIndex % 4;
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }

        return matrix;
    }
}
