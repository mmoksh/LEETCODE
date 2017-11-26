class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int p;
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                p = -asteroid;
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < p) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == p) {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() > p) {
                    
                } else {
                    stack.push(asteroid);
                }
            }
        }
        int [] ret = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
