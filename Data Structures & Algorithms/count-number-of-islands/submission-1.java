class Solution {
    public int numIslands(char[][] grid) {
        // when we encounter a '1', we want to count it as an island
        // however, all connecting land (adjacent '1's cannot be counted)
        // recursively turn all adjacent '1's into '0's
        // time: O(n * m), where n is num rows and m is num cols
        // space: O(n * m), since worst case we recursively stack the 
        // entire grid

        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // count as an island
                    numIslands++;
                    // recursively remove all connecting land 
                    // so we don't count twice
                    dfs(grid, i, j);
                }
            }
        }
        
        return numIslands;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || 
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }
        
        // otherwise, must be a valid piece of land
        grid[row][col] = '0';
        
        // continue recursively calling four directions until we 
        // exit the grid or reach water
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
