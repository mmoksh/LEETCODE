class Trie {
    Trie[] children;
    public Trie() {
        children = new Trie[2];
    }
}

class Solution {
    Trie root;
    public int[] maximizeXor(int[] nums, int[][] q) {
        int[] result = new int[q.length];
        root = new Trie();
        int[][] queries = new int[q.length][3];
        for (int i = 0; i < q.length; i++) {
            queries[i][0] = q[i][0];
            queries[i][1] = q[i][1];
            queries[i][2] = i;
        }
        
        Arrays.sort(nums);
        Arrays.sort(queries, (a, b) -> a[1] - b[1]);
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            while (index < nums.length && nums[index] <= queries[i][1]) {
                addToTrie(nums[index++]);
            }
            if (queries[i][1] < nums[0]) {
                result[queries[i][2]] = -1;
            } else {
                result[queries[i][2]] = findMax(queries[i][0]);
            }
        }
        return result;
    }
    
    public void addToTrie(int num) {
        int currentDigit;
        Trie currentNode = root;
        for (int i = 31; i >= 0; i--) {
            currentDigit = (num >>> i) & 1;
            if (currentNode.children[currentDigit] == null) {
                currentNode.children[currentDigit] = new Trie();
            }
            currentNode = currentNode.children[currentDigit];
        }
    }
    
    public int findMax(int num) {
        int currentDigit;
        Trie currentNode = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            currentDigit = (num >>> i) & 1;
            if (currentNode.children[currentDigit ^ 1] != null) {
                res += 1 << i;
                currentNode = currentNode.children[currentDigit ^ 1];
            } else {
                currentNode = currentNode.children[currentDigit];
            }
        }
        return res;
    }
}
