class Solution {
    public int findMin(int[] nums) {
        // trivial solution is searching through nums[] for min
        // O(log n) solution entails binary search
        // notice that given a rotated arr, the greatest element
        // is now in the middle, meaning the smallest element is
        // the only element with both numbers to its left and right
        // greater than it, as opposed to left being smaller
        // [3,4,5,6 | 1,2]
        // - if mid > right, look at the right half
        //   since we know it is the half with the smaller elements
        // - if mid < right, we know the right half has the larger
        //   nums, so shrink to the left
        

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // since we know mid cannot be min now
            } else {
                right = mid;
            }
        }

        return nums[right];
    }
}
