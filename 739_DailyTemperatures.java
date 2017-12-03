class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ret = new int[temperatures.length];
        int max = temperatures[temperatures.length - 1];
        int index = -1;
        for (int i = 0; i < temperatures.length; i++) {
            index = -1;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    index = j;
                    break;
                }
            }
            ret[i] = index > 0? index - i: 0;
        }
        return ret;
    }
}
