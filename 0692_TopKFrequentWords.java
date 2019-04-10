import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        TreeMap<Counter, Integer> tree = new TreeMap<>();
        map.keySet().forEach((string) -> {
            tree.put(new Counter(string, map.get(string)), 0);
        });
        
        for (Counter counter : tree.descendingKeySet()) {
            if (k == 0) {
                break;
            }
            list.add(counter.word);
            k--;
        }
        return list;
    }
}

class Counter implements Comparable<Counter> {
    String word;
    int count;
    public Counter(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    @Override
    public int compareTo(Counter o) {
        if (count != o.count) {
            return count - o.count;
        }
        
        return o.word.compareTo(word);
    }
}
