class Solution {
    public boolean isPalindrome(String s) {
        // two pointers: one at beginning one at the end 

        int end = s.length() - 1;
        int start = 0;

        char[] char_arr = s.toCharArray();

        while (start < end) {
            if (!isAlphanumeric(char_arr[start]) && 
                !isAlphanumeric(char_arr[end])) {
                start++;
                end--;
                continue;
            } else if (!isAlphanumeric(char_arr[start]) &&
                        isAlphanumeric(char_arr[end])) {
                start++;
                continue;
            } else if (isAlphanumeric(char_arr[start]) &&
                        !isAlphanumeric(char_arr[end])) {
                end--;
                continue;
            } 

            if (Character.toLowerCase(char_arr[start]) != 
                Character.toLowerCase(char_arr[end])) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9')) {
            return true;
        }

        return false;
    }
}
