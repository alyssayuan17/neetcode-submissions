class Solution {
    public boolean canPartition(int[] nums) {
        // notice that for sum(subset1) == sum(subset2) to be true,
        // each subset must equal totalSum / 2
        // if subset1 == totalSum / 2, then subset2 must also equal
        // totalSum / 2, so they have equal sum
        // keep a dp for booleans -> if true, it means the number (i)
        // can be achieved through the numbers in the arr
        // return dp[totalSum / 2] -> if true, means we can satisfy

        int totalSum = 0;

        // calculate total sum
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        // notice that if totalSum is odd, we cannot evenly partition
        // no matter what -> return false
        if (totalSum % 2 == 1) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];

        // starting truth: since we know that sum 0 is always true
        // just by picking nothing, set dp[0] = true;

        dp[0] = true;

        // at each index, we can either already make the num, 
        // we require the current num to make the num, or we cannot
        // do either
        for (int num : nums) {
            //can I make sum s using the numbers I've seen SO FAR?
            for (int i = target; i >= num; i--) {
                // stop at num, since a num cannot help us to achieve
                // a sum that is smaller than the num
                dp[i] = dp[i] || dp[i - num];
                // ask: can adding nums[i] make it true?
            }
        }

        return dp[target];
    }
}
