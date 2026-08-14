class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // k = right - left + 1
        // could use a deque <integer>, storing indices
        // increment on right pointer
        // every time, we add the new num at right pointer
        // to our deque
        // check this new num against .peekLast, if smaller,
        // add to it. else, if larger, remove .pollLast until 
        // untrue, this way, we preserve a constantly decreasing
        // order deque (and we can take .peekFirst for our max)
        // when window len > k, then we move our left++
        // when we move our left, check if .peekFirst
        // in the deque is < left, if so, remove. else, keep.
        // take max of the curr window as deque.peekFirst
        
        // the rule is, len of maxes is nums.length - k + 1
        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;

        int counter = 0;

        for (int right = 0; right < nums.length; right++) {
            while(!deque.isEmpty() && 
                    nums[right] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            if (right - left + 1 > k) {
                left++;
                while (!deque.isEmpty() && deque.peekFirst() < left) {
                    deque.pollFirst();
                }
            }

            if (right - left + 1 == k) {
                maxes[counter] = nums[deque.peekFirst()];
                counter++;
            }
        }

        return maxes;
    }
}
