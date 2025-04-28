package Hot100.Map;

public class T200 {
    public static void main(String[] args) {
        System.out.println("岛屿数量");
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c){
        if (!isInArea(grid, r, c))
            return;
        if (grid[r][c] != '1')
            return;
        grid[r][c] = '2';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }

    public static boolean isInArea(char[][] grid, int r, int c){
        return r>=0 && r< grid.length && c>=0 && c<grid[0].length;
    }

}
