class Solution {
    HashSet<Integer> visited = new HashSet<>(); // satisfied
    HashSet<Integer> visiting = new HashSet<>(); 
    HashMap<Integer, List<Integer>> courses = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // only pairs
        // prereqs can have their own prereqs
        // need at lease one course with no prereq
        // each course can contain multiple prereqs -> [0,1], [0,2]
        // time: O(V + E) -> each course visited once, each connection explored once
        // space: O(V) -> each course stored once 
        
        // first store all course-prereqs into hashmap
        // only courses with prereqs are stored
        for (int[] pair : prerequisites) {
            if (courses.containsKey(pair[0])) {
                courses.get(pair[0]).add(pair[1]);
            } else {
                List<Integer> prereqsList = new ArrayList<>();
                if (pair.length == 2) {
                    prereqsList.add(pair[1]);
                }
                courses.put(pair[0], prereqsList);
            }
        }

        // loop through each course (0 - (numCourses - 1)) 
        // if any of these calls return false -> return false

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        if (!courses.containsKey(course)) {
            return true; // meaning no prereqs
        }

        visiting.add(course);

        // else, process prereqs first
        List<Integer> listOfPrereqs = courses.get(course);

        for (int prereq : listOfPrereqs) {
            if (!dfs(prereq)) {
                return false;
            }
        }

        visiting.remove(course);
        visited.add(course);

        return true;
    }
}
