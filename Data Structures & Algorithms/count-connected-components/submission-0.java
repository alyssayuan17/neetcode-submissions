class Solution {
    // consider n = 0
    // n = 5, edges = [] -> return 5
    // map:
    // < 0, <1>>
    // < 1, <2>>
    // < 2, <0,3>> 
    // < 3, <4>>
    // -> returns 2
    // time: O(m) -> m = # of edges
    // space: O(n * m) -> n nodes, m length of relationships for each

    HashMap<Integer, List<Integer>> relationships = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        int count = 0;
        // build hashmap relationships
	    for (int i = 0; i < edges.length; i++) {
		    int key = edges[i][0];
            int val = edges[i][1];
                
            if (relationships.containsKey(key)) {
                relationships.get(key).add(val);
            } else {
                relationships.put(key, new ArrayList<>());
                relationships.get(key).add(val);
            }

            // build reverse direction
            if (relationships.containsKey(val)) {
                        relationships.get(val).add(key);
            } else {
                relationships.put(val, new ArrayList<>());
                relationships.get(val).add(key);
            }
        }

        // iterate through every key value 
        // - check if it's in seen
        // - if not -> dfs
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                dfs(i); // mark all connected nodes as seen
                count++;
            }
        }

        return count;

    }

    // only call -> if not seen
    public void dfs(int n) {
        // base case 1: if n is not in map -> return
        if (!relationships.containsKey(n)) {
            return;
        } 

        // base case 2: cycle -> seen contains n 
        if (seen.contains(n)) {
            return;
        }

        // put n in seen
        seen.add(n);
        
        // loop through the list of relationships for n 
        // - call dfs on every node in relationship
        List<Integer> related = relationships.get(n);
        for (int i = 0; i < related.size(); i++) {
            dfs(related.get(i));
        }
    }
}
