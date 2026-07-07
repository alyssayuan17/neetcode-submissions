class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram_groups = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // we don't need it to be a readable string that is stored
            String key = Arrays.toString(count);

            anagram_groups.putIfAbsent(key, new ArrayList<>());
            anagram_groups.get(key).add(s);
        }

        return new ArrayList<>(anagram_groups.values());
    }
}
