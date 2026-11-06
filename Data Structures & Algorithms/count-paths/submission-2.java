class Solution {
    public int uniquePaths(int m, int n) {
        // top-down memoization 
        // start from finish -> how many ways to a given coord?

        int[][] dp = new int[m][n];

        return dfs(m - 1, n - 1, m, n, dp);
    }

    // dfs helper top-down
    public int dfs(int row, int col, int m, int n, int[][] dp) {
        // base case: oob
        if (row < 0 || col < 0) {
            return 0;
        }

        // base case: reached start
        if (row == 0 && col == 0) {
            return 1;
        }

        // base case: seen before
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        
        // construct dp[row][col]
        dp[row][col] = dfs(row - 1, col, m, n, dp) + 
                        dfs(row, col - 1, m, n, dp);

        return dp[row][col];
    }
}
