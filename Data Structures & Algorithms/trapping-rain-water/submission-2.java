class Solution {
    public int trap(int[] height) {
        // O(n) time complexity
        // O(n) space complexity

        // build an arr leftMax[] with all the maxes from the left
        // build an arr rightMax[] with all the maxes from the right
        // for loop through height[] to calculate the area
        // min(leftMax[i], rightMax[i]) - height[i]

        int area = 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        // build arr from the left side
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // build arr from the right side
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // go through height[] and calculate area using the left/right maxes
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            area += waterLevel - height[i];
        }

        return area;
    }
}
