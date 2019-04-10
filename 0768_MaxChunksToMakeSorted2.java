class Solution {
    public static int maxChunksToSorted(int[] arr) {
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i : arr) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        
        HashMap<Integer, Integer> starts = new HashMap<>();
        int s = 0;
        for (int i : arr2) {
            if (!starts.containsKey(i)) {
                starts.put(i, s);
                s += counts.get(i);
            }
        }
        
        int x;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            arr[i] = starts.get(x);
            starts.put(x, starts.get(x) + 1);
        }

        return maxChunksToSorted0(arr);
    }

    public static int maxChunksToSorted0(int[] arr) {
        int chunks = 0;
        int x;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            while (i < x) {
                i++;
                x = Math.max(x, arr[i]);
            }
            chunks++;
        }
        return chunks;
    }
}
