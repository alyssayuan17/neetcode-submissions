class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // since it is non-decreasing, if the first two
        // sum to a smaller number than the target, we 
        // move both pointers up. If the result is larger than
        // target, decrement the left pointer

        // numbers = [1,2,3,4,5,6,7,8,9], target = 7
        // numbers[left] = 1, numbers[right] = 2, 1 + 2 = 3
        // 3 < 7
        // numbers[left] = 2, numbers[right] = 3, 2 + 3 = 5
        // 5 < 7
        // numbers[left] = 3, numbers[right] = 4, 3 + 4 = 7

        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
                continue;
            }

            if (numbers[left] + numbers[right] > target) {
                right--;
                continue;
            }
        }

        return new int[] {left + 1, right + 1};
    }
}
