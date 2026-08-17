class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // O(n) time, O(n) space
        // use a stack to keep track of the indicies of 
        // the highest temperatures
        // when we see a temp lower than stack.peek, push to stack
        // when we see a temp higher than stack.peek, pop from stack
        // and compute the val for that index (curr - stack.pop)
        // continue checking if !stack.isEmpty && curr > stack.peek 
        // (new) and do the same until untrue
        // push new curr onto stack 
        // continue iterating
        // after exiting loop, if stack is not empty, just fill
        // everything at the remaining indices with 0 

        Deque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];

            while (!stack.isEmpty() && 
                    currentTemp > temperatures[stack.peek()]) {
                int oldTop = stack.pop();
                result[oldTop] = i - oldTop; // store index
            } 

            stack.push(i);
        }

        // fill out everything remaining from stack, meaning
        // there is no more higher temp days
        while(!stack.isEmpty()) {
            int popped = stack.pop();
            result[popped] = 0;
        }

        return result;
    }
}
