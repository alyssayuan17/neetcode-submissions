class Solution {
    public int coinChange(int[] coins, int amount) {
        // store the min number of coins for a given amount represented by index in arr
        // when we reach amount -> return dp[amount]
        // time: O(n * c) -> each amount processes all coins[] 
        // space: O(n) -> dp arr has length n = amount

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }
}
