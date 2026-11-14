class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // iterate each gas/cost val 
        // int start = 0; -> return 
        int start = 0; 
        int globalSum = 0;
        int runningSum = 0; 

        // if runningSum < 0 -> runningSum = 0, start += 1
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            globalSum += diff;
            runningSum += diff;
            
            if (runningSum < 0) {
                start = i + 1;
                runningSum = 0; 
            }
        }
        
        // if globalSum is negative -> -1
        // else -> start
        return globalSum >= 0 ? start : -1;
    }
}
