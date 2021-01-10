class Solution {
    static char [] str;
    public static int maximumGain(char a, char b) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c: str) {
            if (c == b) {
                if (!stack.isEmpty() && stack.peek() == a) {
                    stack.pop();
                    count++;
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        str = new char[stack.size()];
        for (int i = str.length - 1; i >= 0; i--) {
            str[i] = stack.pop();
        }
        return count;
    }
    
    public static int maximumGain(String s, int x, int y) {
        str = s.toCharArray();
        if (x > y) {
            return x * maximumGain('a', 'b') + y * maximumGain('b', 'a');
        }
        return y * maximumGain('b', 'a') + x * maximumGain('a', 'b');
    }
}
