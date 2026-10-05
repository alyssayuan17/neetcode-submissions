class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs -> recursively calculate area
        // take max
        // time: O(n * m), n -> num rows, m -> num cols
        // space: O(n * m), worst case recursive stack entire grid

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // start counting area
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea; 
    }

    public int dfs(int[][] grid, int row, int col) {
        // base case: if this plot is 0 or out of bounds, return
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        // else, must be land
        grid[row][col] = 0;

        return 1 + 
                dfs(grid, row + 1, col) +
                dfs(grid, row - 1, col) +
                dfs(grid, row, col + 1) +
                dfs(grid, row, col - 1);
    }
}
