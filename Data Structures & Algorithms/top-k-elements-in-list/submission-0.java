class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap
        // key-val: num, freq

        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                seen.put(nums[i], seen.get(nums[i]) + 1);
            } else {
                seen.put(nums[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(seen.entrySet());

        // lambda function for sorting reverse
        entries.sort((a, b) -> b.getValue() - a.getValue());

        int[] top_nums = new int[k];

        for (int i = 0; i < k; i++) {
            top_nums[i] = entries.get(i).getKey();
        }

        return top_nums;
    }
}
