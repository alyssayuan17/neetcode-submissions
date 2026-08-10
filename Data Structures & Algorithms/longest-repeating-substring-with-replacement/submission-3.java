class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window to check frequency of each char in the window
        // track the max freq char
        // if the length of the window (right - left + 1) subtract
        // the frequency of the most freq char is less than or = to k,
        // it means there is enough k to replace all non-maxFreq chars
        // thus, loop and shrink the window from the left until this becomes
        // untrue, then keep incrementing on the right pointer

        if (s.length() == 1) {
            return 1;
        }

        int maxLen = 1;
        int left = 0;
        int maxFreq = 1;

        int[] count = new int[26];

        // s will have len = 2 min
        for (int right = 0; right < s.length(); right++) {
            // build a freq map of chars in s
            int index = s.charAt(right) - 'A';
            count[index]++;
            
            // update maxFreq based on the new char added
            maxFreq = Math.max(maxFreq, count[index]);

            while ((right - left + 1) - maxFreq > k) { // means impossible
                count[s.charAt(left) - 'A']--; // -1 freq of char at left
                left++; // shrink window

                int max = 0; 

                for (int x : count) { // calculate new maxFreq (incase changed)
                    max = Math.max(max, x);
                }

                maxFreq = max;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
