class Solution {
    List<List<Integer>> result = new ArrayList<>();

    // time: O(n * 2^n) -> 2^n subsets, n time for each
    // space: O(n) -> n calls stacked total

    public List<List<Integer>> subsets(int[] nums) {
        // backtracking -> add then remove an element
        // at each call level
        // base case: reach nums.length -> last element
        backtracking(0, nums, new ArrayList<>());
        return result;
    }
    
    // mutate result list
    public void backtracking(int index, 
                            int[] nums, 
                            List<Integer> curr) {
        
        // base case -> if index == nums.length
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // add num at each level
        curr.add(nums[index]);
        // backtrack next level
        backtracking(index + 1, nums, curr);

        // remove last element in curr
        curr.remove(curr.size() - 1);
        backtracking(index + 1, nums, curr);
    }
}
