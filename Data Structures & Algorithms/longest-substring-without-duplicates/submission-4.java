class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window:
        // - move right pointer only
        // - add each new char to seen set
        // - if duplicate, remove from the left side (left++)
        //   until the duplicate is gone from the set
        // - continue and return maxLen


        int maxLen = 0; 
        int left = 0;

        char[] sCharArr = s.toCharArray();

        Set<Character> seen = new HashSet<>();

        for (int right = 0; right < sCharArr.length; right++) {
            char current = sCharArr[right];

            while(seen.contains(current)) {
                seen.remove(sCharArr[left]);
                left++; // keep removing from the left until dup is gone
            }

            seen.add(sCharArr[right]);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
