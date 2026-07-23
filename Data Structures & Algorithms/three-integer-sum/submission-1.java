class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort first, such that we can avoid duplicate values
        // easily. 
        // fix one item and have two pointers on the rest of the elements
        // if add to 0, add to the list of lists
        // if next element is ==, skip

        List<List<Integer>> sums = new ArrayList<>();

        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        
        for (int i = 0; i < nums.length; i++) {
            // nums[i] is the fixed current element

            // first check if the next fixed element is a dup, if so, skip immediately
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> new_lst = new ArrayList<>(List.of(nums[i], nums[left], nums[right]));
                    sums.add(new_lst);
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                    continue; // when exiting this iteration, we have confirmed it's not a dup
                }

                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    continue;
                }

                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    continue;
                }
            }
        }

        return sums;
    }
}
