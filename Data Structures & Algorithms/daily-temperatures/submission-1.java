class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // O(n) time, O(n) space
        // use a stack to keep track of the indicies of days
        // that have not found a warmer future day yet
        // when we see a temp lower than stack.peek, push to stack
        // when we see a temp higher than stack.peek, pop from stack
        // and compute the val for that index (curr - stack.pop)
        // continue checking if !stack.isEmpty && curr > stack.peek 
        // (new) and do the same until untrue
        // push new curr onto stack 
        // continue iterating 

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

        return result;
    }
}
