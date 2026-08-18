class Solution {
    public int largestRectangleArea(int[] heights) {
        // the brute force solution would be to implement
        // two pointers for each heights[i] until we find a bar
        // from either side that is shorter than heights[i], 
        // and take area as heights[i] * (right - left + 1) 
        // and keep taking Math.max(maxArea, area)
        // however, this is quite costly, having O(n^2) time
        // consider using a stack to achieve O(n) time O(n) space
        // - store pairs in a stack: <leftmost index, height>
        // - keep pushing to our stack when the bar we see is >=
        //   the stack.peek()
        // - stack.pop() when the curr bar we see is < the prev
        //   stack.peek(), starting with the curr bar's index
        //   and set leftmostIndex of the current one to the latest
        //   one we just poppe from the stack
        //   since this becomes how far left we can extend
        // - when we pop, we compare the current greatest area
        //   that bar can give us, by taking their 
        //      height * i - leftmost index

        Deque<int[]> stack = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftmostIndex = i;
            
            while (!stack.isEmpty() && 
                    heights[i] < stack.peek()[1]) {
                int[] popped = stack.pop();
                int poppedLeft = popped[0];
                int poppedHeight = popped[1];
                maxArea = Math.max(maxArea, 
                                poppedHeight * (i - poppedLeft));
                leftmostIndex = poppedLeft;
            }

            stack.push(new int[] {leftmostIndex, heights[i]});

            // e.g.
            // push [0,7]
            // pop [0,7] -> push [0,1]
            // push [2,7]
            // pop [2,7] -> push [2,2]
            // push [4,2]
            // push [5,4]

            // curr stack: 
            // top: [5,4] -- [4,2] -- [2,2] -- [0,1]
        }

        // once exit for loop, need to take area of remaining
        // items in stack
        for (int[] pair : stack) {
            int width = heights.length - pair[0];
            int height = pair[1];

            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}
