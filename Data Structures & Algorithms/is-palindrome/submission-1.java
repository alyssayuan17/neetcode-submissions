class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!isAlphanumeric(s.charAt(start)) &&
                !isAlphanumeric(s.charAt(end))) {
                start++;
                end--;
                continue;
            } else if (isAlphanumeric(s.charAt(start)) &&
                        !isAlphanumeric(s.charAt(end))) {
                end--;
                continue;
            } else if (!isAlphanumeric(s.charAt(start)) &&
                        isAlphanumeric(s.charAt(end))) {
                start++;
                continue;
            }

            if (Character.toLowerCase(s.charAt(start)) != 
                Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // O(1) helper function to check if it is (A-Z, a-z, 0-9)
    public boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9')) {
            return true;
        }

        return false;
    }
}
