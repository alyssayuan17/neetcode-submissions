class Solution {
    public int lastStoneWeight(int[] stones) {
        // maxheap is perfect for this, since we can poll twice
        // to get the two largest stones
        // if heap size == 0 -> return 0
        // if heap size == 1 -> return peek()
        // else, if there are at least 2 stones, compare:
        // - if x == y -> don't do anything, destroyed
        // - if x < y -> offer y - x
        // time: O(n), n is the numbers of stones in arr
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

            if (stone1 < stone2) {
                maxHeap.offer(stone2 - stone1);
            }
        }

        return 0; // none remain
    }
}
