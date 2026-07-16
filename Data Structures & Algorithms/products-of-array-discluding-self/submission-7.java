class Solution {
    public int[] productExceptSelf(int[] nums) {

        // O(n) solution
        
        int[] output = new int[nums.length];

        output[0] = 1;

        // to build an arr of the products of all nums before it
        // for ex. [1,2,4,6] -> [1,1,2,8]
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }

        int running_prod = 1;

        // to build on the current arr to multiply in the 
        // nums from the right
        // for ex. [1,2,4,6] -> [1,1,2,8] -> [48,24,12,8]
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((i + 1) == nums.length) {
                continue;
            }

            running_prod *= nums[i+1];

            output[i] *= running_prod;
        }

        return output;
    }
}  
