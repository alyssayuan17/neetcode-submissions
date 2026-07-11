class Solution {

    // e.g. "5|Hello" "5|World"

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length()).append('|').append(str);
        }

        return encoded.toString();
    }

    // e.g. "5|Hello5|World"

    public List<String> decode(String str) {
        
        List<String> decoded = new ArrayList<>();

        int i = 0;

        // extract the length of the next word we need

        while (i < str.length()) {

            int separator = i;
            
            while(str.charAt(separator) != '|') {
                separator++;
            }

            int len = Integer.parseInt(str.substring(i, separator));

            int word_start = separator + 1;
            int word_end = word_start + len;

            decoded.add(str.substring(word_start, word_end));

            i = word_end; // word_end is actually the index immediately after the last char
        }

        return decoded;
    }
}
