package Hot100.Matrix;

import java.util.Arrays;

public class T48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /*先转置矩阵，再两两调换*/
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            int left = i, right = n - 1 - i;
            for (int j = 0; j < n; j++) {
                temp = matrix[j][left];
                matrix[j][left] = matrix[j][right];
                matrix[j][right] = temp;
            }
        }
    }
    /*给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度*/
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return;
        int temp;
        int level = 0;

        while (level + 2 <= n){
            for (int i = level; i < n - level - 1; i++) {
                temp = matrix[level][i];
                matrix[level][i] = matrix[n-i-1][level];
                matrix[n-i-1][level] = matrix[n-level-1][n-i-1];
                matrix[n-level-1][n-i-1] = matrix[i][n-level-1];
                matrix[i][n-level-1] = temp;
            }
            level ++;
        }

    }
}
