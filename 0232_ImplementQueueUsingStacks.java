class MyQueue {
    Stack<Integer> mainStack, secondaryStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        mainStack = new Stack<>();
        secondaryStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!secondaryStack.isEmpty()) {
            return secondaryStack.pop();
        }
        reverseMainStack();
        return secondaryStack.pop();
    }
    
    private void reverseMainStack() {
        while (!mainStack.isEmpty()) {
            secondaryStack.push(mainStack.pop());
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if (!secondaryStack.isEmpty()) {
            return secondaryStack.peek();
        }
        reverseMainStack();
        return secondaryStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.isEmpty() && secondaryStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
