class Solution {
    public int findDuplicate(int[] nums) {
        // time: O(n), space: O(n) solution
        // store seen nums in a hashset

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return nums[i];
            }

            seen.add(nums[i]);
        }

        return -1;
    }
}
