class Solution {
    public boolean canJump(int[] nums) {
        // nums[i] + i is how far you can reach at this given point
        // there is a chance the nums[i] you are at will not reach 
        // further than prevous nums[i], so maintain a maxReach
        // update at every nums[i]
        // if we eventually have maxReach >= nums.length - 1, return true

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // check if we can even reach this index from the prev indices
            if (maxReach < i) {
                return false; 
            }
            
            // check if we can reach the end from here
            if (maxReach >= nums.length - 1) {
                return true;
            }

            maxReach = Math.max(maxReach, nums[i] + i);
        }

        return false;
    }
}
