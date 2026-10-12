class Solution {
    public int findDuplicate(int[] nums) {
        // notice that since each integer in nums is in the range [1,n]
        // then we can use it to represent the indices in our array 
        // use a fast and slow pointer to jump from index to index via setting
        // pointer = nums[pointer]
        // since we know for sure there is one dup 
        // - first time the two pointers meet indicates we are in the loop
        // - use this to find the beginning of the loop -> return this
        // - if there are multiple indices pointing to the same val,
        //   this must be our duplicate -> is the start of our cycle

        int fast = 0;
        int slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]]; // skipping twice
        } while (fast != slow);

        // once we exit, we have fast = slow, so use this to find our beginning
        // of cycle

        int p = 0;

        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }

        // once we exit, we have p = slow -> met at the cycle entrance
        return slow;
    }
}
