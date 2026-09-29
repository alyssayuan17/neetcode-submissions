class Solution {
    public int maxSubArray(int[] nums) {
        // keep track of curr largestSum 
        // at a new nums[i], check if adding it will decrease currSum
        // if so, largestSum = Math.max(largestSum, currSum) and
        // currSum = Math.max(curr, curr + curSum)
        // else, add to currSum and continue

        int largestSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            largestSum = Math.max(largestSum, currSum);
        }

        return largestSum;
    }
}
