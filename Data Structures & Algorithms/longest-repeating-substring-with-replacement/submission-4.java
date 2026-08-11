class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window to iterate the string 
        // notice window length - maxFreq (char with the highest freq)
        // must be less than or equal to k for this substring to be possible
        // freq arr to track freqs per each window

        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;
        int [] freqArr = new int [26];

        for (int right = 0; right < s.length(); right++) {
            // increment on right
            int index = s.charAt(right) - 'A'; // the current char
            freqArr[index]++;
            // update maxFreq incase this changed the num of freqs
            maxFreq = Math.max(maxFreq, freqArr[index]);

            // if length of window - maxFreq > k, we must shrink 
            // window to be valid again
            while ((right - left + 1) - maxFreq > k) {
                freqArr[s.charAt(left) - 'A']--; 
                left++; // shrink window by moving left pointer

                // changing freqArr[left] might have changed maxFreq
                // so compute again
                int max = 0;
                for (int x : freqArr) {
                    max = Math.max(max, x);
                }

                maxFreq = max;
            }
            // once valid again, take len
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
