class Solution {
    public int rob(int[] nums) {
        // at every house, i can either rob the current house
        // or skip
        // - optimalAmount[i - 1] -> optimal amt if we skip
        // - optimalAmount[i - 2] + nums[i] -> optimal amt if we
        //   rob curr house
        // this is ALWAYS safe, since if we rob house i, we know
        // the optimal ans from i - 2 away is far enough away
        // - NOTE: if optimalAmount[i - 1] doesn't use house i - 1,
        //   it can't be more optimal than optimalAmount[i - 2]
        
        int[] optimalAmount = new int[nums.length];

        if (nums.length == 1) {
            return nums[0];
        }

        optimalAmount[0] = nums[0];
        optimalAmount[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // continue taking maxMoney as the max from the running
            // max from either robbing curr house or skipping
            optimalAmount[i] = Math.max(optimalAmount[i - 1], 
                                optimalAmount[i - 2] + nums[i]);
        }
        
        return optimalAmount[nums.length - 1];
    }
}
