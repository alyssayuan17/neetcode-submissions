class Solution {
    public int findKthLargest(int[] nums, int k) {
        // more efficient solution
        // use a minHeap -> keep k elements in it at all times
        // once we finish offering every element, the first element
        // in the heap is the kth largest
        //      - we keep only the largest elements, but since we
        //          only keep k elements, the smallest of the 
        //          k elements must be the kth largest
        // Time: O(n logk), each operation is O(logk) time instead,
        //          since heap only contains k elements
        // Space: O(k), heap contains k + 1 elements at most

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the smallest element
            }
        }

        return minHeap.peek();
    }
}
