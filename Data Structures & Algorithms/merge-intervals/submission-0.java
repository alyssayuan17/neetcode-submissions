class Solution {
    public int[][] merge(int[][] intervals) {
        // track the start -> for each interval to be added
        // track the end -> max seen thus far
        // stop when index 0 of a new interval is greater than the max 
        // time: O(nlogn) 
        // space: O(n) -> n = num of intervals

        // create copy 
	    int[][] copy = new int[intervals.length][];
    
        for (int i = 0; i < intervals.length; i++) {
            copy[i] = intervals[i].clone();
        }

        // sort intervals
        Arrays.sort(copy, Comparator.comparingInt(row -> row[0]));

        int start = copy[0][0];
        int end = copy[0][1]; 

        ArrayList<int[]> toReturn = new ArrayList<>();
        // [1, 2] and [3, 4] - > [1, 2] and [3, 4]
        // for loop through sorted arr
        for (int i = 1; i < copy.length; i++) {
            int[] interval = copy[i];
            // track the start + end
            // each iteration check if index 0 of curr interval is greater than // end
            // - if so -> append [start, end] 
            // - reset 
            int currStart = interval[0];
            int currEnd = interval[1];

            if (currStart <= end) {
                end = Math.max(end, currEnd); 
            } else {
                toReturn.add(new int[] {start, end});
                start = currStart;
                end = currEnd;
            }
            // [1, 4] [1, 2], [7, 8]
            // [1,2],[1,4],[7,8]
        }

        toReturn.add(new int[] {start, end});
        
        return toReturn.toArray(new int[0][]);
    }
}
