class Solution {
    public int findDuplicate(int[] nums) {
        // brute force solution: sort nums and 
        // check if nums[i] == prev
        // return nums[i] if so

        Arrays.sort(nums);
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i]) {
                return nums[i];
            }

            prev = nums[i];
        }

        return -1;
    }
}
