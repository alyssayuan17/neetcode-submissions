class Solution {
    public int orangesRotting(int[][] grid) {
    
        ArrayDeque<int[]> queue = new ArrayDeque<>();
	    int numFresh = 0;
	    for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[0].length; j++) {
			    if (grid[i][j] == 1) {
				    numFresh++;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        } // should have numFresh and all current rotten fruits queued

        // store all directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int mins = 0;

        while (!queue.isEmpty() && numFresh > 0) {
            int size = queue.size();
        
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] dir : directions) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];
                    if (newRow >= 0 && newRow < grid.length && 
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[cell[0] + dir[0]][cell[1] + dir[1]] == 1) {
                        
                        grid[newRow][newCol] = 2;
                        numFresh--;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            mins++;
        }

        if (numFresh > 0) {
            return -1;
        }

        return mins;
    }
}
