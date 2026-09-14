class Solution {
    public int findDuplicate(int[] nums) {
        // linked list solution 
        // time: O(n) time, extra space: O(1)
        // cannot modify (sort) nums
        
        // Treat the array as a LinkedList: notice that since   
        // the values in the array are between [1, n] and there 
        // are n + 1 integers, we can treat the value at the 
        // index as the “next”, and we can hop to the num at    
        // that index
        // When there is a duplicate, we will cause a cycle
        // - First time fast and slow pointers intersect 
        // indicates a point in the cycle
        // - Second time, using two slow pointers: one starting 
        // at the beginning of the entire arr and the other 
        // starting at the intersection

        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // once exited, we know slow = fast, so we are at the 
        // first intersection
        int start = nums[0]; // new pointer that starts at beg.

        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }

        return slow;
    }
}
