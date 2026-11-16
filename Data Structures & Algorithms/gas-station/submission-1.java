class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // notice that if the current net total gas[i] - cost[i]
        // is negative, it means it is impossible for this one
        //  -> move to the next index
        //  -> reset current net total to 0 and continue
        // when total net gas - cost is negative, it must mean it is
        // impossible to complete a full circle -> return -1

        int runningTotal = 0;
        int finalTotal = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            finalTotal += diff;
            runningTotal += diff;

            if (runningTotal < 0) {
                runningTotal = 0;
                start = i + 1;
            }
        }

        return (finalTotal < 0) ? -1 : start;
    }
}
