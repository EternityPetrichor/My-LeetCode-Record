package Hot100.Map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class T994 {
    public static void main(String[] args) {
        System.out.println();
    }

    private int count = 0; //新鲜橘子数量

    public int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < x; r++) {
            for (int c = 0; c < y; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int row = orange[0];
                int col = orange[1];
                corrode(grid, row - 1, col, queue);
                corrode(grid, row + 1, col, queue);
                corrode(grid, row, col + 1, queue);
                corrode(grid, row, col - 1, queue);
            }
        }
        return count > 0 ? -1 : round;
    }

    private void corrode(int[][] grid, int row, int col, Queue<int[]> queue) {
        //判断是否越界
        if (!inArea(grid, row, col)) {
            return;
        }
        //是否为新鲜橘子
        if (grid[row][col] != 1) {
            return;
        }
        //腐蚀
        grid[row][col] = 2;
        //新鲜橘子数量-1
        count--;
        //将被腐蚀的橘子加入腐蚀队列
        queue.add(new int[]{row, col});
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }


    /*dfs思路*/
    public int orangesRotting1(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    dfs(grid, i, j, 2);
            }
        }

        int MaxTime = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
                if (grid[i][j]>MaxTime)
                    MaxTime = grid[i][j];
            }
        }

        return MaxTime == 0 ? 0 : MaxTime - 2;
    }

    public void dfs(int[][] grid, int r, int c, int level){
        if (!inArea(grid, r, c))
            return;
        if (grid[r][c] != 1 && grid[r][c] < level)
            return;

        grid[r][c] = level;
        dfs(grid, r+1, c, level+1);
        dfs(grid, r-1, c, level+1);
        dfs(grid, r, c+1, level+1);
        dfs(grid, r, c-1, level+1);
    }

}
