class Solution {
    public int lastStoneWeight(int[] stones) {
        // maxheap is perfect for this, since we can poll twice
        // to get the two largest stones
        // if heap size == 0 -> return 0
        // if heap size == 1 -> return peek()
        // else, if there are at least 2 stones, compare:
        // - if x == y -> don't do anything, destroyed
        // - if x > y -> offer x - y
        // time: O(nlogn), go through each stone and poll/offer (logn)
        // space: O(n), since we are storing all stones in heap

        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }

        while (maxHeap.size() > 0) {
            if (maxHeap.size() == 1) {
                return maxHeap.peek();
            }

            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            } 
            // since stone1 was polled first, it must be either
            // greater than or equal to stone2
            // do nothing if they are equal
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek(); // none remain
    }
}
