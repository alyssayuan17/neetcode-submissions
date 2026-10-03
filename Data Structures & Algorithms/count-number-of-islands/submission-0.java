class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;

                    dfs(grid, i, j);
                    // mark all connected land as '0' so we don't
                    // count again
                }
            }
        }
        return islands;
    }

    public void dfs (char[][] grid, int row, int col) {
        // exit if this is outside grid or '0'
        if (row < 0 || row >= grid.length || col < 0 || 
            col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // otherwise, must be a valid index and '1'
        // mark as '0'
        grid[row][col] = '0';

        // explore all land connected to this land
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
