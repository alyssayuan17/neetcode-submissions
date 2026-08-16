class Solution {
    public int evalRPN(String[] tokens) {
        // 1 + 2 = 3 -> pop 1 and 2, push result: 3
        // 3 * 3 = 9 -> pop 3 and 3, push result: 9
        // 9 - 4 = 5 -> pop 9 and 4, 
        // push 5 to top, so return stack.peek()
        // use a stack to store our running result
        // whenever we see an operand, perform that operation
        // on the two values we just popped 
        // push result on top of stack once again

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
