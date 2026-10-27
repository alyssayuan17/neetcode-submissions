class Solution {
    HashSet<Integer> used = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // length of each permutation is length of nums
        // n! options for each
        // - for each num chosen, choose the remaining nums
        //      - keep track of which ones we have used already
        // - at each call level, call loop on remaining nums to represent
        //   all choices
        // base case: used.length == nums.length 
        // - we have seen + chosen all nums
        // time: O(n * n!) -> n! choices, each num is O(n) time processing
        // space: O(n) -> n nums in used 
        
        dfs(nums[0], new ArrayList<>(), nums);
        return result;
    }

    public void dfs(int num, List<Integer> curr, int[] nums) {
        if (used.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // only call dfs on non-used nums
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                curr.add(nums[i]);

                dfs(nums[i], curr, nums);

                curr.remove(curr.size() - 1);
                used.remove(nums[i]);
            }
        }
    }
}
