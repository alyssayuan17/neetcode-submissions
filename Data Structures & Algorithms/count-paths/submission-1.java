class Solution {
    public int uniquePaths(int m, int n) {
        // at each coordinate -> right OR down
        // the # of unique paths leading to a given coord is top + left
        // keep track of how many unique paths for each coordinate
        // need some dfs recursion 
        // time: O(m * n)
        // space: O(m * n)

        int[][] dp = new int[m][n];

        return dfs(0, 0, m, n, dp);
    }

    // dfs helper
    public int dfs(int row, int col, int m, int n, int[][] dp) {
        // base case: out of range
        if (row >= m || col >= n) {
            return 0;
        }

        // base case: reached end
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        // base case: if already seen
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        dp[row][col] = dfs(row + 1, col, m, n, dp) + 
                        dfs(row, col + 1, m, n, dp);
        
        return dp[row][col];
    }
}
