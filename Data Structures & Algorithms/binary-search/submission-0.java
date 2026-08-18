class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
        
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // target must be between left and mid
                right = mid - 1;
                continue;
            } else {
                // target must be between mid and right
                left = mid + 1; 
                continue;
            }
        }

        // if we dont find any mid to return, return -1
        return -1;
    }
}
