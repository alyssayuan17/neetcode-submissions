class Solution {
    public int maxArea(int[] heights) {
        // consider edge cases:
        // [1,2] -> only two elements, return 
        // [2,2,2,2] -> all the same val, return first element x last for max
        // 0 x anything = 0, never the answer unless [0,0,...,0] all zero

        // [1,7,2,5,4,7,3,6]

        // when taking area, must take min(heights[left], heights[right])
        // the width is right - left
        // area = min(heights[left], heights[right]) x (right - left)
        // check if area = min(heights[left++], heights[right]) x (right - left++)
        // or area = min(heights[left], heights[right--]) x (right-- - left)
        // or area = min(heights[left++], heights[right--]) x (right-- - left++)
        // is larger, if so, proceed with left++, right--, or left++ & right--
        // continue the loop
        // while (left < right)
        // return area

        // O(n) time since we iterate through each val in the arr exactly once

        int left = 0;
        int right = heights.length - 1;

        int max_area = 0;

        while(left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            
            max_area = Math.max(area, max_area);

            if (heights[left] > heights[right]) {
                right--; 
                continue;
            }

            if (heights[left] < heights[right]) {
                left++;
                continue;
            }

            // otherwise if they are equal, check the next element
            if (heights[left] < heights[left + 1]) {
                left++;
                continue;
            } 

            if (heights[right] > heights[right - 1]) {
                right--;
                continue;
            }

            // else, if both are equal, increment both
            left++;
            right--;
        }

        return max_area;
    }
}
