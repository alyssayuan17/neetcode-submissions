class KthLargest {

    // can solve this in two ways:
    // 1. sorting nums[], then finding kth largest via iteration
    //      time: O(n logn), n = nums length
    //      space: O(n), ArrayList to store nums that we add
    // 2. using a priorityqueue -> minHeap
    //      maintain k elements in our PQ -> smallest is kth largest
    //      time: O(logk), each insertion + poll is O(logk) time
    //      space: O(k), k elements in priority queue
    //      note: heap never grows over k + 1 elements

    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        // we want to maintain k elements in our priority queue
        // offer val into our priority queue
        // check if length > k, remove the smallest element -> poll()
        //   to ensure our heap always contains the k largest elements
        // once we are done adding, return the peek() result

        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
