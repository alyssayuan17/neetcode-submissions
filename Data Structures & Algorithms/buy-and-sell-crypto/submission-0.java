class Solution {
    public int maxProfit(int[] prices) {
        // selling must be in the future (later in the arr)

        int maxProfit = 0;
        int lowestPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestPrice;

            // take max profit
            maxProfit = Math.max(maxProfit, profitIfSoldToday);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }

        return maxProfit;
    }
}
