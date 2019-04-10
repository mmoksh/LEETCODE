import java.util.*;

class Solution {
    class Counter {
        int occurences, firstIndex, lastIndex;
        public Counter(int occurences, int firstIndex, int lastIndex) {
            this.occurences = occurences;
            this.firstIndex = firstIndex;
            this.lastIndex = lastIndex;
        }
    }
    
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Counter> map = new HashMap<>();
        int max = 0, min = nums.length;
        Counter tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = map.get(nums[i]);
            if (tmp == null) {
                tmp = new Counter(1, i, i);
                map.put(nums[i], tmp);
            } else {
                tmp.occurences++;
                tmp.lastIndex = i;
            }
            
            if (tmp.occurences > max) {
                min = tmp.lastIndex - tmp.firstIndex + 1;
                max = tmp.occurences;
            } else if (tmp.occurences == max) {
                min = Math.min(min, tmp.lastIndex - tmp.firstIndex + 1);
            }
        }
        return min;
    }
}
