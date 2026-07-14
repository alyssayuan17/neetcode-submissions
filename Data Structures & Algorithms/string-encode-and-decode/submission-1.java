class Solution {

    // "5|Hello5|World"

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();
        
        for (String str : strs) {
            encoded.append(str.length()).append("|").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        
        List<String> decoded = new ArrayList<>();

        int i = 0;

        while(i < str.length()) {
            int separator = i; 

            while(str.charAt(separator) != '|') {
                separator++;
            }

            int len = Integer.parseInt(str.substring(i, separator));

            int word_start = separator + 1;
            int word_end = word_start + len;

            decoded.add(str.substring(word_start, word_end));

            i = word_end;
        }

        return decoded;
    }
}
