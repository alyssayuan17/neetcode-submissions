class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // sort nums[] first
        Arrays.sort(nums);

        List<Integer> count_consecutives = new ArrayList<>();

        int count = 1;

        // loop through sorted nums[] and check each for if 
        // nums[i+1] = nums[i] + 1
        // if so, count++, if not, add current count to List
        for (int i = 0; i < nums.length; i++) {
            if (((i + 1) < nums.length) && (nums[i+1] == nums[i] + 1)) {
                count++;
            } else if (((i + 1) < nums.length) && nums[i+1] == nums[i]) {
                continue;
            } else {
                count_consecutives.add(count);
                count = 1;
            }
        }

        return Collections.max(count_consecutives);
    }
}
