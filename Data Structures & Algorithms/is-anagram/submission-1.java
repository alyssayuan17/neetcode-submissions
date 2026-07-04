class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> chars = new HashMap<>();

        // loop through s and store all chars 
        for (int i = 0; i < s.length(); i++) {
            if (chars.containsKey(s.charAt(i))) {
                chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
                continue;
            } 
            chars.put(s.charAt(i), 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!chars.containsKey(t.charAt(i)) || (chars.get(t.charAt(i)) == 0)) {
                return false;
            }
            chars.put(t.charAt(i), chars.get(t.charAt(i)) - 1);
        }

        return true;
    }
}
