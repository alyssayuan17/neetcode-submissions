class Solution {
    public boolean canJump(int[] nums) {
        // at every index, we have a diff reach value
        // the greedy approach is the keep track of this and always take 
        // the greater reach

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // if we cannot reach this curr point, means our maxReach
            // thus far isn't great enough
            if (maxReach < i) {
                return false;
            }

            // if maxReach is greater than or equal to nums length -> true
            if (maxReach >= nums.length - 1) {
                return true;
            }

            // update maxReach against current reach
            maxReach = Math.max(maxReach, nums[i] + i);
        }

        return false;
    }
}
