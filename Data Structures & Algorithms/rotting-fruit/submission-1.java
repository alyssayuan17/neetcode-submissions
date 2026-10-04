class Solution {
    public int orangesRotting(int[][] grid) {
        // notice: one BFS level = one minute
        // multiple rotten fruits -> put all initially rotten fruits
        // into the queue before BFS starts
        // fresh fruit -> fresh-- -> this one gets spread next min

        Queue<int[]> rottenQueue = new LinkedList<>();
        int fresh = 0;
        int mins = 0;

        // find all initially rotten fruit and count fresh fruit
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        // if there is still fresh fruit + queue isn't empty, continue
        while (!rottenQueue.isEmpty() && fresh > 0) {

            // take the size of queue for THIS MINUTE ONLY
            int size = rottenQueue.size();

            for (int i = 0; i < size; i++) {
                // take the items in the queue
                int[] rottenFruit = rottenQueue.poll();
                int row = rottenFruit[0];
                int col = rottenFruit[1];

                // try spreading in all four directions
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // check if invalid new coordinates
                    if (newRow < 0 || newRow >= grid.length ||
                        newCol < 0 || newCol >= grid[0].length ||
                        grid[newRow][newCol] != 1) {
                        // if not fresh, don't make rotten
                        continue;
                    }

                    // at this point -> must be fresh fruit
                    grid[newRow][newCol] = 2;
                    fresh--; 
                    // add to queue -> can be spread next min
                    rottenQueue.add(new int[]{newRow, newCol});
                }
            }
            mins++;
        }

        // check if fresh fruit remains -> if so, we couldn't reach it,
        // so return -1
        if (fresh > 0) {
            return -1;
        }

        return mins;
    }
}
