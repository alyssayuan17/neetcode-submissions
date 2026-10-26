class Solution {
    // time: O((1 + T/m) * 2^(n + T/m))
    // - n = nums.length, T = target, m = smallest number in nums (all positive)
    // - each call branches twice -> 2^d -> 2^(n + T/m)
    //      - d = maximum depth = n (exclude n candidates) + T/m (OR include at most nums)
    // - copying each successful combination takes up to O(T/m) at most
    // space: O(n + T/m)
    // - recursion depth is O(n + T/m)
    // - curr stores at most O(T/m)
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // at each number -> 2 choices:
        // - include it -> index (same num can be considered multiple times)
        // - exclude it -> index + 1
        // dfs + backtracking approach -> all nums are positive, so two outcomes:
        // - sum == target -> add to result
        // - sum > target -> return (don't do anything)

        dfs(target, 0, nums, 0, new ArrayList<>());
        return result;
    }

    public void dfs(int target, int index, int[] nums, int sum, List<Integer> curr) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index == nums.length) {
            return; // out of bounds
        }

        if (sum > target) {
            return;
        }

        // include it
        curr.add(nums[index]);
        dfs(target, index, nums, sum + nums[index], curr);

        // exclude it
        curr.remove(curr.size() - 1);
        dfs(target, index + 1, nums, sum, curr);
    }
}
