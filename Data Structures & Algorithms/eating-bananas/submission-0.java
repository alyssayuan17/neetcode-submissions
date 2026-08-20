class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // notice that the minimum k is 1, and the max k
        // is the max in piles[], since there is no purpose in 
        // eating more than the largest pile in one hour
        // between: 1 and max pile
        // we could binary search on this range to find out if
        // a given k allows us to finish all bananas within h
        // - if hours taken > h, move left = mid + 1
        // - if hours taken <= h, store min k and move right = mid - 1
        // - return k
        int minK = Integer.MAX_VALUE;

        // find max first
        int maxK = 0;

        for (int i = 0; i < piles.length; i++) {
            maxK = Math.max(maxK, piles[i]);
        }

        int left = 1; 
        int right = maxK;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (validK(piles, mid, h) == true) {
                minK = Math.min(minK, mid);
                right = mid - 1;
            } else if (validK(piles, mid, h) == false) {
                left = mid + 1;
            }
        }

        return minK;
    }

    // O(n) time helper function to determine if a k val
    // is valid a.k.a allows us to finish bananas in h time
    public boolean validK(int[] piles, int k, int h) {
        int hours = 0; // hours variable to compare with h

        for (int i = 0; i < piles.length; i++) {
            hours += (int) Math.ceil((double) piles[i] / k);
        }

        return hours <= h;
    }
}
