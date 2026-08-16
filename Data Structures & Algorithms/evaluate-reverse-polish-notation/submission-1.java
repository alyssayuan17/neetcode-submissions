class Solution {
    public int evalRPN(String[] tokens) {
        // 1 + 2 = 3
        // 3 * 3 = 9
        // 9 - 4 = 5 -> push 5 to top, so return stack.peek()
        // [1,2,3,9,5]
        // use a stack to store our running result
        // whenever we see an operand, perform that operation
        // on the val we pop from stack and stack.peek, then
        // push result on top of stack once again

        // 

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop(); 
                int result = b + a;
                stack.push(result);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop(); 
                int result = b - a;
                stack.push(result);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop(); 
                int result = b * a;
                stack.push(result);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop(); 
                int result = b / a;
                stack.push(result);
            } else {
                int current = Integer.parseInt(tokens[i]);
                stack.push(current);
            }
        }

        return stack.peek();
    }
}
