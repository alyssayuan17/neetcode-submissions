class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // given points, we want to store the coordinates based on 
        // distance to origin
        // no need to check equal distances at the cutoff
        //      -> uniqueness guaranteed
        // but we want to know the k closest points, so we want the 
        // top k shortest distances
        // - goal: offer into maxHeap with their caluclated distances
        // - maxHeap stores k of object type int[]
        //      - use lambda function (p1,p2) -> 
        //        Integer.compare(sqrt(p2[0]^2 + p2[1]^2), 
        //                            sqrt(p1[0]^2 +p1[1]^2));
        // Time: O(nlogn) -> each node is polled/offered once
        // Space: O(k) -> heap stores maximum k + 1 pairs at any time

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1,p2) ->               Double.compare(Math.sqrt(p2[0]*p2[0] + p2[1]*p2[1]),
                                Math.sqrt(p1[0]*p1[0] + p1[1]*p1[1])));
        
        // maxHeap discards the largest value on the fly as we add new
        int[][] kClosest = new int[k][2]; // k pairs

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest
            }
        }

        // build kClosest with finished maxHeap
        for (int i = 0; i < kClosest.length; i++) {
            int[] p = maxHeap.poll();
            kClosest[i] = p;
        }

        return kClosest;
    }
}
