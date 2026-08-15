class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        // need a stack
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // check if current top of minStack is greater,
        // if so, push val to be new top of minStack
        // if empty, push directly
        if (minStack.isEmpty() || 
            (!minStack.isEmpty() && minStack.peek() >= val)) {
            minStack.push(val);
        } 
    }
    
    public void pop() {
        if (!minStack.isEmpty() && minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
