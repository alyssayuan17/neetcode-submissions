class Solution {
    public int leastInterval(char[] tasks, int n) {
        // given a list of tasks, execute the highest frequency task first
        // to reduce cycles required due to cooldown
        // the maxheap only contains the tasks we are executing based on frequency
        // execute in that order: highest -> second highest -> ...
        // when in cooldown, keep in a queue -> <int[] {freq, abs time it can run again}
        // NOTE: we always want to run the highest freq task available next
        // each iteration, first check:
        // - if the first element in the queue has time = curr time, add to heap
        // - elements in queue should be in execution order, since we added new elements
        //   to the back
        // - if heap is not empty, poll 
        // - else, don't do anything
        // - time++
        // Time: O(n logn) -> worst case heap size is n = # of tasks, 
        //       poll/insert for each
        // Space: O(n) -> O(n) for heap, O(n) for queue

        int minTime = 0;
        // since we don't care which task is which, only freq and when it can be 
        // executed, just store each task's frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> cooldownQueue = new ArrayDeque<>();

        // start by populating maxHeap with task frequencies
        // since A-Z, use a freq arr to store all frequencies of tasks
        int[] tasksFreq = new int[26];
        for (char task : tasks) {
            tasksFreq[task - 'A']++;
        }

        // add to maxHeap
        for (int i = 0; i < tasksFreq.length; i++) {
            if (tasksFreq[i] > 0) {
                maxHeap.offer(tasksFreq[i]);
            }
        }

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] <= minTime) {
                maxHeap.offer(cooldownQueue.peek()[0]); // offer the freq
                cooldownQueue.poll();
            }

            if (!maxHeap.isEmpty()) { 
                // maxHeap is only concerned with tasks that are READY to run
                int currTaskFreq = maxHeap.poll();
                currTaskFreq--;

                if (currTaskFreq > 0) {
                    // if freq isn't 0, add back into queue
                    int nextValidTime = minTime + n + 1;
                    cooldownQueue.offer(new int[] {currTaskFreq, nextValidTime});
                }
            }

            // else, leave idle -> don't do anything

            minTime++;
        }

        return minTime;
    }
}
