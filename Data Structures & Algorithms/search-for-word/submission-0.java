class Solution {
    public boolean exist(char[][] board, String word) {
        // dfs whenever we see first letter in word
        // - at each recursive call, check if that cell != word[index]
        //      - if yes return false
        // - if letter is valid pass on index + 1, backtrack decrement
        // time: O(n * m * 4^L) -> traverse board (n x m), divide+conquer
        //          4 ways worst case -> 4^L where L = length of word
        // space: O(L) -> L recursive call stacks 

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, i, j, 0) == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, 
                        int col, int index) {
        if (row < 0 || row >= board.length 
            || col < 0 || col >= board[0].length) {
            
            return false; // out of bounds
        }
        
        if (board[row][col] != word.charAt(index)) {
            return false; // if not next letter -> short circuit
        }

        if (index == word.length() - 1) {
            return true;
        }

        char original = board[row][col];
        board[row][col] = '-';

        boolean found =  dfs(board, word, row + 1, col, index + 1) || 
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        board[row][col] = original;

        return found;
    }
}
