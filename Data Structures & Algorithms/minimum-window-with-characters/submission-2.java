class Solution {
    public String minWindow(String s, String t) {
        // create a freq arr containing all chars, freq for t 
        // minLen to track the minimum length of substring
        // use a sliding window to look at a window in s
        // keep expanding window until every char in t is present 
        // in the window. while the char at the left pointer
        // is not in t, shrink from left pointer
        // at this point, both left and right pointers are at a char
        // that is a part of t
        // take minLen = Math.min(minLen, len) then subtract 1 from len,
        // remove charAt(left) from freq arr we made (for windows in s),
        // and shrink left pointer by 1, continue iterating on right++

        int[] freqT = new int[52]; // both upper and lower case

        for (int i = 0; i < t.length(); i++) {
            if (Character.isLowerCase(t.charAt(i))) {
                int index = t.charAt(i) - 'a';
                freqT[index]++;
            } else {
                int index = t.charAt(i) - 'A' + 26;
                freqT[index]++;
            }
        }

        int[] count = new int[52];

        int left = 0;
        int need = t.length();
        int have = 0; 
        int minStart = left;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            if (Character.isLowerCase(s.charAt(right)) &&
                freqT[s.charAt(right) - 'a'] > 0) {
                int index = s.charAt(right) - 'a';
                count[index]++;
                if (count[index] <= freqT[index]) { // is this copy needed
                    have++;
                }
            } else if (Character.isUpperCase(s.charAt(right)) &&
                        freqT[s.charAt(right) - 'A' + 26] > 0) {
                int index = s.charAt(right) - 'A' + 26;
                count[index]++;
                if (count[index] <= freqT[index]) { // is this copy needed
                    have++;
                }
            }
            
            while(left <= right && have == need) {
                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    minStart = left;
                }

                if (Character.isLowerCase(s.charAt(left)) && 
                    freqT[s.charAt(left) - 'a'] > 0) {
                    int leftIndex = s.charAt(left) - 'a';
                    count[leftIndex]--;
                    if(count[leftIndex] < freqT[leftIndex]) {
                        have--;
                    }
                } else if (Character.isUpperCase(s.charAt(left)) && 
                            freqT[s.charAt(left) - 'A'+ 26] > 0){
                    int leftIndex = s.charAt(left) - 'A' + 26;
                    count[leftIndex]--;
                    if(count[leftIndex] < freqT[leftIndex]) {
                        have--;
                    }
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }
}
