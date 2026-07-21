class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> all_nums = new HashSet<>();
        // hashset instantly removes all duplicates and 
        // keeps only one copy

        for (int num : nums) {
            all_nums.add(num);
        }

        int longest_len = 1;

        for (int num : all_nums) {
            int cur_len = 1; 
            // check if the num[i] is a potential first 
            // element in the consecutive sequence
            if (!all_nums.contains(num - 1)) {
                int start = num;
                while(all_nums.contains(start + 1)) {
                    cur_len++;
                    start += 1;
                }
                longest_len = Math.max(longest_len, cur_len);
            }
        }

        return longest_len;
    }
}
