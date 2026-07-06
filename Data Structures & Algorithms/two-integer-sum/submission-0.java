class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        // key-value pairs will be stored with key as the num and
        // value as the index 

        int require = 0;

        for (int i = 0; i < nums.length; i++) {
            require = target - nums[i];

            if (seen.containsKey(require)) {
                return new int [] {seen.get(require), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}
