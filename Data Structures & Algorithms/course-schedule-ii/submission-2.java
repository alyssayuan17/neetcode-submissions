class Solution {

    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> visiting = new HashSet<>();
    HashMap<Integer, List<Integer>> relationships = new HashMap<>();
    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build hashmap -> relatioships in the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            if (relationships.containsKey(course)) {
                relationships.get(course).add(prereq);
            } else {
                relationships.put(course, new ArrayList<>());
                relationships.get(course).add(prereq);
            }
        }

        int[] toReturn = new int[numCourses];
                    
        // iterate through 0 - (numCourses - 1) -> call dfs on prereq 
        for (int i = 0; i < numCourses; i++) {
            // if course is not in visited call dfs
            if (!visited.contains(i)) {
                if (!dfs(i, toReturn)) {
                    return new int[0];
                }
            }
        }

        return toReturn;

    }

    public boolean dfs(int course, int[] toReturn) {
	    // base case 1: visiting contains course -> cycle -> return false
	    if (visiting.contains(course)) {
		    return false;
        }
	    // base case 2: visited contains course -> add to toReturn -> return true
	    if (visited.contains(course)) {
		    return true;
        }

        visiting.add(course);

        // call dfs on course 
	    // iterate on course's prereqs -> dfs on each
        if (relationships.containsKey(course)) {
            List<Integer> prereqs = relationships.get(course);
            for (int prereq : prereqs) {
                if (!dfs(prereq, toReturn)) {
                    return false;
                }
            }
        }
        
        visited.add(course);
        visiting.remove(course);
        
        toReturn[index] = course; 
        index++;
        return true;
    }
}
