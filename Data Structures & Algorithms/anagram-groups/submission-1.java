class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram_groups = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            char[] char_arr_str = s.toCharArray();
            for (char c : char_arr_str) {
                count[c - 'a']++;
            }
            // we don't need it to be a readable string that is stored
            String key = Arrays.toString(count);

            if (anagram_groups.containsKey(key)) {
                anagram_groups.get(key).add(s);
            } else {
                anagram_groups.put(key, new ArrayList<String>());
                anagram_groups.get(key).add(s);
            }
        }

        return new ArrayList<>(anagram_groups.values());
    }
}
