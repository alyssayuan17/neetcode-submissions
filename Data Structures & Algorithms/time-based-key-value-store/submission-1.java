class TimeMap {

    private HashMap<String, List<Entry>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(timestamp, value);

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(entry);
    }
    
    // we want to find the largest possible timestamp for this key
    // that satisfies t <= timestamp
    // the brute force solution is to search through every entry in the 
    // hashmap until we find the greatest timestamp that satisfies
    // we can use binary search to achieve O(log n) time
    // - use binary search for the list of entries for each key to find
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Entry> entries = map.get(key);
        // since arraylist preserves insertion order, and timestamps
        // are in strictly increasing order, we can use simple binary
        // search

        int left = 0;
        int right = entries.size() - 1;
        int maxTimestamp = 0;
        String toReturn = "";
        // [ 1, 4, 5, 7, 9 ]
        while (left <= right) {
            int mid = (left + right) / 2;
            int midTimestamp = entries.get(mid).getTimestamp();

            if (midTimestamp <= timestamp) {
                maxTimestamp = midTimestamp;
                toReturn = entries.get(mid).getValue();
                // no use in searching to the left, since we know
                // the timestamps will be smaller
                left = mid + 1;
            } else { // midTimestamp > timestamp
                // must search to the left
                right = mid - 1;
            }
        }

        return toReturn;
    }
}

// use new object to store timestamp-value pair
class Entry {
    int timestamp;
    String value;

    Entry(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getValue() {
        return value;
    }
}
