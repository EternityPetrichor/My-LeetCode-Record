package Hot100.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T73 {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = new int[][]{{0,9,3,3,8,2,1,4,1,7,1,2,7}, {6, 0, 2, 3, 3, 8, 5, 1, 9, 3, 2, 0, 7}, {8, 4, 6, 0, 2, 6, 1, 5, 1, 0, 7, 2, 6}, {1, 1, 9, 3, 9, 6, 5, 1, 1, 1, 1, 7, 2}, {0, 0, 6, 3, 9, 4, 7, 5, 6, 0, 3, 7, 7}, {5, 9, 7, 9, 6, 8, 1, 5, 3, 0, 3, 8, 3}, {5, 1, 7, 4, 3, 9, 4, 9, 2, 6, 5, 0, 3}};
        System.out.println(Arrays.deepToString(matrix));
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /*空间复杂度O(1)*/
    public static void setZeroes(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                flagCol0 = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0)
                flagRow0 = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (flagCol0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0){
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }


    /*空间复杂度O(m+n)*/
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes3(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    list.add(i+"+"+j);
            }
        }
        for(String s : list){
            String[] split = s.split("\\+");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }
}
