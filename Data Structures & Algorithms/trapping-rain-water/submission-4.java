class Solution {
    public int trap(int[] height) {
        // when finding area of water at each index, we 
        // need to find the tallest bar from both the left
        // and right sides, and the water level is determined
        // by the minimum

        // find max from right and max from left at each point
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];

        maxRight[height.length - 1] = height[height.length - 1];
        maxLeft[0] = height[0];

        // [0,2,2,3,3,3,3,3,3,3]
        // [3,3,3,3,3,3,3,3,2,1]

        // loop from left side to collect maxLeft at each index
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        // same for right, just reverse
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        // now loop through height to add up area
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(maxLeft[i], maxRight[i]);
            area += waterLevel - height[i];
        }

        return area;
    }
}
