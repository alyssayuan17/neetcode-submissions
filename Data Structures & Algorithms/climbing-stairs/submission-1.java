class Solution {
    public int climbStairs(int n) {
        // combinations at each stair can only be from either taking 
        // one step from prev OR two steps from prev
        // OR rule, so add the two 
        // - notice this is the fibonacci sequence

        // keep an arr to keep track of combinations at every step
        int[] numSteps = new int[n + 1];

        numSteps[0] = 1; 
        numSteps[1] = 1;

        for (int i = 2; i <= n; i++) {
            numSteps[i] = numSteps[i - 1] + numSteps[i - 2];
        }

        return numSteps[n];
    }
}
