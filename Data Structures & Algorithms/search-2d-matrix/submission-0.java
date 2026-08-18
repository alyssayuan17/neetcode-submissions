class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // if we start from both ends of our array of arrays,
        // take mid from left and right pointers
        // compare first element from the mid pointer 
        // with the target
        // - if equal, return true
        // - if target < mid[0], set right = mid - 1
        // - if target > mid[mid.length-1], set left = mid + 1
        // - if target > mid[0] && target < mid[mid.length-1],
        // we set int left = mid[0], int right = mid[mid.length-1]
        // - continue our looping
        // - return false at end if no returns

        int left = 0;
        int right = matrix.length - 1;
        boolean arrExists = false;
        int[] targetArr = new int[matrix[0].length];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target >= matrix[mid][0] &&
                target <= matrix[mid][matrix[mid].length - 1]) {
                arrExists = true;
                targetArr = matrix[mid];
                left = 0;
                right = matrix[mid].length - 1;
                break;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
                continue;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                left = mid + 1;
                continue;
            }
        }
        
        if (arrExists == true) {
            while (left <= right) {
                int mid = (left + right) / 2;

                if (target == targetArr[mid]) {
                    return true;
                } else if (target > targetArr[mid]) {
                    left = mid + 1;
                    continue;
                } else {
                    right = mid - 1;
                    continue;
                }
            }
        }

        return false;
    }
}
