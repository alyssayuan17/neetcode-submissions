class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // (target - position) / speed = time to target
        // target = 10, p = [4, 2], s = [2, 4]
        // 3, 2
        // second car arrives faster, but because car 1 starts at 4
        // and is slower, once car 2 reaches car 1, must slow to car1
        // speed -> becomes one fleet
        // compare time to target -> consider:
        // - if two cars arrive at the same time
        // - if a car has a faster time to target but is behind 
        //   a slower car
        // - if each position arrives in order (an earlier 
        //   positioned car arrives quicker)
        // car 3 [0] -- car 2 [1] --- car 1 [4] --- car 4 [7] --- tar
        // 3, 4.5, 10, 3
        // 10, 4.5, 3, 3 -- tar
        // - push 10 to stack
        // - see 4.5, compare 4.5 />= 10 -> push 4.5
        // - see 3, compare 3 />= 4.5 -> push 3
        // - see 3, compare 3 >= 3 -> pop 3 -> push 3
        // -> return stack.size() -> return 3
        // if we had 4.5, 10, 3, 3 -- tar
        // - push 4.5 to stack
        // - see 10, compare 10 >= 4.5 -> pop 4.5 -> push 10
        // - see 3, compare 3 />= 10 -> push 3
        // - see 3, compare 3 >= 3 -> pop 3 -> push 3
        // -> our final stack.size() is our # of fleets -> return 2

        // create a sorted arr of indices based on positions
        Integer[] indices = new Integer[position.length];

        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // sort indices arr based on positions arr -> ascending
        Arrays.sort(indices, (a, b) -> 
            Integer.compare(position[a], position[b]));
        
        Deque<Double> stack = new ArrayDeque<>();

        // iterate on indices arr -> calculate time to tar for each
        for (int i = 0; i < indices.length; i++) {
            double timeToTarget = (double) (target - position[indices[i]]) / speed[indices[i]];
            
            while (!stack.isEmpty() && timeToTarget >= stack.peek()) {
                stack.pop();
            }
            // 5, 2.6, 6
            stack.push(timeToTarget);
        }

        return stack.size();
    }
}
