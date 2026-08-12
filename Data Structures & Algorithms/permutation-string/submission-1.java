class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // store s1 in a freq arr
        // use a sliding window, and note that the window length
        // must be s1.length 
        // if at a given window s1 freq arr = s2 freq arr, return true
        // if we exit the loop with no true, return false

        int[] freq_s1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            freq_s1[index]++;
        }
        
        int[] count = new int[26];

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            int index = s2.charAt(right) - 'a';
            count[index]++;

            // if window is larger than length of s1, move left pointer
            while (right - left + 1 > s1.length()) {
                count[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq_s1, count)) {
                return true;
            }
        }

        return false;
    }
}
