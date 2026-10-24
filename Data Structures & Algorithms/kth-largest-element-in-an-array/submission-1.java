class Solution {
    public int findKthLargest(int[] nums, int k) {
        // brute force solution: sort -> take kth element
        // without sorting solution:
        // - store all into a maxHeap
        // - poll exactly k times
        // - return peek()
        // time: O(n logn) -> each element is polled/offered,
        //          each operation is O(logn) time
        // space: O(n) -> n elements in heap

        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int num : nums) {
            maxHeap.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
