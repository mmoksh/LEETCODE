import java.util.*;
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int temp;
        for (String op: ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    temp = stack.pop() + stack.peek();
                    stack.push(temp - stack.peek());
                    stack.push(temp);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
