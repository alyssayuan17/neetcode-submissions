class Solution {
    public boolean isValid(String s) {
        // use a deque/stack structure to store each time we see
        // an open parenthesis via stack.push
        // keep incrementing on string s, when s.charAt(i) is 
        // equal to the closing parenthesis of stack.peek(), then
        // stack.pop and continue
        // at the end, return stack.isEmpty
        // if true, then valid, if false, not all parenthesis were
        // enclosed/not in the correct order

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (s.charAt(i) == '(' || 
                s.charAt(i) == '{' || 
                s.charAt(i) == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; 
                }

                if ((stack.peek() == '(' && c == ')') ||
                    (stack.peek() == '{' && c == '}') ||
                    (stack.peek() == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
