class Solution {
    public int trap(int[] height) {

        // O(n) time complexity
        // O(1) space complexity
        // two pointer solution
        
        int area = 0;

        if (height.length == 1) {
            return area;
        }

        // track the max from each side
        // update when height[left/right] > maxLeft/Right
        // else, add it to the accumulated area
        // stop when left >= right

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left <= right) {
            if (maxLeft <= maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    area += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    area += maxRight - height[right];
                }
                right--;
            }
        }

        return area;
    }
}
