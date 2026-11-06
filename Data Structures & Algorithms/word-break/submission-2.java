class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // use dp to store whether a word can be formed at this curr index
        // bottom-up dp -> return dp[s.length()] 
        // for each letter, scan through all dict words and check if 
        // any of them make it true at that point 
        // if starts with a word in the dict, we also need to know that 
        // dp[i - word.length()] is true -> valid up until this point 
        // time: O(c * w * L) -> c = chars in string, w = words in dict, 
        //                          L = length of word
        // space: O(c) -> at each index bool val is stored once

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() &&
                        dp[i - word.length()] && 
                        s.startsWith(word, i - word.length())) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
