class MinStack {
    List<Integer> stack;
    Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList();
    }
    
    public void push(int x) {
        stack.add(0, x);
        if (min == null || x < min) min = x;
    }
    
    public void pop() {
        int num = stack.remove(0);
        if (num == min) {
            updateMin();
        }
    }
    
    private void updateMin() {
        if (stack.size() == 0) {
            min = null;
            return;
        }
        min = stack.get(0);
        for (int num: stack) {
            if (num < min) min = num;
        }
    }
    
    public int top() {
        return stack.get(0);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
