class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> seen = new HashMap<>();

        List<List<String>> grouped_anagrams = new ArrayList<>();

        if (strs.length == 0) {
            return grouped_anagrams;
        }

        for (int i = 0; i < strs.length; i++) {
            boolean isAdded = false;
            
            int j;

            for (j = 0; j < grouped_anagrams.size(); j++) {
                List<String> curr_group = grouped_anagrams.get(j);;
                if (isAnagram(strs[i], curr_group.get(0))) {
                    curr_group.add(strs[i]);
                    isAdded = true;
                }
            }

            if (isAdded == false) {
                grouped_anagrams.add(new ArrayList<>());
                grouped_anagrams.get(j).add(strs[i]);
            }
        }

        return grouped_anagrams;
    }

    public boolean isAnagram(String str1, String str2) {
        char[] str1_arr = str1.toCharArray();

        Arrays.sort(str1_arr);

        char[] str2_arr = str2.toCharArray();

        Arrays.sort(str2_arr);

        return Arrays.equals(str1_arr, str2_arr);
    }
}
