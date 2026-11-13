class Solution {
    public int jump(int[] nums) {
        // how can we know which num j such that j <= nums[i] to take 
        // gives our minimum 
        // greedy: take the curr furthest reach or nums[i] + j
        // [2,4,1,1,1,1]
        //  - at index 0 -> furthest reach is max(0, 0 + j) for j <= 2
        //      - jumps++ if 0 + j is greater
        //  - at index 1 -> furthest reach is max(2, 1 + j) for j <= 4
        //      - jumps++ if 1 + j is greater
        //  - if i + j >= nums.length don't count
        // once we reach nums.length - 1 -> return jumps
        // time: O(n), since each num is visited only once 
        // space: O(1), since we use constant auxiliary space
        
        int furthest = 0; 
        int jumps = 0;
        // keep track of the curr end -> where the current jump ends 
        int currEnd = 0; 

        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] < nums.length && i + nums[i] < nums.length) {
                furthest = Math.max(furthest, i + nums[i]); 
            }

            if (currEnd == i) {
                jumps++;
                currEnd = furthest;
            }
        }

        return jumps; // assume always valid
    }
}
