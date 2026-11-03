class Solution {
    List<String> toReturn = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // at each open parenthesis '(', we have two options:
        //      1. close the bracket next
        //      2. open the next '('
        // keep track of open and close -> open is # of open parenthesis,
        // close is # of close parenthesis
        // base case: if open == n && close == n, add the curr string to list 
        // time: O(n * 2^n) -> divide and conquer 2 options, processing each is O(n)
        // space: O(n) -> building each string 

        StringBuilder buildString = new StringBuilder();

        dfs(n, 0, 0, buildString); 

        return toReturn;
    }

    public void dfs(int n, int open, int close, StringBuilder buildString) {
        if (open == n && close == n) {
            toReturn.add(buildString.toString());
            return;
        }

        // open the next bracket
        if (open < n) {
            buildString.append("(");
            dfs(n, open + 1, close, buildString); 
            buildString.deleteCharAt(buildString.length() - 1);
        }

        // close the bracket
        if (close < open) {
            buildString.append(")");
            dfs(n, open, close + 1, buildString);
            buildString.deleteCharAt(buildString.length() - 1);
        }
    }
}
