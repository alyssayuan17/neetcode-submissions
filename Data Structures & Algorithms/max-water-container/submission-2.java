class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int max_area = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);

            max_area = Math.max(area, max_area);

            // determine the restricting height, and increment that one
            // otherwise, moving the taller bar can never improve the area
            // since the dimension is determined by the smaller bar
            // if left is the shorter one, increment left
            // else, if right is shorter or left and right are equal, 
            // it doesn't matter which pointer we increment because it would be
            // limited by the same height anyway
            if (heights[left] < heights[right]) {
                left++;
                continue;
            } else {
                right--;
                continue;
            }
        }

        return max_area;
    }
}
