class Solution {
    public int search(int[] nums, int target) {
        // target: 2
        // [3,4,5,6|1,2] -> mid = 5
        // [1,2,3,4,5,6] -> mid = 3
        // [5,6|1,2,3,4] -> mid = 1
        // trivial solution is looping through arr to find target, O(n)
        // O(log n) -> use binary search

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid; 
            } 
            
            // check if right is sorted first
            if (nums[mid] < nums[right]) {
                // then check if target is in this range 
                if (target < nums[mid] || target > nums[right]) { 
                    // target not in this range
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // left half is sorted instead
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
