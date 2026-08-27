class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // brute force solution is to construct the merged array,
        // but this would take O(n * m) time worst case
        // consider finding a partition point such that we don't need
        // to merge the arrays to find where the median would be
        // [3|4,8] -> aLeft = 4, aRight = 8
        // [1,2,5|7,9] -> bLeft = 5, bRight = 7
        // - aLeft <= bRight
        // - bLeft <= aRight
        // these two above conditions to ensure valid
        // - find half of total number of elements to determine where
        //   middle should be
        // - cutB = half - cutA

        // binary search on the shorter array to ensure the nums1 is always
        // the smaller arr
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;
        int half = (nums1.length + nums2.length + 1) / 2;
        double result = 0;

        while (left <= right) {
            int cutA = (left + right) / 2;
            int cutB = half - cutA; 

            int aLeft;
            int aRight;
            int bLeft;
            int bRight;

            // boundary checks for when the separator is on the edges 
            if (cutA == 0) {
                aLeft = Integer.MIN_VALUE;
            } else {
                aLeft = nums1[cutA - 1];
            }

            if (cutB == 0) {
                bLeft = Integer.MIN_VALUE;
            } else {
                bLeft = nums2[cutB - 1];
            }

            if (cutA == nums1.length) {
                aRight = Integer.MAX_VALUE;
            } else {
                aRight = nums1[cutA];
            }

            if (cutB == nums2.length) {
                bRight = Integer.MAX_VALUE;
            } else {
                bRight = nums2[cutB];
            }

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(aLeft, bLeft);
                }
                int medianLeft = Math.max(aLeft, bLeft);
                int medianRight = Math.min(bRight, aRight);
                return (medianLeft + medianRight) / 2.0;
            } else if (aLeft > bRight) {
                // if the num left of separater in A, we need to shrink
                // to the left
                right = cutA - 1;
            } else {
                // if the num right of of cutA is less than the num left of 
                // cutB, shrink to the right
                left = cutA + 1;
            }
        }

        return 0.0;
    }
}
