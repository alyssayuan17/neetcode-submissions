class Solution {
    HashMap<Integer, List<Integer>> courses = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // populate hashmap first
        for (int i = 0; i < numCourses; i++) {
            courses.put(i, new ArrayList<>());  
        }

        // add prereqs
        for (int[] pair : prerequisites) {
            courses.get(pair[0]).add(pair[1]);
        }

        // go through each pair
        // - if in visited, continue
        // - else, call dfs on this course and add to visiting
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                boolean result = dfs(i);
                if (!result) {
                    return false;
                }
            }
        }

        return true;
    }

    // dfs helper
    // base case: if course is in visiting, return false → cycle
    // 			if course is in visited, return true
    //			if courses.get(course) is null, return true

    public boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        visiting.add(course);

        // go through course’s list of prereqs
        List<Integer> coursePrereqs = courses.get(course);

        for (int prereq : coursePrereqs) {
            if (!dfs(prereq)) {
                return false;
            }
        }

        // else, remove course from visiting and add to visited
        // since successful
        visiting.remove(course);
        visited.add(course);

        return true;
    }

}
