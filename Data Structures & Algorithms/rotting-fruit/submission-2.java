class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        // fresh touching rotten -> become rotten -> enter the queue
        // take snapshot of rotten fruits in this min
        // loop through queue (first rotten.size() elements) 
        // take the initial rotten fruits in the grid and add to queue
        int fresh = 0; 
        int min = 0; 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // if the fruit is fresh
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten.offer(new int[] {i,j});
                }
            }
        }

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while (fresh > 0 && !rotten.isEmpty()) {
            int size = rotten.size();

            for (int i = 0; i < size; i++) {
                // taking elements from the queue that applies to this min
                int[] rottenFruit = rotten.poll();
                int row = rottenFruit[0];
                int col = rottenFruit[1];

                // checking in all four directions if we can spread rotten
                for (int[] dir : directions) {
                    int newRow = dir[0] + row;
                    int newCol = dir[1] + col;

                    if (newRow < 0 || newRow >= grid.length ||
                        newCol < 0 || newCol >= grid[0].length ||
                        grid[newRow][newCol] != 1) {
                        continue;
                    } 

                    fresh--;
                    grid[newRow][newCol] = 2;
                    rotten.offer(new int[]{newRow,newCol});
                }
            }
            min++;
        }

        if (fresh > 0) {
            return -1;
        }

        return min;
    }
}
