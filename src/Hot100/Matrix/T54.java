package Hot100.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(spiralOrder2(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0;
        int bottom = m - 1, right = n - 1;
        while (true){
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (--bottom < top)
                break;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right)
                break;
        }
        return result;
    }

    public static List<Integer> spiralOrder1(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        while (left<=right && top<=bottom){
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left+1<=right && top+1<=bottom){
                for (int i = right-1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom-1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] flag = new boolean[rows][columns];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int total = rows * columns;
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[row][col]);
            flag[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns || flag[nextRow][nextCol])
                directionIndex = (directionIndex + 1) % 4;
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];

        }

        return result;
    }
}
